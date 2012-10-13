package scaleNao.raw

import scaleNao.raw.messages._
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import akka.zeromq.ZMQMessage

class NaoActor extends Actor {

  import scaleNao.raw.messages._
  import context._
  trace("is started: " + self)
  
  def receive = {
    case (userActor: ActorRef, nao: Nao) =>
      {
        trace(nao + " comes in")
        val nia = connect(nao)
        if (nia.isAvailable) {
          trace("is available")
          userActor ! NaoReceived(nao)
          become(communicating(nia))
        } else {
          trace("is NOT available")
          userActor ! NaoNotFound(nao)
        }
      }
    case x => !!!(x, "receive")
  }

  /**
   * TODO watching:not implemented yet
   */
  def watching(nia: NaoInAction) = {
    trace("TODO watching:not implemented yet")
  }

  import scaleNao.qi._
  def communicating(nia: NaoInAction): Receive = {
    case Call(Audio.TextToSpeech.say(x: String)) => {
      trace("I should say " + x + "? - Its done. ")
        
      request(nia.socket,"ALTextToSpeech", "say",List(x))
      sender ! Audio.TextToSpeech.TextDone
    }
    case m: OutMessage => {
      trace("new message comes in: " + m)
    }
    case x => !!!(x, "receive")
  }
  
//  def answer(socket:ActorRef) = {
//    val protoResponse = HAWActorRPCResponse.parseFrom(socket.recv(0))
//    if (protoResponse.hasError) {
//      trace("Error: " + protoResponse.getError)
//    } else if (protoResponse.hasReturnval) {
//      trace("-> " + Mixer.toString(protoResponse.getReturnval))
//    } else {
//      trace("-> Empty \n");
//    }
//  }

  import NaoAdapter.value.Hawactormsg._
  import NaoAdapter.value.Mixer
  def request(socket:ActorRef,module: String, method: String, params: List[MixedValue]) {
    val param = HAWActorRPCRequest.newBuilder().setModule(module).setMethod(method);
    for (mixed <- params)
      param.addParams(mixed)
    val msg = ZMQMessage(param.build)
    trace(socket + " ! " +  msg )
    socket ! msg  
  }

  implicit def string2Mixed(s: String) = MixedValue.newBuilder().setString(s).build()

  /**
   * TODO connect:not implemented yet
   */
  def connect(nao: Nao) = {
    import akka.zeromq._   
    val address = "tcp://" + nao.host + ":" + nao.port
    val zmq = ZeroMQExtension(system).newSocket(SocketType.Req, Bind(address))
//    val zmqProps = ZeroMQExtension(system).newSocketProps(SocketType.Req, Bind(address))
//    context.actorFor("../../zeromq") // zmq guardian
//    context.actorFor("../../zeromq") ! zmqProps
    trace("zmq Actor is started: " + zmq)
    Available(nao,zmq)  
  }

  def !!!(x: Any, state: String) = {
    val msg = "wrong message: " + x
    error(msg)
    sender ! msg
  }
  def trace(a: Any) = println("NaoActor: " + a)
  def error(a: Any) = trace("error: " + a)
  def wrongMessage(a: Any, state: String) = error("wrong messaage: " + a)
}