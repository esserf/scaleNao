package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props

private class NaoActor extends Actor {

  import akka.zeromq.ZMQMessage
  import scaleNao.raw.z.MQ._
  import NaoAdapter.value._
  import NaoAdapter.value.Hawactormsg._
  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Messages._
  import context._
  import NaoAdapter.value._
  trace("is started: " + self)

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

  import scaleNao.qi._
  private def communicating(n: Nao): Receive = {
    case c: Call => {
      trace("request: " + c)
      val messageActor = context.actorOf(Props[NaoMessageActor])
      messageActor ! (n, sender, c)
    }
    case x => !!!(x, "communicating")
  }

  private def isConnectable(nao: Nao) = {
    true // connecting check not implemented yet
  }

  private def !!!(x: Any, state: String) = {
    val msg = "wrong message: " + x + " at " + state
    error(msg)
    sender ! msg
  }
  private def trace(a: Any, force: Boolean = false) = if (Logging.NaoGuardian.info) println("NaoActor: " + a)
  private def error(a: Any, force: Boolean = false) = if (Logging.NaoGuardian.error) trace("error: " + a, true)
  private def wrongMessage(a: Any, state: String, force: Boolean = false) = if (Logging.NaoGuardian.wrongMessage) error("wrong messaage: " + a + " at " + state, true)
}

