package test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

/**
 * TODO mehrere Nachrichten
 * TODO mehrere Sender
 * TODO erkennen, dass Nao nicht erreichbar ist
 */
object AkkaTest extends App {
  scaleNao.System
  import scaleNao.System._ 
  import test._
  val actor = system.actorOf(Props[StupidUserActor], name = "SimpleAkkaCommunicationTest")
}

