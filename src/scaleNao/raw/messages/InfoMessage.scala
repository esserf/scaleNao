package scaleNao.raw.messages

import scaleNao.raw.messages._
import scaleNao.raw.NaoActor._

trait InfoMessage extends Message

case class CallReceived(c:Call) extends InfoMessage
case object CallReceived

case class NaoReceived(nao:Nao) extends InfoMessage
case object NaoReceived

case class NaoRebound(nao:Nao) extends InfoMessage
case object NaoRebound