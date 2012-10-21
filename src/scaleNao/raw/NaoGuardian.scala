package scaleNao.raw

import scaleNao.raw.messages.Nao
import akka.actor.Actor
import akka.actor.Props
import akka.actor.OneForOneStrategy
import akka.util.Duration
import scaleNao.raw.messages._
import akka.actor.ActorRef
import scala.collection.immutable.HashMap

class NaoGuardian extends Actor {
  val naoActor = context.actorOf(Props[NaoActor], name = "NaoActor")
  import akka.actor.SupervisorStrategy._
  import context._

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = Duration(1, "minute")) {
      case _: ArithmeticException => Resume
      case _: NullPointerException => Restart
      case _: IllegalArgumentException => Stop
      case _: Exception => Escalate
    }
  context.watch(naoActor)

  def receive = {
    case n: Nao => {
      naoActor ! (sender, n)
      binding(new HashMap() + (n -> (naoActor, List(sender))))
    }
    case x => !!!(x, "receive")
  }

  def binding(bindings: Map[Nao, (ActorRef, List[ActorRef])]): Receive = {
    case n: Nao => naoActor ! (sender, n)
    case x => !!!(x, "receive")
  }

  private def !!!(x: Any, state: String) = {
    val msg = "wrong message: " + x + " at " + state
    error(msg)
    sender ! msg
  }
  private def trace(a: Any) = if (Logging.NaoGuardian.info) log.info(a.toString)
  private def error(a: Any) = if (Logging.NaoGuardian.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (Logging.NaoGuardian.wrongMessage) log.warning("wrong message: " + a  + " in "+ state)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)
}