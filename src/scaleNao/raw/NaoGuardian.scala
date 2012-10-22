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
  //  val naoActor = 
  import akka.actor.SupervisorStrategy._
  import context._

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = Duration(1, "minute")) {
      case _: ArithmeticException => Resume
      case _: NullPointerException => Restart
      case _: IllegalArgumentException => Stop
      case _: Exception => Escalate
    }

  def receive = {
    case n: Nao => {
      val naoActor = context.actorOf(Props[NaoActor])
      context.watch(naoActor)
      naoActor ! (sender, n)
      become(binding(new HashMap() + (n -> (naoActor, List(sender)))))
    }
    case x => wrongMessage(x, "receive")
  }

  def binding(bindings: Map[Nao, (ActorRef, List[ActorRef])]): Receive = {
    case n: Nao => {
      trace("bindings: " + bindings)
      val bind = bindings.get(n)
      if (bind.isDefined) {
        trace("nao is defined")
        if (!bind.get._2.contains(sender)) {
          bind.get._1 ! sender
          become(binding(bindings + (n -> (bind.get._1, sender :: bind.get._2))))
        } else
          sender ! AlreadySubscribed(n)
      } else {
        trace("new nao")
        val naoActor = context.actorOf(Props[NaoActor])
        naoActor ! (sender,n)
        trace(n, (naoActor, List(sender)))
        trace(bindings + (n -> (naoActor, List(sender))))
        become(binding(bindings + (n -> (naoActor, List(sender)))))
      }

      //      naoActor ! (sender, n)
    }
    case x => wrongMessage(x, "receive")
  }

  private def trace(a: Any) = if (LogConf.NaoGuardian.info) log.info(a.toString)
  private def error(a: Any) = if (LogConf.NaoGuardian.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (LogConf.NaoGuardian.wrongMessage) log.warning("wrong message: " + a + " in " + state)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)
}