package scaleNao.raw.messages

trait DataMessage 
trait InMessage
trait OutMessage

case class Call(method:Method) extends DataMessage with OutMessage
case object Call

case class Answer(val call: Call, val value: NaoType) extends DataMessage with OutMessage
case object Answer

trait Event extends DataMessage with InMessage

trait Module{
  val subModule: Module = EmptyModule
}
object EmptyModule extends Module

trait Method{
  val parameters: List[Parameter] = Nil
  val answerType: NaoType = NaoUnit
}

trait Parameter{
   val value: NaoType
}
