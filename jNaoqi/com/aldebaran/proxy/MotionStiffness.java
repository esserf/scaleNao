/**
 *
 */
package com.aldebaran.proxy;

import javax.swing.*;
import java.io.*;


public class MotionStiffness
{
  static
  {
    System.loadLibrary("JNaoQi");
  }

  public static void main(String[] args)
  {
	ALMotionProxy motionProxy;
	motionProxy = new ALMotionProxy("naoverdose.local",9559);
	

	//We use the "Body" name to signify the collection of all joints
    	motionProxy.stiffnessInterpolation(new Variant("Body"), new Variant(1.0f), new Variant (1.0f));

    	
	
  }
}

