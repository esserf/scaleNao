package scaleNao.raw.nao.messages

import NaoAdapter.value.Hawactormsg.MixedValue
import NaoAdapter.jnaoqi.Variant
import NaoAdapter.jnaoqi.Variant.typeV._
import com.google.protobuf.ByteString
import NaoAdapter.value.Hawactormsg.HAWActorRPCResponse

object Mixer {

  val empty = HAWActorRPCResponse.parseFrom(com.google.protobuf.ByteString.EMPTY.toByteArray())

  def toString(mixed: MixedValue):String = {
    if (mixed.hasInt) String.valueOf(mixed.getInt)
    else if (mixed.hasFloat()) String.valueOf(mixed.getFloat)
    else if (mixed.hasBool()) String.valueOf(mixed.getBool)
    else if (mixed.hasString()) mixed.getString;
    else if (mixed.hasBinary()) "Binary Data";
    else if (mixed.getArrayCount() > 0) {
      val s = new StringBuilder();
      s.append("[");
      for (i <- 0 until mixed.getArrayCount) {
        s.append(Mixer.toString(mixed.getArray(i)))
        if (i < mixed.getArrayCount-1)
          s.append(",");
        else
          ""
      }
      s.append("]")
      s.toString
    } else "Empty"
  }

  class InvalidValueException(message: String, cause: Throwable)
    extends RuntimeException(message) {
    if (cause != null)
      initCause(cause)

    def this(message: String) = this(message, null)
  }
}