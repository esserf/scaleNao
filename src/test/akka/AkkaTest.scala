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

  speedTest(40)
  def speedTest(num:Int) {
    for (i <- 0 to num)
      system.actorOf(Props(new AsynchronUserActor(true)), "UserActorUnsub"+i)
    for (i <- 0 to num)
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

