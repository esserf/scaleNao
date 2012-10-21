package test

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

class SmallStupidUserActor extends Actor {
  import scaleNao.raw._
  import scaleNao.raw.messages.Conversions._
  import scaleNao.raw.messages._
  import scaleNao.qi._
  import context._
  override def preStart {
    scaleNao.System.naoGuardian ! Nao("Nila", "127.0.0.1", 5555)
  }

  def receive = {
    case Subscribed(nao) => {
      sender ! Call('ALTextToSpeech, 'say, List("Hello World!"))
    }
    case x => println("Answer: " + x)
  }
}