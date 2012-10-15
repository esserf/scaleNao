package scaleNao.raw.z

import org.zeromq.ZContext
import akka.zeromq.ZMQMessage
import org.zeromq.ZMQ.REQ
import scaleNao.raw.messages.Messages.Answer
import NaoAdapter.value.Hawactormsg.HAWActorRPCResponse
import scaleNao.raw.messages.Messages.Call
import scaleNao.raw.messages.InvalidAnswer
import NaoAdapter.value.Mixer

object MQ {

  def context = new ZContext
  def socket(cont:ZContext=context,url:String="tcp://127.0.0.1:5555") = {
    import org.zeromq.ZMQ._
    val socket = cont.createSocket(REQ)
    socket.connect(url)
    socket
  }

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
    val param = HAWActorRPCRequest.newBuilder().setModule(c.module.title.name).setMethod(c.method.title.name);
    for (mixed <- c.parameters)
      param.addParams(mixed)
    ZMQMessage(param.build)
  }
  
}