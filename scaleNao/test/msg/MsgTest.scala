package test.msg

import NaoAdapter.value.Hawactormsg.MixedValue
import scaleNao.raw.messages._
import scaleNao.raw.messages.Conversions._

object MsgTest extends App {
  foo
  import scaleNao.raw.messages.Conversions

  def foo = {
    MixedValue.newBuilder().addArray(MixedValue.newBuilder().setString("s").build())

    println(Call('ALMotion, 'setAngles, List(List("HeadYaw", "HeadPitch"), List(Int.MaxValue, 0F), 1F)))
  }

  //  implicit def stringToMixedVal(value: String) = {
  //    MixedValue.newBuilder().setString(value).build()
  //  }
  //
  //  implicit def floatToMixedVal(value: Float) = {
  //    MixedValue.newBuilder().setFloat(value).build()
  //  }

}