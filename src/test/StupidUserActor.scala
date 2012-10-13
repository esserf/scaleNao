package test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

class StupidUserActor extends Actor {
  import scaleNao.raw._
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
    case NaoReceived(nao) => {
      trace("naoActor received: " + (nao,sender))
      sender ! Call(Audio.TextToSpeech.say("Hello World!"))
      become(communicateWith(nao,sender))
    }
    case x => error("Wrong message: " + x)
  }
  
  def communicateWith(nao:Nao,naoActor: ActorRef): Receive = {
    case Audio.TextToSpeech.TextDone => {
      trace("Text is done")
      trace("Cool, I'm finished")
    }
  }

  def trace(a: Any) = println("StupidUserActor: " + a)
  def error(a: Any) = trace("serror: " + a)
  def wrongMessage(a: Any) = error("wrong messaage: " + a)
}