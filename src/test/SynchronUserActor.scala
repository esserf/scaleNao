package test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

class SynchronUserActor extends Actor {
  import scaleNao.raw.messages.Conversions._
  import scaleNao.raw.messages._
  import scaleNao.qi._
  import context._
  
  val naoGuardian = scaleNao.System.naoGuardian
  val nao = Nao("Nila", "127.0.0.1", 5555)
  
  override def preStart {
    trace("SimpleAkkaCommunicationTest with " + nao)
    naoGuardian ! nao
  }
  
  def receive = {
    case Subscribed(nao) => {
      trace("naoActor received: " + (nao, sender))
      val t0 = System.currentTimeMillis
      sender ! Call('ALTextToSpeech, 'say, List("Synchron"+0))
      become(answer(sender,t0))
    }
  }
  def answer(sender:ActorRef,t0:Long,n:Int=1): Receive = {
    case x: Answer => {
//      if (n % 10 == 0)
    	  trace( x + " (average " + (System.currentTimeMillis-t0)/n+"ms of " + n + " times)")
      sender ! Call('ALTextToSpeech, 'say, List("Synchron"+n))
      become(answer(sender,t0,n+1))
    }    
  }
  
  def trace(a: Any) = log.info(a.toString)
  def error(a: Any) = log.warning(a.toString)
  def wrongMessage(a: Any) = error("wrong messaage: " + a)
  import akka.event.Logging
  val log = Logging(context.system, this)
}