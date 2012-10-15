package NaoAdapter.value

import NaoAdapter.value.Hawactormsg.MixedValue
import NaoAdapter.jnaoqi.Variant
import NaoAdapter.jnaoqi.Variant.typeV._
import com.google.protobuf.ByteString

object Mixer {

  val empty = ProtoDeserializer.apply(com.google.protobuf.ByteString.EMPTY.toByteArray())

  def convert(variant: Variant): MixedValue = {
    val builder = MixedValue.newBuilder();

    variant.getType();
    if (variant.getType() == VSTRING || variant.getType() == VCHARARRAY) builder.setString(variant.toString());
    else if (variant.getType() == VINT) builder.setInt(variant.toInt());
    else if (variant.getType() == VBOOL) builder.setBool(variant.toBoolean());
    else if (variant.getType() == VFLOAT) builder.setFloat(variant.toFloat());
    else if (variant.getType() == VBINARY) builder.setBinary(ByteString.copyFrom(variant.toBinary()));
    else if (variant.getType() == VINTARRAY) {
      for (i <- variant.toIntArray())
        builder.addArray(MixedValue.newBuilder().setInt(i).build());
    } else if (variant.getType() == VFLOATARRAY) {
      val ary = variant.toFloatArray();
      for (f <- ary)
        builder.addArray(MixedValue.newBuilder().setFloat(f).build());
    } else if (variant.getType() == VARRAY) {
      for (i <- 0 to variant.getSize())
        builder.addArray(convert(variant.getElement(i)));
    } else
      throw new InvalidValueException("Encountered Variant with unknown type");

    return builder.build();
  }

  def convert(mixed: MixedValue): Variant = {
    if (mixed.hasInt()) new Variant(mixed.getInt());
    if (mixed.hasFloat()) new Variant(mixed.getFloat());
    if (mixed.hasBool()) new Variant(mixed.getBool());
    if (mixed.hasString()) new Variant(mixed.getString());
    if (mixed.hasBinary()) new Variant(mixed.getBinary().toByteArray());
    if (mixed.getArrayCount() > 0) {
      val v = new Variant();
      mixed.getArrayList
      import scalaj.collection.Implicits._
      for (m <- mixed.getArrayList.asScala)
        v.push_back(convert(m))
      v
    }
    throw new InvalidValueException("Encountered MixedValue with unknown type");
  }

  def toString(variant: Variant): String = {
    if (variant.getType() == VSTRING || variant.getType() == VCHARARRAY) String.valueOf(variant.toString())
    else if (variant.getType() == VINT) String.valueOf(variant.toInt());
    else if (variant.getType() == VBOOL) String.valueOf(variant.toBoolean());
    else if (variant.getType() == VFLOAT) String.valueOf(variant.toFloat());
    else if (variant.getType() == VBINARY) "Binary Data";
    else if (variant.getType() == VINTARRAY) "Int-Array";
    else if (variant.getType() == VFLOATARRAY) "Float-Array";
    else if (variant.getType() == VARRAY) "Array";
    else "unknown Variant type!";
  }

  def toString(mixed: MixedValue) = {
    if (mixed.hasInt) String.valueOf(mixed.getInt)
    else if (mixed.hasFloat()) String.valueOf(mixed.getFloat)
    else if (mixed.hasBool()) String.valueOf(mixed.getBool)
    else if (mixed.hasString()) mixed.getString;
    else if (mixed.hasBinary()) "Binary Data";
    else if (mixed.getArrayCount() > 0) {
      val s = new StringBuilder();
      s.append("[");
      for (i <- 0 to mixed.getArrayCount) {
//        s.append(Mix.toString(mixed.getArray(i)))
        if (i < mixed.getArrayCount)
          s.append(" ,");
        else
          ""
      }
      s.append(" ]")
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