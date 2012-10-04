package scaleNao.raw.messages

trait ErrorMessage extends Message

case object OutMessageNotAllowed extends ErrorMessage
case object InMessageNotAllowed extends ErrorMessage
case object NeedNao extends ErrorMessage