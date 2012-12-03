package scaleNao.raw.messages
import NaoAdapter.value.Hawactormsg.MixedValue
import scaleNao.raw.nao.messages.Mixer

trait DataMessage
trait InMessage
trait OutMessage

trait Calling{
  val isDefined = true
}
case class Call(module: Module, method: Method, parameters: List[MixedValue] = Nil) extends DataMessage with Calling with OutMessage {
  override def toString = "Call(" + module.title + "." + method.title + "(" + params + "))"
  def actorName = "Call:" + module.title + "." + method.title + ":" + params + ""

  private def params = {
    if (parameters.isEmpty)
      ""
    else
      parameters.map(x => Mixer.toString(x)).reduceLeft((r, x) => (r + "," + x))
  }
}
case object Call

case class InvalidCall(call: Call) extends OutMessage with Calling with ErrorMessage {
  override val isDefined = false 
}
case object InvalidCall


trait Answering{
  val call:Call
}
case class Answer(override val call: Call, value: MixedValue) extends DataMessage with InMessage with Answering{
  override def toString = "Answer(" + call + ": " + Mixer.toString(value) + ")"
}
case object Answer

case class InvalidAnswer(override val call: Call) extends InMessage with ErrorMessage with Answering
case object InvalidAnswer

case class AnswerTimedOut(override val call: Call) extends InMessage with ErrorMessage with Answering
case object AnswerTimedOut

trait Event extends DataMessage with InMessage

case class Module(title: String)
case object Module

case class Method(title: String)
case object Method


// too heavy
//case class CallReceived(c:Call) extends Subscribing with InfoMessage
//case object CallReceived


object Conversions {

  implicit def string2Mixed(s: String) = MixedValue.newBuilder().setString(s).build()
  implicit def int2Mixed(i: Int) = MixedValue.newBuilder().setInt(i).build()
  implicit def float2Mixed(f: Float) = MixedValue.newBuilder().setFloat(f).build()
  implicit def bool2Mixed(b: Boolean) = MixedValue.newBuilder().setBool(b).build()

  implicit def symbol2Module(s: Symbol) = Module(s.name)
  implicit def symbol2Method(s: Symbol) = Method(s.name)
  implicit def string2Module(s: String) = Module(s)
  implicit def string2Method(s: String) = Method(s)

  implicit def symbol2String(s: Symbol) = s.name
  implicit def string2Symbol(s: String) = Symbol(s)

}