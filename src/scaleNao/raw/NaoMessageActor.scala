package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef
import akka.zeromq.Connecting
import akka.dispatch.Terminate

class NaoMessageActor extends Actor {

  import akka.zeromq.ZMQMessage
  import scaleNao.raw.z.MQ._
  import NaoAdapter.value._
  import NaoAdapter.value.Hawactormsg._
  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Messages._
  import context._
  import NaoAdapter.value._
  trace("is started: " + self)

  import akka.zeromq.Connecting
  def receive = {
    case (nao:Nao,userActor: ActorRef, c: Call) =>{
      trace("request: " + c)
      val nia = connect(nao)
      nia.socket ! request(c)
      become(waitOnAnswer(nia, userActor,c))
    }
    case Connecting => trace("Connecting on receive")       
    case x => wrongMessage(x, "receive")
  }

  private def waitOnAnswer(nia: NaoInAction, userActor: ActorRef,c:Call): Receive = {
    case m: ZMQMessage => {
      userActor ! answer(ProtoDeserializer(m.frames),c)
//      self ! Terminate
    }
    case Connecting => trace("Connecting on waitOnAnswer") 
    case x => wrongMessage(x, "waitOnAnswer")
  }

  private def connect(nao: Nao) = {
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

  private def !!!(x: Any, state: String) = {
    val msg = "wrong message: " + x + " at " + state
    error(msg)
    sender ! msg
  }
  private def trace(a: Any,force:Boolean = false) = if (Logging.NaoGuardian.info) println("NaoMessageActor: " + a)
  private def error(a: Any,force:Boolean = false) = if (Logging.NaoGuardian.error) trace("error: " + a,true)
  private def wrongMessage(a: Any, state: String,force:Boolean = false) = if (Logging.NaoGuardian.wrongMessage) error("wrong messaage: " + a + " at " + state,true)
}