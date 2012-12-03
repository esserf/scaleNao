package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.actor.Status.Success
import akka.util.Timeout
import scala.concurrent.duration._

private class NaoActor extends Actor {

  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Conversions
  import context._

  def receive = {
    case Subscribe(nao: Nao) => {
      trace(nao + " comes in")
      check(nao)
      val checkActor = context.actorOf(Props[NaoCheckActor])
      check(nao)
            context.watch(checkActor)
            checkActor ! nao
      become(checkConnection(nao,List(sender)))
    }
    case x => wrongMessage(x, "receive")
  }

  private def check(nao: Nao): Unit = {
    val messageActor = context.actorOf(Props[NaoMessageActor])
    import akka.pattern.{ ask, pipe }
    val f = messageActor.ask(nao, self, Call(Module("test"), Method("test")))(Timeout(5 seconds))
    f onFailure {
      case x => {
        self ! NaoTimeOut
        check(nao)
      }
    }
  }

  /**
   * TODO watching:not implemented yet
   */
  private def watching(nia: NaoInAction) = {
    trace("TODO watching:not implemented yet")
  }

  private def communicating(n: Nao): Receive = {
    case Subscribe => {
      sender ! Subscribed(n)
    }
    case Unsubscribe => {
      sender ! Unsubscribed(n)
    }
    case c: OutMessage => {
      val messageActor = context.actorOf(Props[NaoMessageActor])
      trace("request: " + c + " " + messageActor)
      messageActor ! (n, sender, c)
    }
    case c: Answering =>
    case NaoTimeOut =>
    case x => wrongMessage(x, "communicating")
  }

  /**
   * TODO isConnectable: is not implemented yet
   */
  private def checkConnection(nao: Nao, waiters: List[ActorRef] = Nil): Receive = {
    case c: Answering => {
      trace("is available")
      for (w <- waiters)
        w ! Subscribed(nao)
      become(communicating(nao))
    }
    case NaoTimeOut => {
      trace("is NOT available")
      for (w <- waiters)
        w ! NotSubscribable(nao)
    }
    case Subscribe(n) => {
      if (n == nao)
        become(checkConnection(nao, sender :: waiters))
    }
    case Unsubscribe(n) => {
      trace("try unsubscribing: " + sender)
      if (n == nao && waiters.contains(sender)) {
        become(checkConnection(nao, remove(waiters,sender)))
        trace("unsubscribing: " + sender)
        sender ! Unsubscribed(n)
      }
    }
    case x => wrongMessage(x, "checkConnection")
  }

  // throws a MatchError exception if i isn't found in li
  def remove[A](li: List[A], i: A) = {
    val (head, _ :: tail) = li.span(i != _)
    head ::: tail
  }
  
  private def trace(a: Any) = if (LogConf.NaoActor.info) log.info(a.toString)
  private def error(a: Any) = if (LogConf.NaoActor.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (LogConf.NaoActor.wrongMessage) log.warning("wrong message: " + a + " in " + state)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)

}

