package NaoAdapter.z

import org.zeromq.ZContext

object MQ {

  def context = new ZContext
  def socket(cont:ZContext=context,url:String="tcp://127.0.0.1:5555") = {
    import org.zeromq.ZMQ._
    val socket = cont.createSocket(REQ)
    socket.connect(url)
    socket
  }
  
}