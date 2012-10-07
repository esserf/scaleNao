package test

import scala.actors.Actor

object Test extends App {
  MyFirstNaoTest.start
}
object MyFirstNaoTest extends Actor { 
  override def act = {
    import scaleNao.raw.NaoActor.Nao
    val nao = Nao("Nila", "localhost", 9001)
    println("MyFirstNao with " + nao)
    import scaleNao.raw.NaoActor
    NaoActor.start
    NaoActor ! nao
    import scaleNao.raw.messages._
    import scaleNao.qi._
    NaoActor ! Call(Audio.TextToSpeech.say("abc"))
  }
}