package scaleNao.raw

import akka.actor.Actor
import akka.actor.ActorRef


class NaoMessageActor extends Actor {

  import scaleNao.raw.messages._
  import scaleNao.raw.messages.Conversions
  import scaleNao.raw.nao.messages.NaoMessages 
  import scaleNao.raw.nao.messages.NaoMessages._
  import context._
  import NaoAdapter.value._

  import akka.zeromq.Connecting
        
  object zMQ {
	import org.zeromq.ZContext 
    val context = new ZContext 
    def socket(cont: ZContext = context, url: String) = {
      import org.zeromq.ZMQ._
      val socket = cont.createSocket(REQ)
      socket.connect(url)
      socket
    }
  }
  
  def receive = {
    case (nao:Nao,userActor: ActorRef, c: Call) =>{
      trace("Call " + c)
      val address = "tcp://" + nao.host + ":" + nao.port
      val socket = zMQ.socket(url = address)
      socket.send(NaoMessages.request(c).toByteArray(),0)
      
      userActor ! NaoMessages.answer(socket.recv(0), c)  
      socket.close()
      context.stop(self)
    }     
    case x => wrongMessage(x, "receive")
  }

//  private def connect(nao: Nao) = {
//    import akka.zeromq._
//    val address = "tcp://" + nao.host + ":" + nao.port
//    val zmq = ZeroMQExtension(system).newSocket(
//        SocketType.Req, 
//        Connect(address), 
//        Listener(self))
////        ProtoDeserializer) // match error
//    trace("zmq Actor is started: " + zmq + " connected with " + address + "(SocketType:Req)")
//    context.watch(zmq)
//    Available(nao, zmq) // connecting check not implemented yet
//  }

  private def trace(a: Any) = if (LogConf.NaoMessageActor.info)  log.info(a.toString)
  private def error(a: Any) = if (LogConf.NaoMessageActor.error) log.warning(a.toString)
  private def wrongMessage(a: Any, state: String) = if (LogConf.NaoMessageActor.wrongMessage) log.warning("wrong message: " + a  + " in "+ state + " from " + sender)
  import akka.event.Logging
  val log = Logging(context.system, this)
  trace("is started: " + self)
}