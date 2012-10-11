/**
 *
 */
package com.aldebaran.proxy;

import javax.swing.*;
import java.io.*;


public class position6DArm1
{
  static
  {
    System.loadLibrary("JNaoQi");
  }

  public static void main(String[] args)
  {
	ALMotionProxy motionProxy;
	motionProxy = new ALMotionProxy("127.0.0.1",9559);
	

    	String effector   = "LArm";
	int space      = motion.SPACE_NAO;
        int axisMask   = motion.AXIS_MASK_VEL;    // just control position
        boolean isAbsolute = false;

        //Since we are in relative, the current position is zero
        float[] currentPos = {0.01f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    	// Define the changes relative to the current position
    	float dx         =  0.03f;      // translation axis X (meters)
    	float dy         =  0.03f;      // translation axis Y (meters)
    	float dz         =  0.0f;      // translation axis Z (meters)
    	float dwx        =  0.0f;      // rotation axis X (radians)
    	float dwy        =  0.0f;      // rotation axis Y (radians)
    	float dwz        =  0.0f;      // rotation axis Z (radians)
    	float[] targetPos  = {dx, dy, dz, dwx, dwy, dwz};
	
    	// Go to the target and back again
	Variant targetPosV =  new  Variant(targetPos);
	Variant currentPosV = new  Variant(currentPos);
	Variant pathV = new Variant();
	pathV.push_back(targetPosV);
	pathV.push_back(currentPosV);

	Variant t1 = new Variant(2.0f);
	Variant t2 = new Variant(4.0f);

	Variant timesV = new Variant();
	timesV.push_back(t1);
	timesV.push_back(t2);
	
     	motionProxy.positionInterpolation(effector, space, pathV, axisMask, timesV, isAbsolute);
	
  }
}

