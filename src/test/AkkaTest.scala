package test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

/**
 * TODO Events
 * TODO Calls kommen nicht immer an
 * TODO mehrere Sender
 * TODO mehrere Naos
 * TODO erkennen, dass der Nao nicht erreichbar ist
 * TODO Shutdown
 * TODO Superviser auf Herz und Nieren prüfen
 * 
 * Frage an David: toString direkt in MixedValue integrierbar?
 * Frage an David: EmptyValue wie erstellbar? Überhaupt erstellbar?
 * Frage an David: checkNachricht?
 */
object AkkaTest extends App {
  scaleNao.System
  import scaleNao.System._ 
  import test._
  val actor = system.actorOf(Props[SynchronUserActor])
}

/**
 * dont forget
 * Lifecycle Monitoring aka DeathWatch
 * Graceful Stop
 * http://doc.akka.io/docs/akka/snapshot/scala/actors.html
 * 
 * Balanced / Pinne Dispatcher
 * http://doc.akka.io/docs/akka/2.0.1/scala/dispatchers.html
 * 
 * Futures
 * http://doc.akka.io/docs/akka/2.0.1/scala/futures.html#futures-scala
 */

