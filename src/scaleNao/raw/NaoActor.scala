package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.actor.Status.Success
import akka.dispatch.Future

private class NaoActor extends Actor {

  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Conversions
  import context._

  private case object NaoTimeOut

  def receive = {
    case Subscribe(nao: Nao) =>
      {
        trace(nao + " comes in")
        check(nao)
        become(checkConnection(sender, nao))
      }

    case x => wrongMessage(x, "receive")

  }

  private def check(nao: Nao): Unit = {
    import akka.util.Duration
    val messageActor = context.actorOf(Props[NaoMessageActor])
    import akka.pattern.ask
    val f = messageActor.ask(nao, self, Call(Module("test"), Method("test")))(Duration(5, "seconds"))
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
    case x => wrongMessage(x, "communicating")
  }

  /**
   * TODO isConnectable: is not implemented yet
   */
  private def checkConnection(userActor: ActorRef, nao: Nao, waiters: List[ActorRef] = Nil): Receive = {
    case c: Answering => {
      trace("is available")
      userActor ! Subscribed(nao)
      for (w <- waiters)
        w ! Subscribed(nao)
      become(communicating(nao))
    }
    case NaoTimeOut => {
      trace("is NOT available")
      userActor ! NotSubscribable(nao)
      for (w <- waiters)
        w ! NotSubscribable(nao)
    }
    case Subscribe(n) => {
      if (n == nao)
        become(checkConnection(userActor, nao, sender :: waiters))
    }
    case Unsubscribe(n) => {
      if (n == nao || waiters.contains(sender)) {
        become(checkConnection(userActor, nao, waiters - sender))
        sender ! Unsubscribed(n)
      } 
    }
    case x => wrongMessage(x, "checkConnection")
  }

  private def trace(a: Any) = if (LogConf.NaoActor.info) log.info(a.toString)
  private def error(a: Any) = if (LogConf.NaoActor.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (LogConf.NaoActor.wrongMessage) log.warning("wrong message: " + a + " in " + state)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)

}

