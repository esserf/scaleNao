package test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

class StupidUserActor extends Actor {
  import scaleNao.raw._
  import scaleNao.raw.messages.Messages._
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
      trace("naoActor received: " + (nao,sender))
      sender ! Call('ALTextToSpeech,'getVolume)
//      sender ! Call('ALTextToSpeech,'say,List("Hello World!"))
      become(waitOnAnswer(nao,sender))
    }
    case x => error("Wrong message: " + x)
  }
  
  def waitOnAnswer(nao:Nao,naoActor: ActorRef): Receive = {
    case x:Answer => {
      trace("Answer:" + x)
    }
  }

  def trace(a: Any) = println("StupidUserActor: " + a)
  def error(a: Any) = trace("serror: " + a)
  def wrongMessage(a: Any) = error("wrong messaage: " + a)
}