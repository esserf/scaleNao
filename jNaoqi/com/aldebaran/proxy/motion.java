
package com.aldebaran.proxy;

// Class Motion for storing useful ALMotion constants

interface motion
{
 //   public static final int MY_BDATE = 10;
  //  public static final boolean SillyPlatform = true;


// SPACES
    public static final int SPACE_TORSO = 0;
    public static final int SPACE_WORLD = 1;
    public static final int SPACE_NAO   = 2;

// MOVEMENT
public static final int MVT_RELATIVE = 0;
public static final int MVT_ABSOLUTE = 1;

// ANGLE TYPE
public static final int COMMANDS = 0;
public static final int SENSORS  = 1;

// AXIS MASK
public static final int AXIS_MASK_X   = 1;
public static final int AXIS_MASK_Y   = 2;
public static final int AXIS_MASK_Z   = 4;;
public static final int AXIS_MASK_WX  = 8;
public static final int AXIS_MASK_WY  = 16;
public static final int AXIS_MASK_WZ  = 32;
public static final int AXIS_MASK_ALL = 63;
public static final int AXIS_MASK_VEL = 7;
public static final int AXIS_MASK_ROT = 56;

// COMPUTING
public static final float TO_RAD = 0.01745329f;
public static final float TO_DEG = 57.295779513082323f;

}
