package scaleNao.raw

import akka.actor.Actor
import akka.actor.Props
import scaleNao.raw.messages.Nao

private case object NaoTimeOut

private class NaoCheckActor extends Actor{
 
  import scaleNao.raw.messages._
  import context._
  
  def receive = {
    case nao:Nao => {
      check(nao)
      become(checkingOnUnknown(nao))
    }
  }
  
  def checkingOnUnknown(nao:Nao):Receive = {
    case c: Answering => {
      sender ! NaoRebound(nao) 
      check(nao)
      become(checkingOnOnline(nao))
    }
    case NaoTimeOut => {
      sender ! NaoLost(nao) 
      check(nao)
      become(checkingOnOffline(nao))
    }
  }
  
  def checkingOnOnline(nao:Nao):Receive = {
    case c: Answering => {
      sender ! NaoRebound(nao) 
      check(nao)
    }
    case NaoTimeOut => {
      sender ! NaoLost(nao) 
      check(nao)
       become(checkingOnOffline(nao))
    }
  }
    
  def checkingOnOffline(nao:Nao):Receive = {
    case c: Answering => {
      sender ! NaoRebound(nao) 
      check(nao)
      become(checkingOnOnline(nao))
    }
    case NaoTimeOut => {
      sender ! NaoLost(nao) 
      check(nao)
    }
  }
  
  private def check(nao: Nao): Unit = {
    import akka.util.Duration
    val messageActor = context.actorOf(Props[NaoMessageActor])
    import akka.pattern.ask
    val f = messageActor.ask(nao, self, Call(Module("test"), Method("test")))(Duration(5, "seconds"))
    f onFailure {
      case x => {
        self ! NaoTimeOut
        check(nao)
      }
    }
  }
}