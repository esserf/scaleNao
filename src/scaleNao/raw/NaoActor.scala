package scaleNao.raw

import scala.actors.Actor
import scaleNao.raw.messages._

object NaoActor extends Actor {

  case class Nao(title: String, host: String, port: Int)
  case object Nao
  trait NaoInAction {
    def isAvailable: Boolean
  }
  case class Available(nao: Nao) extends NaoInAction {
    def isAvailable = true
  }
  case class Unavailable(nao: Nao) extends NaoInAction {
    def isAvailable = false
  }

  def act = waiting

  def waiting = {
    loop {
      receive {
        case nao: Nao =>
          {
        	trace(nao + " comes in")
            val nia = connect(nao)
            if (nia.isAvailable) {
              trace("is available")
              sender ! NaoReceived(nao)
              communicating(nia)
            } else {
              trace("is NOT available")
              sender ! NaoNotFound(nao)
              watching(nia)
            }
          }
        case x => {
          wrongMessage(x)
        }
      }
    }
  }

  /**
   * TODO watching:not implemented yet
   */
  def watching(nia: NaoInAction) = {}

  def communicating(nia: NaoInAction) = {
    import scaleNao.qi._
    loop {
      receive {      
        case Call(Audio.TextToSpeech.say(x:String)) => {
          trace("I should say " +  x + "? - Its done. ")
          sender ! Audio.TextToSpeech.TextDone
        }
        case m: OutMessage => {
          trace("new message comes in: " + m)
        }
        case x => trace("something stupid: " + x)
      }
    }
  }

  /**
   * TODO connect:not implemented yet
   */
  def connect(nao: Nao) = Available(nao)

  def trace(a: Any) = println("NaoActor: " + a)
  def error(a: Any) = trace(" error: " + a)
  def wrongMessage(a: Any)  = error("wrong messaage: " + a)
}