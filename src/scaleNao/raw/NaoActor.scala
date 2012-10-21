package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props

private class NaoActor extends Actor {

  import scaleNao.raw.messages._
  import context._  

  def receive = {
    case (userActor: ActorRef, nao: Nao) =>
      {
        trace(nao + " comes in")
        if (isConnectable(nao)) {
          trace("is available")
          userActor ! Subscribed(nao)
          become(communicating(nao))
        } else {
          trace("is NOT available")
          userActor ! NotSubscribable(nao)
        }
      }
    case x => !!!(x, "receive")
  }

  /**
   * TODO watching:not implemented yet
   */
  private def watching(nia: NaoInAction) = {
    trace("TODO watching:not implemented yet")
  }

  private def communicating(n: Nao): Receive = {
    case c: Call => {  
      val messageActor = context.actorOf(Props[NaoMessageActor],c.actorName)
      trace("request: " + c + " " + messageActor)
      messageActor ! (n, sender, c)
    }
    case x => !!!(x, "communicating")
  }

  /**
   * TODO isConnectable: is not implemented yet
   */
  private def isConnectable(nao: Nao) = {
    true
  }

  private def !!!(x: Any, state: String) = {
    val msg = "wrong message: " + x + " at " + state
    error(msg)
    sender ! msg
  }
  private def trace(a: Any) = if (Logging.NaoActor.info) log.info(a.toString)
  private def error(a: Any) = if (Logging.NaoActor.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (Logging.NaoActor.wrongMessage) log.warning("wrong message: " + a  + " in "+ state)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)

}

