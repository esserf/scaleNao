package test.akka

import scaleNao.System.system
import akka.actor.Props

/**
 * TODO Events
 * TODO mehrere Naoimport test.akka.AsynchronUserActor
s
 * TODO erkennen, dass der Nao nicht erreichbar ist
 * TODO Shutdown
 * TODO Superviser auf Herz und Nieren prüfen
 */
object AkkaTest extends App {
  scaleNao.System
  import scaleNao.System._ 
  import test._
  for (i <- 0 to 1)
  	system.actorOf(Props[AsynchronUserActor],"UserActor"+i)
}

/**
 * dont forget
 * Lifecycle Monitoring aka DeathWatch
 * Graceful Stop
 * http://doc.akka.io/docs/akka/snapshot/scala/actors.html
 * 
 * Balanced / Pinned Dispatcher
 * http://doc.akka.io/docs/akka/2.0.1/scala/dispatchers.html
 * 
 * Futures
 * http://doc.akka.io/docs/akka/2.0.1/scala/futures.html#futures-scala
 */

