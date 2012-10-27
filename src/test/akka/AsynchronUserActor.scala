package test.akka
import scaleNao.raw._
import scaleNao.raw.messages.Conversions._
import scaleNao.raw.messages._
import scaleNao.raw.messages.Subscribed
import akka.actor.Actor
import akka.actor.ActorRef

class AsynchronUserActor extends Actor {
  import context._

  val naoGuardian = scaleNao.System.naoGuardian
  val nao = Nao("Nila", "127.0.0.1", 5555)

  override def preStart {
    trace("SimpleAkkaCommunicationTest with " + nao)
    naoGuardian ! Subscribe(nao)
  }

  val f = 1
  val num = 10

  def receive = {
    case Subscribed(nao) => {
      trace("naoActor received: " + (nao, sender))
      for (i <- 0 to num)
        sender ! Call('ALTextToSpeech, 'say, List(("Asynchron" + i) * f))
      become(answer(sender, System.currentTimeMillis))
    }
    case x => wrongMessage(x)
  }
  def answer(userActor: ActorRef, t0: Long, n: Int = 1): Receive = {
    case x: Answer => {
      trace("Answer(" + n + "):" + x + " (" + (System.currentTimeMillis - t0) / n + "ms)")
      if (n % num == 0) {
        for (i <- 0 to num)
          userActor ! Call('ALTextToSpeech, 'say, List(("Asynchron" + i) * f))
        for (i <- 0 to num)
          userActor ! Call('ALTextToSpeech, 'getVolume)
        become(answer(userActor, t0, (n + 1)))
      } else
        become(answer(userActor, t0, n + 1))
    }
    case x => wrongMessage(x)
  }
  def trace(a: Any) = log.info(a.toString)
  def error(a: Any) = log.warning(a.toString)
  def wrongMessage(a: Any) = error("wrong message: " + a)
  import akka.event.Logging
  val log = Logging(context.system, this)
}