package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef
import akka.zeromq.ConcurrentSocketActor
import org.zeromq.ZMQ.Socket

private class NaoSynchronActor extends Actor {

  import akka.zeromq.ZMQMessage
  import NaoAdapter.value._
  import NaoAdapter.value.Hawactormsg._
  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Conversions
  import context._
  import NaoAdapter.value._

  def receive = {
    case (userActor: ActorRef, nao: Nao) =>
      {
        trace(nao + " comes in")
        val address = "tcp://" + nao.host + ":" + nao.port
        val socket = zMQ.socket(url = address)

          userActor ! Subscribed(nao)
          become(communicating(socket))
        
      }
    case x => wrongMessage(x, "receive")
  }

  /**
   * TODO watching:not implemented yet
   */
  private def watching(nia: NaoInAction) = {
    trace("TODO watching:not implemented yet")
  }
  
  object zMQ {
    import org.zeromq.ZContext
    def context = new ZContext
    def socket(cont: ZContext = context, url: String) = {
      import org.zeromq.ZMQ._
      val socket = cont.createSocket(REQ)
      socket.connect(url)
      socket
    }
  }
  
  import akka.zeromq.Connecting
  private def communicating(socket: Socket): Receive = {
    case c: Call => {
      trace("request: " + c)
      socket.send(ProtoSerializer(z.MQ.request(c)),0)
      sender ! z.MQ.answer(ProtoDeserializer(socket.recv(0)), c)
    }
    case Connecting =>
    case x => wrongMessage(x, "communicating")
  }

  private def trace(a: Any) = if (LogConf.NaoActor.info) log.info(a.toString)
  private def error(a: Any) = if (LogConf.NaoActor.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (LogConf.NaoActor.wrongMessage) log.warning("wrong message: " + a + " in " + state)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)
}