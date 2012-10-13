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
  println("NaoGuardian is started")
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
    case n: Nao => naoActor ! (sender,n)
    case x => !!!(x,"receive")
  }
  
  def !!!(x:Any,state:String) = {
      val msg = "wrong message: " + x
      error(msg)
      sender ! msg
  }
  def trace(a: Any) = println("NaoGuardian: " + a)
  def error(a: Any) = trace("error: " + a)
  def wrongMessage(a: Any,state:String) = error("wrong messaage: " + a)
}