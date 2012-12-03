package scaleNao.raw

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorRef

import akka.actor.OneForOneStrategy

class NaoGuardian extends Actor {
  
  import akka.actor.SupervisorStrategy._
  import scala.collection.immutable.HashMap
  import scala.concurrent.duration._
  import scaleNao.raw.messages.Nao
  import scaleNao.raw.messages._
  import context._

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
      case _: ArithmeticException => Resume
      case _: NullPointerException => Restart
      case _: IllegalArgumentException => Stop
      case _: Exception => Escalate
    }

  def receive = {
    case s: Subscribe => {
      val naoActor = context.actorOf(Props[NaoActor])
      context.watch(naoActor)
      naoActor.forward(s)
      become(binding(new HashMap() + (s.nao -> (naoActor, List(sender)))))
    }
    case Unsubscribe(n) => sender ! NotUnsubscribable(n)
    case x => wrongMessage(x, "receive")
  }

  def binding(bindings: Map[Nao, (ActorRef, List[ActorRef])]): Receive = {
    case s: Subscribe => {
      trace("bindings: " + bindings)
      val bind = bindings.get(s.nao)
      if (bind.isDefined) {
        trace("nao is defined")
        if (!bind.get._2.contains(sender)) {
          bind.get._1.forward(s)
          become(binding(bindings + (s.nao -> (bind.get._1, sender :: bind.get._2))))
        } else
          sender ! AlreadySubscribed(s.nao)
      } else {
        trace("new nao")
        val naoActor = context.actorOf(Props[NaoActor])
        context.watch(naoActor)
        naoActor.forward(s)
        trace(s.nao, (naoActor, List(sender)))
        trace(bindings + (s.nao -> (naoActor, List(sender))))
        become(binding(bindings + (s.nao -> (naoActor, List(sender)))))
      }
    }
    case s: Unsubscribe => {
      val bind = bindings.get(s.nao)
      trace("Unsubscribe in: " + bind)
      if (bind.isDefined) {
        trace("nao is defined")
        if (bind.get._2.contains(sender)) {
          if (bind.get._2.size == 1) {
            trace("letzte")
            bind.get._1.forward(s)
            become(binding(bindings - (s.nao)))
          } else {
            bind.get._1.forward(s)
            become(binding(bindings + (s.nao -> (bind.get._1, remove(bind.get._2,sender)))))
          }
        } else
          sender ! NotUnsubscribable(s.nao)
      } else {
        sender ! NotUnsubscribable(s.nao)
      }
    }
    case x => wrongMessage(x, "receive")
    //    case 
  }

  // throws a MatchError exception if i isn't found in li
  def remove[A](li: List[A], i: A) = {
    val (head, _ :: tail) = li.span(i != _)
    head ::: tail
  }

  private def trace(a: Any) = if (LogConf.NaoGuardian.info) log.info(a.toString)
  private def error(a: Any) = if (LogConf.NaoGuardian.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (LogConf.NaoGuardian.wrongMessage) log.warning("wrong message: " + a + " in " + state)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)
}