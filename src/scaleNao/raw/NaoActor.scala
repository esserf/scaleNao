package scaleNao.raw

import scaleNao.raw.messages._
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import akka.zeromq.ZMQMessage
import scaleNao.raw.messages.Messages._
import NaoAdapter.value.Hawactormsg.MixedValue
import NaoAdapter.value.Hawactormsg.HAWActorRPCResponse
import NaoAdapter.value.Mixer
import NaoAdapter.value.ProtoDeserializer

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

  import akka.zeromq.Connecting
  import scaleNao.qi._
  def communicating(nia: NaoInAction): Receive = {
    case Call(Module(module: Symbol), Method(method: Symbol), parameter: List[MixedValue]) => {
      request(nia.socket, module, method, parameter)
      become(waitOnAnswer(nia, sender))
    }
    case Connecting =>
    case x => !!!(x, "communicating")
  }

  def waitOnAnswer(nia: NaoInAction, userActor: ActorRef): Receive = {
    case m: ZMQMessage => {
      trace("Answer from Nao: " + m)     
      userActor ! answer(ProtoDeserializer(m.frames))
    }
    case Connecting =>
    case x => !!!(x, "waitOnAnswer")
  }

  def answer(protoResponse: HAWActorRPCResponse) = {
    ZMQMessage(protoResponse)
    if (protoResponse.hasError) {
      trace("Error: " + protoResponse.getError)
      None
    } else if (protoResponse.hasReturnval) {
      val m = Mixer.toString(protoResponse.getReturnval)
      trace("-> " + m)
      Some(m)
    } else {
      trace("-> Empty \n");
      None
    }
  }

  import NaoAdapter.value.Hawactormsg._
  import NaoAdapter.value.Mixer
  def toString(params: List[MixedValue]): String = {
    if (params.isEmpty)
      ""
    else
      "(" + params.first.getString() + ")" + toString(params.tail)
  }

  def request(socket: ActorRef, module: String, method: String, params: List[MixedValue]) {
    trace("request: " + module + "." + method + "" + toString(params))
    val param = HAWActorRPCRequest.newBuilder().setModule(module).setMethod(method);
    for (mixed <- params)
      param.addParams(mixed)
    socket ! ZMQMessage(param.build)
  }

  def connect(nao: Nao) = {
    import akka.zeromq._
    import NaoAdapter.value.ProtoDeserializer
    val address = "tcp://" + nao.host + ":" + nao.port
    val zmq = ZeroMQExtension(system).newSocket(
        SocketType.Req, 
        Connect(address), 
        Listener(self))
//        ProtoDeserializer) // match error
    trace("zmq Actor is started: " + zmq + " connected with " + address + "(SocketType:Req)")
    Available(nao, zmq) // connecting check not implemented yet
  }

  def !!!(x: Any, state: String) = {
    val msg = "wrong message: " + x + " at " + state
    error(msg)
    sender ! msg
  }
  def trace(a: Any) = println("NaoActor: " + a)
  def error(a: Any) = trace("error: " + a)
  def wrongMessage(a: Any, state: String) = error("wrong messaage: " + a + " at " + state)
}