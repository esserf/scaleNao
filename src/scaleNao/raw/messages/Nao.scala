package scaleNao.raw.messages

  case class Nao(title: String, host: String, port: Int)
  case object Nao
  trait NaoInAction {
    def isAvailable: Boolean
  }
  case class Available(nao: Nao) extends NaoInAction {
    def isAvailable = true
  }
  case class Unavailable(nao: Nao) extends NaoInAction {
    def isAvailable = false
  }