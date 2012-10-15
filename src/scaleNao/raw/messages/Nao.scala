package scaleNao.raw.messages

import akka.actor.ActorRef
import akka.actor._

  case class Nao(title: String, host: String, port: Int)
  case object Nao
  trait NaoInAction {
    def isAvailable: Boolean
    def socket: ActorRef
  }
  case class Available(nao: Nao,socket: ActorRef) extends NaoInAction {
    def isAvailable = true
  }
  case class Unavailable(nao: Nao) extends NaoInAction {
    def isAvailable = false
    def socket = scaleNao.System.system.actorOf(Props[Nothing], name = "NoActor")
  }
  
  case class Binding(userActr:ActorRef,nao:Nao,naoActor:ActorRef)
  case object Binding