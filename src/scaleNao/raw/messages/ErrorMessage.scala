package scaleNao.raw.messages

import scaleNao.raw.messages.Messages.Call

trait ErrorMessage extends Message

case object OutMessageNotAllowed extends ErrorMessage
case object InMessageNotAllowed extends ErrorMessage
case object NeedNao extends ErrorMessage

case class CallTimedOut(c:Call) extends ErrorMessage
case object CallTimedOut

case class NaoNotFound(nao:Nao) extends InfoMessage
case object NaoNotFound

case class NaoLost(nao:Nao) extends InfoMessage
case object NaoLost