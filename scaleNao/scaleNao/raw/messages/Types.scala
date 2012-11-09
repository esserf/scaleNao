package scaleNao.raw.messages

trait NaoType{
  val value: Any
}

case class Int32(value: Int) extends NaoType
case object Int32

case class Float32(value: Float) extends NaoType
case object Float32

case class NaoString(value: String) extends NaoType
case object NaoString

case object NaoUnit extends NaoType{
  val value = ()
}


