package scaleNao.raw

object LogConf {
  
  object NaoActor{
    val info = true
    val error = true
    val wrongMessage = true
  }
  object NaoGuardian{
    val info = false
    val error = true
    val wrongMessage = true
  }
  object NaoMessageActor{
    val info = false
    val error = true
    val wrongMessage = true
  }

}