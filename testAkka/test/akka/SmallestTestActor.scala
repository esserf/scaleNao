package test.akka

import akka.actor.Actor

class SmallestTestActor extends Actor {
  import scaleNao.raw._
  import scaleNao.raw.messages.Conversions._
  import scaleNao.raw.messages._
  import context._
  override def preStart {
    scaleNao.System.naoGuardian ! Subscribe(Nao("Nila", "127.0.0.1", 5555))
  }

  def receive = {
    case Subscribed(nao) => {
      sender ! Call('ALTextToSpeech, 'say, List("Hello World!"))
    }
    case x => println("Answer: " + x)
  }
}