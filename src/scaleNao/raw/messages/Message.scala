package scaleNao.raw.messages

trait Message
trait InfoMessage extends Message
trait ErrorMessage extends Message

case object OutMessageNotAllowed extends ErrorMessage
case object InMessageNotAllowed extends ErrorMessage