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
 * TODO ZeroMQ im NaoActor starten und für jeden Call einen NaoMessageActor
 * TODO erkennen, dass der Nao nicht erreichbar ist
 * TODO Shutdown
 * TODO Superviser auf Herz und Nieren prüfen
 * 
 * Frage an David: toString direkt in MixexValue integrierbar?
 * Frage an David: EmptyValue wie erstellbar? Überhaupt erstellbar?
 * Frage an David: checkNachricht?
 */
object AkkaTest extends App {
  scaleNao.System
  import scaleNao.System._ 
  import test._
  val actor = system.actorOf(Props[StupidUserActor], name = "SimpleAkkaCommunicationTest")
}

