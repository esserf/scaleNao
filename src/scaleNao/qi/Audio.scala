package scaleNao.qi

import scaleNao.raw.messages.Module
import scaleNao.raw.messages.Event
import scaleNao.raw.messages.Method

object Audio extends Module{
  object TextToSpeech extends Module{
    // methods
    case class say(msg: String) extends Method
    case object say

    case object getVolume

    // callbacks
    case class TextDone(eventName: String, value: Boolean, subscriberIdentifier: String) extends Event
    case object TextDone
  }
}
