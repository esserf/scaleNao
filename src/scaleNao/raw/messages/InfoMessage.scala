package scaleNao.raw.messages

import akka.actor.ActorRef

trait InfoMessage extends Message

case class CallReceived(c:Call) extends InfoMessage
case object CallReceived

case class NaoReceived(nao:Nao) extends InfoMessage
case object NaoReceived

case class NaoRebound(nao:Nao) extends InfoMessage
case object NaoRebound