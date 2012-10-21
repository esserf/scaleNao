package test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import scaleNao.raw._
import scaleNao.raw.messages.Conversions._
import scaleNao.raw.messages._
import scaleNao.raw.messages.Subscribed

class AsynchronUserActor extends Actor{
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
      for(i <- 0 to 8)
    	  sender ! Call('ALTextToSpeech, 'say, List("Asynchron"+i))
      trace("answer ->")
      become(answer(System.currentTimeMillis))
    }
  }
  def answer(t0:Long,n:Int=1): Receive = {
    case x: Answer => {
      trace("Answer:" + x + " (" + (System.currentTimeMillis-t0)/n+"ms)")
      become(answer(t0,n+1))
    }    
  }
  def trace(a: Any) = log.info(a.toString)
  def error(a: Any) = log.warning(a.toString)
  def wrongMessage(a: Any) = error("wrong messaage: " + a)
  import akka.event.Logging
  val log = Logging(context.system, this)
}