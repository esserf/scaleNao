package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef
import akka.zeromq.Connecting

class NaoMessageActor extends Actor {

  import akka.zeromq.ZMQMessage
  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Conversions
  import context._
  import NaoAdapter.value._
  trace("is started: " + self)

  import akka.zeromq.Connecting
  def receive = {
    case (nao:Nao,userActor: ActorRef, c: Call) =>{
      trace("request: " + c)
      val nia = connect(nao)
      nia.socket ! z.MQ.request(c)
      become(waitOnAnswer(nia, userActor,c))
    }
    case Connecting => trace("Connecting on receive")       
    case x => wrongMessage(x, "receive")
  }

  private def waitOnAnswer(nia: NaoInAction, userActor: ActorRef,c:Call): Receive = {
    case m: ZMQMessage => {
      userActor ! z.MQ.answer(ProtoDeserializer(m.frames),c)
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
  private def trace(a: Any) = if (Logging.NaoMessageActor.info)  log.info(a.toString)
  private def error(a: Any) = if (Logging.NaoMessageActor.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (Logging.NaoMessageActor.wrongMessage) log.warning("wrong message: " + a)
  import akka.event.Logging
  val log = Logging(context.system, this)
}