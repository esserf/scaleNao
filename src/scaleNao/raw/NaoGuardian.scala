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
    case s: Subscribe => {
      val naoActor = context.actorOf(Props[NaoActor])
      context.watch(naoActor)
      naoActor ! (sender, s)
      become(binding(new HashMap() + (s.nao -> (naoActor, List(sender)))))
    }
    case x => wrongMessage(x, "receive")
  }

  def binding(bindings: Map[Nao, (ActorRef, List[ActorRef])]): Receive = {
    case s: Subscribe => {
      trace("bindings: " + bindings)
      val bind = bindings.get(s.nao)
      if (bind.isDefined) {
        trace("nao is defined")
        if (!bind.get._2.contains(sender)) {
          bind.get._1 ! sender
          become(binding(bindings + (s.nao -> (bind.get._1, sender :: bind.get._2))))
        } else
          sender ! AlreadySubscribed(s.nao)
      } else {
        trace("new nao")
        val naoActor = context.actorOf(Props[NaoActor])
        naoActor ! (sender,s)
        trace(s.nao, (naoActor, List(sender)))
        trace(bindings + (s.nao -> (naoActor, List(sender))))
        become(binding(bindings + (s.nao -> (naoActor, List(sender)))))
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