package scaleNao.raw

import scaleNao.raw.messages._
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef

class NaoActor extends Actor {

  import scaleNao.raw.messages._
  import context._
  
  def receive = {
    case (userActor: ActorRef, nao: Nao) =>
      {
        trace(nao + " comes in")
        val nia = connect(nao)
        if (nia.isAvailable) {
          trace("is available")
          userActor ! NaoReceived(nao)
          become(communicating(nia))
        } else {
          trace("is NOT available")
          userActor ! NaoNotFound(nao)
        }
      }
    case x => !!!(x, "receive")
  }

  /**
   * TODO watching:not implemented yet
   */
  def watching(nia: NaoInAction) = {
    trace("TODO watching:not implemented yet")
  }

  import scaleNao.qi._
  def communicating(nia: NaoInAction): Receive = {
    case Call(Audio.TextToSpeech.say(x: String)) => {
      trace("I should say " + x + "? - Its done. ")
       
      import test.SimpleRequestTest._
      request("TextToSpeech","say",List(x))
      sender ! Audio.TextToSpeech.TextDone
    }
    case m: OutMessage => {
      trace("new message comes in: " + m)
    }
    case x => !!!(x, "receive")
  }

  /**
   * TODO connect:not implemented yet
   */
  def connect(nao: Nao) = Available(nao)

  def !!!(x: Any, state: String) = {
    val msg = "wrong message: " + x
    error(msg)
    sender ! msg
  }
  def trace(a: Any) = println("NaoActor: " + a)
  def error(a: Any) = trace("error: " + a)
  def wrongMessage(a: Any, state: String) = error("wrong messaage: " + a)
}