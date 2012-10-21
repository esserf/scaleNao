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
  
  val num = 3

  def receive = {
    case Subscribed(nao) => {
      trace("naoActor received: " + (nao, sender))
      for(i <- 0 to num)
    	  sender ! Call('ALTextToSpeech, 'say, List("Asynchron"+i))
      become(answer(sender,System.currentTimeMillis))
    }
  }
  def answer(userActor:ActorRef,t0:Long,n:Int=1): Receive = {
    case x: Answer => {
      trace("Answer("+n+"):" + x + " (" + (System.currentTimeMillis-t0)/n+"ms)")  
      if (n % num == 0){
       for(i <- 0 to num)
    	  userActor ! Call('ALTextToSpeech, 'say, List("Asynchron"+n+i))    
    	become(answer(userActor,t0,(n+1)))
      }
      else
         become(answer(userActor,t0,n+1))
    }    
  }
  def trace(a: Any) = log.info(a.toString)
  def error(a: Any) = log.warning(a.toString)
  def wrongMessage(a: Any) = error("wrong message: " + a)
  import akka.event.Logging
  val log = Logging(context.system, this)
}