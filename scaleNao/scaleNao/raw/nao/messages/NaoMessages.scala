package scaleNao.raw.nao.messages

object NaoMessages {

  import scaleNao.raw.messages._
  import NaoAdapter.value.Hawactormsg._
  implicit def HAWActorRPCResponseTOByteArray(r:Array[Byte]) = HAWActorRPCResponse.parseFrom(r)
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

  def request(c:Call) = {  
    val param = HAWActorRPCRequest.newBuilder().setModule(c.module.title).setMethod(c.method.title);
    for (mixed <- c.parameters)
      param.addParams(mixed)
    param.build
  }
  
}