package test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

/**
 * TODO Events
 * TODO mehrere Nachrichten
 * TODO Answers kommen nicht immer an
 * TODO mehrere Sender
 * TODO ZeroMQ via Supervisor starten und dann NaoActor für je einen Nao starten
 * TODO erkennen, dass der Nao nicht erreichbar ist
 * TODO Shutdown
 * TODO Superviser auf Herz und Nieren prüfen
 */
object AkkaTest extends App {
  scaleNao.System
  import scaleNao.System._ 
  import test._
  val actor = system.actorOf(Props[StupidUserActor], name = "SimpleAkkaCommunicationTest")
}

