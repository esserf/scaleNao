package scaleNao.raw.messages

trait ErrorMessage extends Message

case object OutMessageNotAllowed extends ErrorMessage
case object InMessageNotAllowed extends ErrorMessage
case object NeedNao extends ErrorMessage

case class InvalidAnswer(c:Call) extends InMessage with ErrorMessage

case class CallTimedOut(c:Call) extends InMessage with ErrorMessage
case object CallTimedOut

case class NotSubscribable(nao:Nao) extends InfoMessage
case object NaoNotFound

case class NaoLost(nao:Nao) extends InfoMessage
case object NaoLost