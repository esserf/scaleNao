package test.akka

import scaleNao.System.system
import akka.actor.Props

/**
 * TODO Events
 * TODO Unsubscribing
 * TODO Shutdown
 * TODO Superviser auf Herz und Nieren prüfen
 */
object AkkaTest extends App {
  scaleNao.System
  import scaleNao.System._
  import test._

  speedTest
  def speedTest {
    for (i <- 0 to 3)
      system.actorOf(Props(new AsynchronUserActor(true)), "UserActorUnsub"+i)
    for (i <- 0 to 3)
      system.actorOf(Props(new AsynchronUserActor(false)), "UserActor----"+i)
  }

  def realTest {
    system.actorOf(Props[AsynchronUserActorNila], "UserActorNila")
    system.actorOf(Props[AsynchronUserActorHanna], "UserActorHanna")
  }
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

