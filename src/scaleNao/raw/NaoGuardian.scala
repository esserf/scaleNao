package scaleNao.raw

import scaleNao.raw.messages.Nao
import akka.actor.Actor
import akka.actor.Props
import akka.actor.OneForOneStrategy
import akka.util.Duration
import scaleNao.raw.messages._
import akka.actor.ActorRef

class NaoGuardian extends Actor {
  val naoActor = context.actorOf(Props[NaoActor], name = "NaoActor")
  trace("is started: " + self)
  import akka.actor.SupervisorStrategy._
  import context._

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = Duration(1, "minute")) {
      case _: ArithmeticException ⇒ Resume
      case _: NullPointerException ⇒ Restart
      case _: IllegalArgumentException ⇒ Stop
      case _: Exception ⇒ Escalate
    }
  context.watch(naoActor)

  def receive = {
    case n: Nao => naoActor ! (sender, n)
    case x => !!!(x, "receive")
  }

  //  def binding: Receive(bindings:Map[()]) = {
  //    case n: Nao => naoActor ! (sender,n)
  //    case x => !!!(x,"receive")
  //  }

  private def !!!(x: Any, state: String) = {
    val msg = "wrong message: " + x + " at " + state
    error(msg)
    sender ! msg
  }
  private def trace(a: Any) = println("NaoGuardian: " + a)
  private def error(a: Any) = trace("error: " + a)
  private def wrongMessage(a: Any, state: String) = error("wrong messaage: " + a + " at " + state)
}