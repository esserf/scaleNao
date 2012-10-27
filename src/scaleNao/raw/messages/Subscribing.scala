package scaleNao.raw.messages

trait Subscribing

/**
 * scale Nao says this nao is not available
 */
case class NotSubscribable(nao: Nao) extends Subscribing with InfoMessage
case object NaoNotFound

/**
 * scale Nao says this nao is currently not available, but was it
 */
case class NaoLost(nao: Nao) extends Subscribing with ErrorMessage
case object NaoLost


/**
 * scale Nao says this nao is available and subscribed
 */
case class Subscribed(nao:Nao) extends Subscribing with InfoMessage
case object Subscribed

/**
 * you say you want to subscribe this nao
 */
case class Subscribe(nao:Nao) extends Subscribing with InfoMessage
case object Subscribe

/**
 * scale Nao says that you done it already
 */
case class AlreadySubscribed(nao:Nao) extends Subscribing with ErrorMessage
case object AlreadySubscribed

/**
 * scale Nao says that nao was lost but it available currently
 */
case class NaoRebound(nao:Nao) extends Subscribing with InfoMessage
case object NaoRebound

/**
 * you say scaleNao that you want to subscribe this nao
 */
case class Unsubscribe(nao:Nao) extends Subscribing with InfoMessage
case object Unsubscribe

/**
 * scale Nao says your unsubscribing is successful
 */
case class Unsubscribed(nao:Nao) extends Subscribing with InfoMessage
case object Unsubscribed

/**
 * scale Nao says you cant unsubscribe this nao
 */
case class NotUnsubscribable(nao:Nao) extends Subscribing with InfoMessage
case object NotUnsubscribable