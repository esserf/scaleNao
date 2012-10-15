package NaoAdapter.value

import akka.zeromq.Deserializer
import akka.zeromq.Frame
import akka.zeromq.ZMQMessage
import NaoAdapter.value.Hawactormsg.HAWActorRPCResponse
import test.SimpleRequestTest
import com.google.protobuf.ByteString


object ProtoDeserializer extends Deserializer {
  
    def seqToByteArray(seq: Seq[Array[Byte]]):Array[Byte] = {
    if (seq.isEmpty){
      Array[Byte]()
    }
    else
      seq.first ++ seqToByteArray(seq.tail)
  }
  def toByteArray(frames: Seq[Frame]):Array[Byte] = {
    val seq = frames map (x => x.payload.toArray) 
    seqToByteArray(seq)
  }
	def apply(frames: Seq[Frame]) = HAWActorRPCResponse.parseFrom(ByteString.copyFrom(toByteArray(frames)))
}

object Test extends App{
  test
  def test = {
    val t = Seq(Frame("abc"))
    println(t)
    println(ProtoDeserializer.toByteArray(t).deep)
  }
 }

