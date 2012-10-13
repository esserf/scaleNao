package scaleNao

import akka.actor.ActorSystem
import akka.actor.Props
import scaleNao.raw.NaoGuardian

object System{
  import test._
  val system = ActorSystem("scaleNaoSystem")
  val naoGuardian = system.actorOf(Props[NaoGuardian], name = "NaoGuardian")
  println("ActorSystem " + system.name + " with NaoGuardian is started")
}