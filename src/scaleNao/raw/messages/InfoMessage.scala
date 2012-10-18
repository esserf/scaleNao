package scaleNao.raw.messages

import akka.actor.ActorRef
import scaleNao.raw.messages.Messages.Call

trait InfoMessage extends Message

case class CallReceived(c:Call) extends InfoMessage
case object CallReceived

case class Subscribed(nao:Nao) extends InfoMessage
case object NaoReceived

case class NaoRebound(nao:Nao) extends InfoMessage
case object NaoRebound

case class Subscribe(nao:Nao) extends InfoMessage
case class Unsubscribe

case class Unsubscribed