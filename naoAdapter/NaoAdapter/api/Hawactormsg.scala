// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hawactormsg.proto

package NaoAdapter.api

object Hawactormsg {
  object HAWActorRPCRequest extends org.matmexrhino.protobuf.scala.MessageObject[NaoAdapter.value.Hawactormsg.HAWActorRPCRequest.Builder] {
    def newInstance = NaoAdapter.value.Hawactormsg.HAWActorRPCRequest.newBuilder
    def clone(b : NaoAdapter.value.Hawactormsg.HAWActorRPCRequest.Builder) = b.clone
    val module = new org.matmexrhino.protobuf.scala.Opt[NaoAdapter.value.Hawactormsg.HAWActorRPCRequest.Builder, java.lang.String](_ setModule _)
    val method = new org.matmexrhino.protobuf.scala.Opt[NaoAdapter.value.Hawactormsg.HAWActorRPCRequest.Builder, java.lang.String](_ setMethod _)
    val params = new org.matmexrhino.protobuf.scala.SeqOpt[NaoAdapter.value.Hawactormsg.HAWActorRPCRequest.Builder, NaoAdapter.value.Hawactormsg.MixedValue.Builder](_ addParams _)
    
    implicit def buildProto(b : NaoAdapter.value.Hawactormsg.HAWActorRPCRequest.Builder) = b.build()
  }
  object HAWActorRPCResponse extends org.matmexrhino.protobuf.scala.MessageObject[NaoAdapter.value.Hawactormsg.HAWActorRPCResponse.Builder] {
    def newInstance = NaoAdapter.value.Hawactormsg.HAWActorRPCResponse.newBuilder
    def clone(b : NaoAdapter.value.Hawactormsg.HAWActorRPCResponse.Builder) = b.clone
    val returnval = new org.matmexrhino.protobuf.scala.MessageOpt[NaoAdapter.value.Hawactormsg.HAWActorRPCResponse.Builder, NaoAdapter.value.Hawactormsg.MixedValue.Builder](_ setReturnval _)(NaoAdapter.api.Hawactormsg.MixedValue)
    val error = new org.matmexrhino.protobuf.scala.Opt[NaoAdapter.value.Hawactormsg.HAWActorRPCResponse.Builder, java.lang.String](_ setError _)
    
    implicit def buildProto(b : NaoAdapter.value.Hawactormsg.HAWActorRPCResponse.Builder) = b.build()
  }
  object MixedValue extends org.matmexrhino.protobuf.scala.MessageObject[NaoAdapter.value.Hawactormsg.MixedValue.Builder] {
    def newInstance = NaoAdapter.value.Hawactormsg.MixedValue.newBuilder
    def clone(b : NaoAdapter.value.Hawactormsg.MixedValue.Builder) = b.clone
    val string = new org.matmexrhino.protobuf.scala.Opt[NaoAdapter.value.Hawactormsg.MixedValue.Builder, java.lang.String](_ setString _)
    val int = new org.matmexrhino.protobuf.scala.Opt[NaoAdapter.value.Hawactormsg.MixedValue.Builder, scala.Int](_ setInt _)
    val float = new org.matmexrhino.protobuf.scala.Opt[NaoAdapter.value.Hawactormsg.MixedValue.Builder, scala.Float](_ setFloat _)
    val binary = new org.matmexrhino.protobuf.scala.Opt[NaoAdapter.value.Hawactormsg.MixedValue.Builder, com.google.protobuf.ByteString](_ setBinary _)
    val bool = new org.matmexrhino.protobuf.scala.Opt[NaoAdapter.value.Hawactormsg.MixedValue.Builder, scala.Boolean](_ setBool _)
    val array = new org.matmexrhino.protobuf.scala.SeqOpt[NaoAdapter.value.Hawactormsg.MixedValue.Builder, NaoAdapter.value.Hawactormsg.MixedValue.Builder](_ addArray _)
    
    implicit def buildProto(b : NaoAdapter.value.Hawactormsg.MixedValue.Builder) = b.build()
  }
}