package test

import NaoAdapter.value.Hawactormsg.HAWActorRPCRequest
import NaoAdapter.value.Hawactormsg.MixedValue
import NaoAdapter.value.Mixer
import NaoAdapter.value.Hawactormsg.HAWActorRPCResponse
import NaoAdapter._

object SimpleRequestTest extends App {
  
  val socket = z.MQ.socket()
  say("Hey Ho")

  def answer = {
    val protoResponse = HAWActorRPCResponse.parseFrom(socket.recv(0))
    if (protoResponse.hasError) {
      trace("Error: " + protoResponse.getError)
    } else if (protoResponse.hasReturnval) {
      trace("-> " + Mixer.toString(protoResponse.getReturnval))
    } else {
      trace("-> Empty \n");
    }
  }

  def request(module: String, method: String, params: List[MixedValue]) {
    val param = HAWActorRPCRequest.newBuilder().setModule(module).setMethod(method);
    for (mixed <- params) {
      param.addParams(mixed)
    }
    
    val rpcReq = param.build
    socket.send(rpcReq.toByteArray, 0)
    answer
  }

  implicit def string2Mixed(s: String) = MixedValue.newBuilder().setString(s).build()
  
  def sequence = {
    openHandL
    openHandR
    closeHandR
    closeHandL
  }
 
  def say(s:String="Hello!") = request("ALTextToSpeech", "say", List(s))
  def closeHandL = request("ALMotion", "closeHand", List("LHand"))
  def openHandL = request("ALMotion", "openHand", List("LHand"))
  def closeHandR = request("ALMotion", "closeHand", List("RHand"))
  def openHandR = request("ALMotion", "openHand", List("RHand"))

  def trace(a: Any) = println("SimpleRequestTest: " + a)
}