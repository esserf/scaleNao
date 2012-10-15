package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef

class NaoActor extends Actor {
  
  import akka.zeromq.ZMQMessage
  import scaleNao.raw.z.MQ._
  import NaoAdapter.value._
  import NaoAdapter.value.Hawactormsg._
  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Messages._
  import context._
  import NaoAdapter.value._
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
      trace("request: " + module + "." + method + "" + z.MQ.toString(parameter))
      nia.socket ! request(module, method, parameter)
      become(waitOnAnswer(nia, sender,Call(module,method,parameter)))
    }
    case Connecting =>
    case x => !!!(x, "communicating")
  }

  def waitOnAnswer(nia: NaoInAction, userActor: ActorRef,c:Call): Receive = {
    case m: ZMQMessage => {
      trace(m)
      userActor ! answer(ProtoDeserializer(m.frames),c)
      unbecome
    }
    case Connecting =>
    case x => !!!(x, "waitOnAnswer")
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