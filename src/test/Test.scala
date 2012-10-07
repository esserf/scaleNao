package test

import scala.actors.Actor

object Test extends App {
  MyFirstNaoCommunicationTest.start
}
object MyFirstNaoCommunicationTest extends Actor {
  override def act = {
    import scaleNao.raw.NaoActor.Nao
    val nao = Nao("Nila", "localhost", 9001)
    trace("MyFirstNaoCommunicationTest with " + nao)
    import scaleNao.raw.NaoActor
    NaoActor.start
    NaoActor ! nao
    import scaleNao.raw.messages._
    import scaleNao.qi._
    loop {
      receive {
        case NaoReceived(n) => NaoActor ! Call(Audio.TextToSpeech.say("abc"))
        case Audio.TextToSpeech.TextDone => {
          trace("Text is done")
          trace("Cool, I'm finished")
          this.exit
        }
        case _ =>
      }
    }
  }
  
  def trace(a: Any) = println("TestActor: " + a)
  def error(a: Any) = trace(" error: " + a)
  def wrongMessage(a: Any)  = error("wrong messaage: " + a)
}