package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.actor.Status.Success


private class NaoActor extends Actor {

  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Conversions
  import context._

  def receive = {
    case (userActor: ActorRef, Subscribe(nao: Nao)) =>
      {
        trace(nao + " comes in")
        import akka.util.Duration

        import akka.pattern.ask
        import akka.util.Timeout
        val timeout = Timeout(Duration(5,"seconds"))
        // isConnectable
        val messageActor = context.actorOf(Props[NaoMessageActor])
        import akka.pattern.ask
        val f = messageActor.ask(nao, self, Call(Module("test"), Method("test")))(Duration(5,"seconds"))
        f onFailure{
            case x => self ! 'Fail
        }
        
        become(checkConnection(userActor, nao))
      }

    case x => wrongMessage(x, "receive")

  }

  /**
   * TODO watching:not implemented yet
   */
  private def watching(nia: NaoInAction) = {
    trace("TODO watching:not implemented yet")
  }

  private def communicating(n: Nao): Receive = {
    case userActor: ActorRef => {
      userActor ! Subscribed(n)
    }
    case c: OutMessage => {
      val messageActor = context.actorOf(Props[NaoMessageActor])
      trace("request: " + c + " " + messageActor)
      messageActor ! (n, sender, c)
    }
    case x => wrongMessage(x, "communicating")
  }

  /**
   * TODO isConnectable: is not implemented yet
   */

  private def checkConnection(userActor: ActorRef, nao: Nao,waiters:List[ActorRef] = Nil): Receive = {
    case c:Answering => {
      trace("is available")
      userActor ! Subscribed(nao)
      for(w <- waiters)
         userActor ! Subscribed(nao)
      become(communicating(nao))
    }
    case 'Fail => {
      trace("is NOT available")
      userActor ! NotSubscribable(nao)
      for(w <- waiters)
         userActor ! NotSubscribable(nao)
      context.stop(self)
    }
    case r:ActorRef => {
      become(checkConnection(userActor,nao,r::waiters))
    }
    case x => wrongMessage(x,"checkConnection")
  }

  private def trace(a: Any) = if (LogConf.NaoActor.info) log.info(a.toString)
  private def error(a: Any) = if (LogConf.NaoActor.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (LogConf.NaoActor.wrongMessage) log.warning("wrong message: " + a + " in " + state)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)

}

