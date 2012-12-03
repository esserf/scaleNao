package scaleNao

import akka.actor.ActorSystem
import akka.actor.Props
import scaleNao.raw.NaoGuardian

object System{
  val system = ActorSystem("scaleNao")
  println("ActorSystem " + system.name + " is started")
  val naoGuardian = system.actorOf(Props[NaoGuardian], name = "NaoGuardian")
}