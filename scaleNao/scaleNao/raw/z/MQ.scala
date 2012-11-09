package scaleNao.raw.z

import org.zeromq.ZContext
import akka.zeromq.ZMQMessage
import org.zeromq.ZMQ.REQ
import NaoAdapter.value.Hawactormsg.HAWActorRPCResponse
import scaleNao.raw.messages._
import NaoAdapter.value.Mixer

object MQ {


  def answer(protoResponse: HAWActorRPCResponse, c: Call) = {
    if (protoResponse.hasError) {
      InvalidAnswer(c)
    } 
    else if (protoResponse.hasReturnval) {
      Answer(c,protoResponse.getReturnval)
    } else {
      Answer(c,Mixer.empty.getReturnval())
    }
  }

  import NaoAdapter.value.Hawactormsg._

  def request(c:Call) = {  
    val param = HAWActorRPCRequest.newBuilder().setModule(c.module.title).setMethod(c.method.title);
    for (mixed <- c.parameters)
      param.addParams(mixed)
    ZMQMessage(param.build)
  }
  
}