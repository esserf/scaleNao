package scaleNao.qi

object Audio {
  object TextToSpeech {
    // methods
    case class say(msg: String) 
    case object say

    case object getVolume

    // callbacks
    case class TextDone(eventName: String, value: Boolean, subscriberIdentifier: String)
    case object TextDone
  }
}
