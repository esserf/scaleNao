package scaleNao.raw.messages

import NaoAdapter.value.Hawactormsg.MixedValue

object Messages {

  trait DataMessage
  trait InMessage
  trait OutMessage

  case class Call(module: Module, method: Method, paramters: List[MixedValue] = Nil) extends DataMessage with OutMessage
  case object Call

  case class Answer(val call: Call, val value: MixedValue) extends DataMessage with OutMessage
  case object Answer

  trait Event extends DataMessage with InMessage

  case class Module(title: Symbol)
  case object Module

  case class Method(title: Symbol)
  case object Method

  
  implicit def string2Mixed(s: String) = MixedValue.newBuilder().setString(s).build()
  implicit def int2Mixed(i: Int) = MixedValue.newBuilder().setInt(i).build()
  implicit def float2Mixed(f: Float) = MixedValue.newBuilder().setFloat(f).build()
  implicit def bool2Mixed(b: Boolean) = MixedValue.newBuilder().setBool(b).build()

  implicit def string2Module(s: Symbol) = Module(s)
  implicit def string2Method(s: Symbol) = Method(s)

  implicit def symbol2String(s:Symbol) = s.name
  implicit def string2Symbol(s:String) = Symbol(s)
  
}