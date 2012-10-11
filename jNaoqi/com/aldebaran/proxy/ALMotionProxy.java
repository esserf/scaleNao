// Author: Aldebaran-Robotics
// Auto generated file.



package com.aldebaran.proxy;
public class ALMotionProxy extends ALProxy
{
 	static
	{
	  System.loadLibrary("JNaoQi");
	}

 	public ALProxy proxy;

	public static void main(String[] args)
	{
	}

	/// <summary>
	/// Default Constructor.
	/// </summary>
	public ALMotionProxy(String ip, int port)
	{
		super("ALMotion", ip, port);
	}

    /// <summary>
    /// Interpolates one or multiple joints to a target angle or along timed trajectories. This is a blocking call.
    /// </summary>
    /// <param name="names"> Name or names of joints, chains, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <param name="angleLists"> An angle, list of angles or list of list of angles in radians </param>
    /// <param name="timeLists"> A time, list of times or list of list of times in seconds </param>
    /// <param name="isAbsolute"> If true, the movement is described in absolute angles, else the angles are relative to the current angle. </param>

    
    
    
    
    
    
    
    
    
    public void angleInterpolation( Variant names,  Variant angleLists,  Variant timeLists,  Boolean isAbsolute)
    {

	Variant vnames;
	vnames = new Variant(names);
	Variant vangleLists;
	vangleLists = new Variant(angleLists);
	Variant vtimeLists;
	vtimeLists = new Variant(timeLists);
	Variant visAbsolute;
	visAbsolute = new Variant(isAbsolute);

	Variant result = call("angleInterpolation" ,vnames, vangleLists, vtimeLists, visAbsolute);

		// no return value
    }

    



    /// <summary>
    /// Interpolates a sequence of timed angles for several motors using bezier control points. This is a blocking call.
    /// </summary>
    /// <param name="jointNames"> A vector of joint names </param>
    /// <param name="times"> An ragged ALValue matrix of floats. Each line corresponding to a motor, and column element to a control point. </param>
    /// <param name="controlPoints"> An ALValue array of arrays each containing [float angle, Handle1, Handle2], where Handle is [int InterpolationType, float dAngle, float dTime] descibing the handle offsets relative to the angle and time of the point. The first bezier param describes the handle that controls the curve preceeding the point, the second describes the curve following the point. </param>

    
    
    
    
    
    
    
    public void angleInterpolationBezier( String[] jointNames,  Variant times,  Variant controlPoints)
    {

	Variant vjointNames;
	vjointNames = new Variant(jointNames);
	Variant vtimes;
	vtimes = new Variant(times);
	Variant vcontrolPoints;
	vcontrolPoints = new Variant(controlPoints);

	Variant result = call("angleInterpolationBezier" ,vjointNames, vtimes, vcontrolPoints);

		// no return value
    }

    



    /// <summary>
    /// Interpolates one or multiple joints to a target angle, using a fraction of max speed. Only one target angle is allowed for each joint. This is a blocking call.
    /// </summary>
    /// <param name="names"> Name or names of joints, chains, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <param name="targetAngles"> An angle, or list of angles in radians </param>
    /// <param name="maxSpeedFraction"> A fraction. </param>

    
    
    
    
    
    
    
    public void angleInterpolationWithSpeed( Variant names,  Variant targetAngles,  float maxSpeedFraction)
    {

	Variant vnames;
	vnames = new Variant(names);
	Variant vtargetAngles;
	vtargetAngles = new Variant(targetAngles);
	Variant vmaxSpeedFraction;
	vmaxSpeedFraction = new Variant(maxSpeedFraction);

	Variant result = call("angleInterpolationWithSpeed" ,vnames, vtargetAngles, vmaxSpeedFraction);

		// no return value
    }

    



    /// <summary>
    /// Returns true if all the desired resources are available. Only motion API's' blocking call takes resources.
    /// </summary>
    /// <param name="resourceNames"> A vector of resource names such as joints. Use getJointNames(\"Body\") to have the list of the available joint for your robot. </param>
    /// <returns> True if the resources are available </returns>

    
    
    
    public Boolean areResourcesAvailable( String[] resourceNames)
    {

	Variant vresourceNames;
	vresourceNames = new Variant(resourceNames);

	Variant result = call("areResourcesAvailable" ,vresourceNames);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Changes Angles. This is a non-blocking call.
    /// </summary>
    /// <param name="names"> The name or names of joints, chains, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <param name="changes"> One or more changes in radians </param>
    /// <param name="fractionMaxSpeed"> The fraction of maximum speed to use </param>

    
    
    
    
    
    
    
    public void changeAngles( Variant names,  Variant changes,  float fractionMaxSpeed)
    {

	Variant vnames;
	vnames = new Variant(names);
	Variant vchanges;
	vchanges = new Variant(changes);
	Variant vfractionMaxSpeed;
	vfractionMaxSpeed = new Variant(fractionMaxSpeed);

	Variant result = call("changeAngles" ,vnames, vchanges, vfractionMaxSpeed);

		// no return value
    }

    



    /// <summary>
    /// Creates a move of an end effector in cartesian space. This is a non-blocking call.
    /// </summary>
    /// <param name="effectorName"> Name of the effector. </param>
    /// <param name="space"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="positionChange"> 6D position change array (xd, yd, zd, wxd, wyd, wzd) in meters and radians </param>
    /// <param name="fractionMaxSpeed"> The fraction of maximum speed to use </param>
    /// <param name="axisMask"> Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both </param>

    
    
    
    
    
    
    
    
    
    
    
    public void changePosition( String effectorName,  int space,  float[] positionChange,  float fractionMaxSpeed,  int axisMask)
    {

	Variant veffectorName;
	veffectorName = new Variant(effectorName);
	Variant vspace;
	vspace = new Variant(space);
	Variant vpositionChange;
	vpositionChange = new Variant(positionChange);
	Variant vfractionMaxSpeed;
	vfractionMaxSpeed = new Variant(fractionMaxSpeed);
	Variant vaxisMask;
	vaxisMask = new Variant(axisMask);

	Variant result = call("changePosition" ,veffectorName, vspace, vpositionChange, vfractionMaxSpeed, vaxisMask);

		// no return value
    }

    



    /// <summary>
    /// Moves an end-effector to the given position and orientation transform. This is a non-blocking call.
    /// </summary>
    /// <param name="chainName"> Name of the chain. Could be: \"Head\", \"LArm\",\"RArm\", \"LLeg\", \"RLeg\", \"Torso\" </param>
    /// <param name="space"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="transform"> Transform arrays </param>
    /// <param name="fractionMaxSpeed"> The fraction of maximum speed to use </param>
    /// <param name="axisMask"> Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both </param>

    
    
    
    
    
    
    
    
    
    
    
    public void changeTransform( String chainName,  int space,  float[] transform,  float fractionMaxSpeed,  int axisMask)
    {

	Variant vchainName;
	vchainName = new Variant(chainName);
	Variant vspace;
	vspace = new Variant(space);
	Variant vtransform;
	vtransform = new Variant(transform);
	Variant vfractionMaxSpeed;
	vfractionMaxSpeed = new Variant(fractionMaxSpeed);
	Variant vaxisMask;
	vaxisMask = new Variant(axisMask);

	Variant result = call("changeTransform" ,vchainName, vspace, vtransform, vfractionMaxSpeed, vaxisMask);

		// no return value
    }

    



    /// <summary>
    /// Closes the hand, then cuts motor current to conserve energy. This is a blocking call.
    /// </summary>
    /// <param name="handName"> The name of the hand. Could be: \"RHand\" or \"LHand\" </param>

    
    
    
    public void closeHand( String handName)
    {

	Variant vhandName;
	vhandName = new Variant(handName);

	Variant result = call("closeHand" ,vhandName);

		// no return value
    }

    



    /// <summary>
    /// Exits and unregisters the module.
    /// </summary>

    
    public void exit()
    {


	Variant result = call("exit" );

		// no return value
    }

    



    /// <summary>
    /// Gets the angles of the joints
    /// </summary>
    /// <param name="names"> Names the joints, chains, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <param name="useSensors"> If true, sensor angles will be returned </param>
    /// <returns> Joint angles in radians. </returns>

    
    
    
    
    
    public float[] getAngles( Variant names,  Boolean useSensors)
    {

	Variant vnames;
	vnames = new Variant(names);
	Variant vuseSensors;
	vuseSensors = new Variant(useSensors);

	Variant result = call("getAngles" ,vnames, vuseSensors);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Gets the name of the parent broker.
    /// </summary>
    /// <returns> The name of the parent broker. </returns>

    
    public String getBrokerName()
    {


	Variant result = call("getBrokerName" );

	    	return  result.toString();
    }

    



    /// <summary>
    /// Gets the COM of a joint, chain, \"Body\" or \"BodyJoints\".
    /// </summary>
    /// <param name="pName"> Name of the body which we want the mass. In chain name case, this function give the com of the chain. </param>
    /// <param name="pSpace"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="pUseSensorValues"> If true, the sensor values will be used to determine the position. </param>
    /// <returns> The COM position (meter). </returns>

    
    
    
    
    
    
    
    public float[] getCOM( String pName,  int pSpace,  Boolean pUseSensorValues)
    {

	Variant vpName;
	vpName = new Variant(pName);
	Variant vpSpace;
	vpSpace = new Variant(pSpace);
	Variant vpUseSensorValues;
	vpUseSensorValues = new Variant(pUseSensorValues);

	Variant result = call("getCOM" ,vpName, vpSpace, vpUseSensorValues);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Allow to know if the collision protection is activated on the given chain.
    /// </summary>
    /// <param name="pChainName"> The chain name {\"LArm\" or \"RArm\"}. </param>
    /// <returns> Return true is the collision protection of the given Arm is activated. </returns>

    
    
    
    public Boolean getCollisionProtectionEnabled( String pChainName)
    {

	Variant vpChainName;
	vpChainName = new Variant(pChainName);

	Variant result = call("getCollisionProtectionEnabled" ,vpChainName);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Gets the foot Gait config (\"MaxStepX\", \"MaxStepY\", \"MaxStepTheta\",  \"MaxStepFrequency\", \"StepHeight\", \"TorsoWx\", \"TorsoWy\")
    /// </summary>
    /// <param name="config"> a string should be \"Max\", \"Min\", \"Default\" </param>
    /// <returns> An ALvalue with the following form :[[\"MaxStepX\", value], </returns>

    
    
    
    public Variant getFootGaitConfig( String config)
    {

	Variant vconfig;
	vconfig = new Variant(config);

	Variant result = call("getFootGaitConfig" ,vconfig);

	    	return  result;
    }

    



    /// <summary>
    /// Get the foot steps. This is a non-blocking call.
    /// </summary>
    /// <returns> Give two list of foot steps. The first one give the unchangeable foot step. The second list give the changeable foot steps. Il you use setFootSteps or setFootStepsWithSpeed with clearExisting parmater equal true, walk engine execute unchangeable foot step and remove the other. </returns>

    
    public Variant getFootSteps()
    {


	Variant result = call("getFootSteps" );

	    	return  result;
    }

    



    /// <summary>
    /// Gets the names of all the joints in the collection.
    /// </summary>
    /// <param name="name"> Name of a chain, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <returns> Vector of strings, one for each joint in the collection </returns>

    
    
    
    public String[] getJointNames( String name)
    {

	Variant vname;
	vname = new Variant(name);

	Variant result = call("getJointNames" ,vname);

	    	return (String[]) result.toStringArray();
    }

    



    /// <summary>
    /// Get the minAngle (rad), maxAngle (rad), and maxVelocity (rad.s-1) for a given joint or actuator in the body.
    /// </summary>
    /// <param name="name"> Name of a joint, chain, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <returns> Array of ALValue arrays containing the minAngle, maxAngle and maxVelocity for all the joints specified. </returns>

    
    
    
    public Variant getLimits( String name)
    {

	Variant vname;
	vname = new Variant(name);

	Variant result = call("getLimits" ,vname);

	    	return  result;
    }

    



    /// <summary>
    /// Gets the mass of a joint, chain, \"Body\" or \"BodyJoints\".
    /// </summary>
    /// <param name="pName"> Name of the body which we want the mass. \"Body\", \"BodyJoints\" and \"Com\" give the total mass of nao. For the chain, it gives the total mass of the chain. </param>
    /// <returns> The mass in kg. </returns>

    
    
    
    public float getMass( String pName)
    {

	Variant vpName;
	vpName = new Variant(pName);

	Variant result = call("getMass" ,vpName);

	    	return  result.toFloat();
    }

    



    /// <summary>
    /// Retrieves a method's description.
    /// </summary>
    /// <param name="methodName"> The name of the method. </param>
    /// <returns> A structure containing the method's description. </returns>

    
    
    
    public Variant getMethodHelp( String methodName)
    {

	Variant vmethodName;
	vmethodName = new Variant(methodName);

	Variant result = call("getMethodHelp" ,vmethodName);

	    	return  result;
    }

    



    /// <summary>
    /// Retrieves the module's method list.
    /// </summary>
    /// <returns> An array of method names. </returns>

    
    public String[] getMethodList()
    {


	Variant result = call("getMethodList" );

	    	return (String[]) result.toStringArray();
    }

    



    /// <summary>
    /// Retrieves the module's description.
    /// </summary>
    /// <returns> A structure describing the module. </returns>

    
    public Variant getModuleHelp()
    {


	Variant result = call("getModuleHelp" );

	    	return  result;
    }

    



    /// <summary>
    /// Gets the World Absolute next Robot Position.
    /// </summary>
    /// <returns> A vector containing the World Absolute next Robot position.(Absolute Position X, Absolute Position Y, Absolute Angle Z) </returns>

    
    public float[] getNextRobotPosition()
    {


	Variant result = call("getNextRobotPosition" );

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Gets a Position relative to the TASK_SPACE. Axis definition: the x axis is positive toward Nao's front, the y from right to left and the z is vertical. The angle convention of Position6D is Rot_z(wz).Rot_y(wy).Rot_x(wx).
    /// </summary>
    /// <param name="name"> Name of the item. Could be: Head, LArm, RArm, LLeg, RLeg, Torso, CameraTop, CameraBottom, MicroFront, MicroRear, MicroLeft, MicroRight, Accelerometer, Gyrometer, Laser, LFsrFR, LFsrFL, LFsrRR, LFsrRL, RFsrFR, RFsrFL, RFsrRR, RFsrRL, USSensor1, USSensor2, USSensor3, USSensor4. Use getSensorNames for the list of sensors supported on your robot. </param>
    /// <param name="space"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="useSensorValues"> If true, the sensor values will be used to determine the position. </param>
    /// <returns> Vector containing the Position6D using meters and radians (x, y, z, wx, wy, wz) </returns>

    
    
    
    
    
    
    
    public float[] getPosition( String name,  int space,  Boolean useSensorValues)
    {

	Variant vname;
	vname = new Variant(name);
	Variant vspace;
	vspace = new Variant(space);
	Variant vuseSensorValues;
	vuseSensorValues = new Variant(useSensorValues);

	Variant result = call("getPosition" ,vname, vspace, vuseSensorValues);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Get the robot configuration.
    /// </summary>
    /// <returns> ALValue arrays containing the robot parameter names and the robot parameter values. </returns>

    
    public Variant getRobotConfig()
    {


	Variant result = call("getRobotConfig" );

	    	return  result;
    }

    



    /// <summary>
    /// Gets the World Absolute Robot Position.
    /// </summary>
    /// <param name="useSensors"> If true, use the sensor values </param>
    /// <returns> A vector containing the World Absolute Robot Position. (Absolute Position X, Absolute Position Y, Absolute Angle Z) </returns>

    
    
    
    public float[] getRobotPosition( Boolean useSensors)
    {

	Variant vuseSensors;
	vuseSensors = new Variant(useSensors);

	Variant result = call("getRobotPosition" ,vuseSensors);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Gets the World Absolute Robot Velocity.
    /// </summary>
    /// <returns> A vector containing the World Absolute Robot Velocity. (Absolute Velocity Translation X [m.s-1], Absolute Velocity Translation Y[m.s-1], Absolute Velocity Rotation WZ [rd.s-1]) </returns>

    
    public float[] getRobotVelocity()
    {


	Variant result = call("getRobotVelocity" );

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Gets the list of sensors supported on your robot.
    /// </summary>
    /// <returns> Vector of sensor names </returns>

    
    public String[] getSensorNames()
    {


	Variant result = call("getSensorNames" );

	    	return (String[]) result.toStringArray();
    }

    



    /// <summary>
    /// Gets stiffness of a joint or group of joints
    /// </summary>
    /// <param name="jointName"> Name of the joints, chains, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <returns> One or more stiffnesses. 1.0 indicates maximum stiffness. 0.0 indicated minimum stiffness </returns>

    
    
    
    public float[] getStiffnesses( Variant jointName)
    {

	Variant vjointName;
	vjointName = new Variant(jointName);

	Variant result = call("getStiffnesses" ,vjointName);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Returns a string representation of the Model's state
    /// </summary>
    /// <returns> A formated string </returns>

    
    public String getSummary()
    {


	Variant result = call("getSummary" );

	    	return  result.toString();
    }

    



    /// <summary>
    /// Gets an ALValue structure describing the tasks in the Task List
    /// </summary>
    /// <returns> An ALValue containing an ALValue for each task. The inner ALValue contains: Name, MotionID </returns>

    
    public Variant getTaskList()
    {


	Variant result = call("getTaskList" );

	    	return  result;
    }

    



    /// <summary>
    /// Gets an Homogenous Transform relative to the TASK_SPACE. Axis definition: the x axis is positive toward Nao's front, the y from right to left and the z is vertical.
    /// </summary>
    /// <param name="name"> Name of the item. Could be: any joint or chain or sensor (Head, LArm, RArm, LLeg, RLeg, Torso, HeadYaw, ..., CameraTop, CameraBottom, MicroFront, MicroRear, MicroLeft, MicroRight, Accelerometer, Gyrometer, Laser, LFsrFR, LFsrFL, LFsrRR, LFsrRL, RFsrFR, RFsrFL, RFsrRR, RFsrRL, USSensor1, USSensor2, USSensor3, USSensor4. Use getSensorNames for the list of sensors supported on your robot. </param>
    /// <param name="space"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="useSensorValues"> If true, the sensor values will be used to determine the position. </param>
    /// <returns> Vector of 16 floats corresponding to the values of the matrix, line by line. </returns>

    
    
    
    
    
    
    
    public float[] getTransform( String name,  int space,  Boolean useSensorValues)
    {

	Variant vname;
	vname = new Variant(name);
	Variant vspace;
	vspace = new Variant(space);
	Variant vuseSensorValues;
	vuseSensorValues = new Variant(useSensorValues);

	Variant result = call("getTransform" ,vname, vspace, vuseSensorValues);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Gets the method usage string. This summarise how to use the method.
    /// </summary>
    /// <param name="name"> The name of the method. </param>
    /// <returns> A string that summarises the usage of the method. </returns>

    
    
    
    public String getUsage( String name)
    {

	Variant vname;
	vname = new Variant(name);

	Variant result = call("getUsage" ,vname);

	    	return  result.toString();
    }

    



    /// <summary>
    /// DEPRECATED method.
    /// </summary>
    /// <returns> True Arm Motions are controlled by the Walk Task. </returns>

    
    public Variant getWalkArmsEnable()
    {


	Variant result = call("getWalkArmsEnable" );

	    	return  result;
    }

    



    /// <summary>
    /// Gets if Arms Motions are enabled during the Walk Process.
    /// </summary>
    /// <returns> True Arm Motions are controlled by the Walk Task. </returns>

    
    public Variant getWalkArmsEnabled()
    {


	Variant result = call("getWalkArmsEnabled" );

	    	return  result;
    }

    



    /// <summary>
    /// Give the collision state of a chain. If a chain has a collision state \"none\" or \"near\", it could be desactivated.
    /// </summary>
    /// <param name="pChainName"> The chain name {\"Arms\", \"LArm\" or \"RArm\"}. </param>
    /// <returns> A string which notice the collision state: \"none\" there are no collision, \"near\" the collision is taking in account in the anti-collision algorithm, \"collision\" the chain is in contact with an other body. If the chain asked is \"Arms\" the most unfavorable result is given. </returns>

    
    
    
    public String isCollision( String pChainName)
    {

	Variant vpChainName;
	vpChainName = new Variant(pChainName);

	Variant result = call("isCollision" ,vpChainName);

	    	return  result.toString();
    }

    



    /// <summary>
    /// Returns true if the method is currently running.
    /// </summary>
    /// <param name="id"> The ID of the method that was returned when calling the method using 'post' </param>
    /// <returns> True if the method is currently running </returns>

    
    
    
    public Boolean isRunning( int id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("isRunning" ,vid);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Kills all tasks.
    /// </summary>

    
    public void killAll()
    {


	Variant result = call("killAll" );

		// no return value
    }

    



    /// <summary>
    /// Kills a motion task.
    /// </summary>
    /// <param name="motionTaskID"> TaskID of the motion task you want to kill. </param>
    /// <returns> Return true if the specified motionTaskId has been killed. </returns>

    
    
    
    public Boolean killTask( int motionTaskID)
    {

	Variant vmotionTaskID;
	vmotionTaskID = new Variant(motionTaskID);

	Variant result = call("killTask" ,vmotionTaskID);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Kills all tasks that use any of the resources given. Only motion API's' blocking call takes resources and can be killed. Use getJointNames(\"Body\") to have the list of the available joint for your robot.
    /// </summary>
    /// <param name="resourceNames"> A vector of resource joint names </param>

    
    
    
    public void killTasksUsingResources( String[] resourceNames)
    {

	Variant vresourceNames;
	vresourceNames = new Variant(resourceNames);

	Variant result = call("killTasksUsingResources" ,vresourceNames);

		// no return value
    }

    



    /// <summary>
    /// Emergency Stop on Walk task: This method will end the walk task brutally, without attempting to return to a balanced state. If Nao has one foot in the air, he could easily fall.
    /// </summary>

    
    public void killWalk()
    {


	Variant result = call("killWalk" );

		// no return value
    }

    



    /// <summary>
    /// Opens the hand, then cuts motor current to conserve energy. This is a blocking call.
    /// </summary>
    /// <param name="handName"> The name of the hand. Could be: \"RHand or \"LHand\" </param>

    
    
    
    public void openHand( String handName)
    {

	Variant vhandName;
	vhandName = new Variant(handName);

	Variant result = call("openHand" ,vhandName);

		// no return value
    }

    



    /// <summary>
    /// Just a ping. Always returns true
    /// </summary>
    /// <returns> returns true </returns>

    
    public Boolean ping()
    {


	Variant result = call("ping" );

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Moves an end-effector to the given position and orientation over time. This is a blocking call.
    /// </summary>
    /// <param name="chainName"> Name of the chain. Could be: \"Head\", \"LArm\", \"RArm\", \"LLeg\", \"RLeg\", \"Torso\" </param>
    /// <param name="space"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="path"> Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians </param>
    /// <param name="axisMask"> Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both </param>
    /// <param name="durations"> Vector of times in seconds corresponding to the path points </param>
    /// <param name="isAbsolute"> If true, the movement is absolute else relative </param>

    
    
    
    
    
    
    
    
    
    
    
    
    
    public void positionInterpolation( String chainName,  int space,  Variant path,  int axisMask,  Variant durations,  Boolean isAbsolute)
    {

	Variant vchainName;
	vchainName = new Variant(chainName);
	Variant vspace;
	vspace = new Variant(space);
	Variant vpath;
	vpath = new Variant(path);
	Variant vaxisMask;
	vaxisMask = new Variant(axisMask);
	Variant vdurations;
	vdurations = new Variant(durations);
	Variant visAbsolute;
	visAbsolute = new Variant(isAbsolute);

	Variant result = call("positionInterpolation" ,vchainName, vspace, vpath, vaxisMask, vdurations, visAbsolute);

		// no return value
    }

    



    /// <summary>
    /// Moves end-effectors to the given positions and orientations over time. This is a blocking call.
    /// </summary>
    /// <param name="effectorNames"> Vector of chain names. Could be: \"Head\", \"LArm\", \"RArm\", \"LLeg\", \"RLeg\", \"Torso\" </param>
    /// <param name="taskSpaceForAllPaths"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="paths"> Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians </param>
    /// <param name="axisMasks"> Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both </param>
    /// <param name="relativeTimes"> Vector of times in seconds corresponding to the path points </param>
    /// <param name="isAbsolute"> If true, the movement is absolute else relative </param>

    
    
    
    
    
    
    
    
    
    
    
    
    
    public void positionInterpolations( String[] effectorNames,  int taskSpaceForAllPaths,  Variant paths,  Variant axisMasks,  Variant relativeTimes,  Boolean isAbsolute)
    {

	Variant veffectorNames;
	veffectorNames = new Variant(effectorNames);
	Variant vtaskSpaceForAllPaths;
	vtaskSpaceForAllPaths = new Variant(taskSpaceForAllPaths);
	Variant vpaths;
	vpaths = new Variant(paths);
	Variant vaxisMasks;
	vaxisMasks = new Variant(axisMasks);
	Variant vrelativeTimes;
	vrelativeTimes = new Variant(relativeTimes);
	Variant visAbsolute;
	visAbsolute = new Variant(isAbsolute);

	Variant result = call("positionInterpolations" ,veffectorNames, vtaskSpaceForAllPaths, vpaths, vaxisMasks, vrelativeTimes, visAbsolute);

		// no return value
    }

    



    /// <summary>
    /// Sets angles. This is a non-blocking call.
    /// </summary>
    /// <param name="names"> The name or names of joints, chains, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <param name="angles"> One or more angles in radians </param>
    /// <param name="fractionMaxSpeed"> The fraction of maximum speed to use </param>

    
    
    
    
    
    
    
    public void setAngles( Variant names,  Variant angles,  float fractionMaxSpeed)
    {

	Variant vnames;
	vnames = new Variant(names);
	Variant vangles;
	vangles = new Variant(angles);
	Variant vfractionMaxSpeed;
	vfractionMaxSpeed = new Variant(fractionMaxSpeed);

	Variant result = call("setAngles" ,vnames, vangles, vfractionMaxSpeed);

		// no return value
    }

    



    /// <summary>
    /// Enable Anticollision protection of the arms of the robot. Use api isCollision to know if a chain is in collision and can be disactivated.
    /// </summary>
    /// <param name="pChainName"> The chain name {\"Arms\", \"LArm\" or \"RArm\"}. </param>
    /// <param name="pEnable"> Activate or disactivate the anticollision of the desired Chain. </param>
    /// <returns> A bool which notice if the desired activation/disactivation is applyed successfully. Activation always success. Disactivation success only if the current state of the chain is not in collision. If we want to disactivate collision of the both arms (\"Arms\"), the two arms must be without collision. </returns>

    
    
    
    
    
    public Boolean setCollisionProtectionEnabled( String pChainName,  Boolean pEnable)
    {

	Variant vpChainName;
	vpChainName = new Variant(pChainName);
	Variant vpEnable;
	vpEnable = new Variant(pEnable);

	Variant result = call("setCollisionProtectionEnabled" ,vpChainName, vpEnable);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Makes Nao do foot step planner. This is a non-blocking call.
    /// </summary>
    /// <param name="legName"> name of the leg to move('LLeg'or 'RLeg') </param>
    /// <param name="footSteps"> [x, y, theta], [Position along X/Y, Orientation round Z axis] of the leg relative to the other Leg in [meters, meters, radians]. Must be less than [MaxStepX, MaxStepY, MaxStepTheta] </param>
    /// <param name="timeList"> time list of each foot step </param>
    /// <param name="clearExisting"> Clear existing foot steps. </param>

    
    
    
    
    
    
    
    
    
    public void setFootSteps( String[] legName,  Variant footSteps,  float[] timeList,  Boolean clearExisting)
    {

	Variant vlegName;
	vlegName = new Variant(legName);
	Variant vfootSteps;
	vfootSteps = new Variant(footSteps);
	Variant vtimeList;
	vtimeList = new Variant(timeList);
	Variant vclearExisting;
	vclearExisting = new Variant(clearExisting);

	Variant result = call("setFootSteps" ,vlegName, vfootSteps, vtimeList, vclearExisting);

		// no return value
    }

    



    /// <summary>
    /// Makes Nao do foot step planner with speed. This is a blocking call.
    /// </summary>
    /// <param name="legName"> name of the leg to move('LLeg'or 'RLeg') </param>
    /// <param name="footSteps"> [x, y, theta], [Position along X/Y, Orientation round Z axis] of the leg relative to the other Leg in [meters, meters, radians]. Must be less than [MaxStepX, MaxStepY, MaxStepTheta] </param>
    /// <param name="fractionMaxSpeed"> speed of each foot step. Must be between 0 and 1. </param>
    /// <param name="clearExisting"> Clear existing foot steps. </param>

    
    
    
    
    
    
    
    
    
    public void setFootStepsWithSpeed( String[] legName,  Variant footSteps,  float[] fractionMaxSpeed,  Boolean clearExisting)
    {

	Variant vlegName;
	vlegName = new Variant(legName);
	Variant vfootSteps;
	vfootSteps = new Variant(footSteps);
	Variant vfractionMaxSpeed;
	vfractionMaxSpeed = new Variant(fractionMaxSpeed);
	Variant vclearExisting;
	vclearExisting = new Variant(clearExisting);

	Variant result = call("setFootStepsWithSpeed" ,vlegName, vfootSteps, vfractionMaxSpeed, vclearExisting);

		// no return value
    }

    



    /// <summary>
    /// Internal Use.
    /// </summary>
    /// <param name="config"> Internal: An array of ALValues [i][0]: name, [i][1]: value </param>

    
    
    
    public void setMotionConfig( Variant config)
    {

	Variant vconfig;
	vconfig = new Variant(config);

	Variant result = call("setMotionConfig" ,vconfig);

		// no return value
    }

    



    /// <summary>
    /// Moves an end-effector to the given position and orientation. This is a non-blocking call.
    /// </summary>
    /// <param name="chainName"> Name of the chain. Could be: \"Head\", \"LArm\",\"RArm\", \"LLeg\", \"RLeg\", \"Torso\" </param>
    /// <param name="space"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="position"> 6D position array (x,y,z,wx,wy,wz) in meters and radians </param>
    /// <param name="fractionMaxSpeed"> The fraction of maximum speed to use </param>
    /// <param name="axisMask"> Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both </param>

    
    
    
    
    
    
    
    
    
    
    
    public void setPosition( String chainName,  int space,  float[] position,  float fractionMaxSpeed,  int axisMask)
    {

	Variant vchainName;
	vchainName = new Variant(chainName);
	Variant vspace;
	vspace = new Variant(space);
	Variant vposition;
	vposition = new Variant(position);
	Variant vfractionMaxSpeed;
	vfractionMaxSpeed = new Variant(fractionMaxSpeed);
	Variant vaxisMask;
	vaxisMask = new Variant(axisMask);

	Variant result = call("setPosition" ,vchainName, vspace, vposition, vfractionMaxSpeed, vaxisMask);

		// no return value
    }

    



    /// <summary>
    /// Sets the stiffness of one or more joints. This is a non-blocking call.
    /// </summary>
    /// <param name="names"> Names of joints, chains, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <param name="stiffnesses"> One or more stiffnesses between zero and one. </param>

    
    
    
    
    
    public void setStiffnesses( Variant names,  Variant stiffnesses)
    {

	Variant vnames;
	vnames = new Variant(names);
	Variant vstiffnesses;
	vstiffnesses = new Variant(stiffnesses);

	Variant result = call("setStiffnesses" ,vnames, vstiffnesses);

		// no return value
    }

    



    /// <summary>
    /// Moves an end-effector to the given position and orientation transform. This is a non-blocking call.
    /// </summary>
    /// <param name="chainName"> Name of the chain. Could be: \"Head\", \"LArm\",\"RArm\", \"LLeg\", \"RLeg\", \"Torso\" </param>
    /// <param name="space"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="transform"> Transform arrays </param>
    /// <param name="fractionMaxSpeed"> The fraction of maximum speed to use </param>
    /// <param name="axisMask"> Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both </param>

    
    
    
    
    
    
    
    
    
    
    
    public void setTransform( String chainName,  int space,  float[] transform,  float fractionMaxSpeed,  int axisMask)
    {

	Variant vchainName;
	vchainName = new Variant(chainName);
	Variant vspace;
	vspace = new Variant(space);
	Variant vtransform;
	vtransform = new Variant(transform);
	Variant vfractionMaxSpeed;
	vfractionMaxSpeed = new Variant(fractionMaxSpeed);
	Variant vaxisMask;
	vaxisMask = new Variant(axisMask);

	Variant result = call("setTransform" ,vchainName, vspace, vtransform, vfractionMaxSpeed, vaxisMask);

		// no return value
    }

    



    /// <summary>
    /// DEPRECATED method.
    /// </summary>
    /// <param name="leftArmEnable"> if true Left Arm motions are controlled by the Walk Task </param>
    /// <param name="rightArmEnable"> if true Right Arm mMotions are controlled by the Walk Task </param>

    
    
    
    
    
    public void setWalkArmsEnable( Boolean leftArmEnable,  Boolean rightArmEnable)
    {

	Variant vleftArmEnable;
	vleftArmEnable = new Variant(leftArmEnable);
	Variant vrightArmEnable;
	vrightArmEnable = new Variant(rightArmEnable);

	Variant result = call("setWalkArmsEnable" ,vleftArmEnable, vrightArmEnable);

		// no return value
    }

    



    /// <summary>
    /// Sets if Arms Motions are enabled during the Walk Process.
    /// </summary>
    /// <param name="leftArmEnable"> if true Left Arm motions are controlled by the Walk Task </param>
    /// <param name="rightArmEnable"> if true Right Arm mMotions are controlled by the Walk Task </param>

    
    
    
    
    
    public void setWalkArmsEnabled( Boolean leftArmEnable,  Boolean rightArmEnable)
    {

	Variant vleftArmEnable;
	vleftArmEnable = new Variant(leftArmEnable);
	Variant vrightArmEnable;
	vrightArmEnable = new Variant(rightArmEnable);

	Variant result = call("setWalkArmsEnabled" ,vleftArmEnable, vrightArmEnable);

		// no return value
    }

    



    /// <summary>
    /// Makes Nao walk at the given velocity. This is a non-blocking call.
    /// </summary>
    /// <param name="x"> Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0] </param>
    /// <param name="y"> Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0] </param>
    /// <param name="theta"> Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0] </param>
    /// <param name="frequency"> Fraction of MaxStepFrequency [0.0 to 1.0] </param>

    
    
    
    
    
    
    
    
    
    public void setWalkTargetVelocity( float x,  float y,  float theta,  float frequency)
    {

	Variant vx;
	vx = new Variant(x);
	Variant vy;
	vy = new Variant(y);
	Variant vtheta;
	vtheta = new Variant(theta);
	Variant vfrequency;
	vfrequency = new Variant(frequency);

	Variant result = call("setWalkTargetVelocity" ,vx, vy, vtheta, vfrequency);

		// no return value
    }

    



    /// <summary>
    /// Makes Nao walk at the given velocity. This is a non-blocking call.
    /// </summary>
    /// <param name="x"> Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0] </param>
    /// <param name="y"> Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0] </param>
    /// <param name="theta"> Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0] </param>
    /// <param name="frequency"> Fraction of MaxStepFrequency [0.0 to 1.0] </param>
    /// <param name="feetGaitConfig"> An ALValue with the custom gait configuration for both feet </param>

    
    
    
    
    
    
    
    
    
    
    
    public void setWalkTargetVelocity( float x,  float y,  float theta,  float frequency,  Variant feetGaitConfig)
    {

	Variant vx;
	vx = new Variant(x);
	Variant vy;
	vy = new Variant(y);
	Variant vtheta;
	vtheta = new Variant(theta);
	Variant vfrequency;
	vfrequency = new Variant(frequency);
	Variant vfeetGaitConfig;
	vfeetGaitConfig = new Variant(feetGaitConfig);

	Variant result = call("setWalkTargetVelocity" ,vx, vy, vtheta, vfrequency, vfeetGaitConfig);

		// no return value
    }

    



    /// <summary>
    /// Makes Nao walk at the given velocity. This is a non-blocking call.
    /// </summary>
    /// <param name="x"> Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0] </param>
    /// <param name="y"> Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0] </param>
    /// <param name="theta"> Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0] </param>
    /// <param name="frequency"> Fraction of MaxStepFrequency [0.0 to 1.0] </param>
    /// <param name="leftFootGaitConfig"> An ALValue with custom gait configuration for the left foot </param>
    /// <param name="rightFootGaitConfig"> An ALValue with custom gait configuration for the right foot </param>

    
    
    
    
    
    
    
    
    
    
    
    
    
    public void setWalkTargetVelocity( float x,  float y,  float theta,  float frequency,  Variant leftFootGaitConfig,  Variant rightFootGaitConfig)
    {

	Variant vx;
	vx = new Variant(x);
	Variant vy;
	vy = new Variant(y);
	Variant vtheta;
	vtheta = new Variant(theta);
	Variant vfrequency;
	vfrequency = new Variant(frequency);
	Variant vleftFootGaitConfig;
	vleftFootGaitConfig = new Variant(leftFootGaitConfig);
	Variant vrightFootGaitConfig;
	vrightFootGaitConfig = new Variant(rightFootGaitConfig);

	Variant result = call("setWalkTargetVelocity" ,vx, vy, vtheta, vfrequency, vleftFootGaitConfig, vrightFootGaitConfig);

		// no return value
    }

    



    /// <summary>
    /// DEPRECATED Please used new api footStepsWithSpeed.
    /// </summary>
    /// <param name="legName"> name of the leg to move('LLeg'or 'RLeg') </param>
    /// <param name="x"> Position along X axis of the leg relative to the other Leg in meters. Must be less than MaxStepX </param>
    /// <param name="y"> Position along Y axis of the leg relative to the other Leg in meters. Must be less than MaxStepY </param>
    /// <param name="theta"> Orientation round Z axis of the leg relative to the other leg in radians. Must be less than MaxStepX </param>

    
    
    
    
    
    
    
    
    
    public void stepTo( String legName,  float x,  float y,  float theta)
    {

	Variant vlegName;
	vlegName = new Variant(legName);
	Variant vx;
	vx = new Variant(x);
	Variant vy;
	vy = new Variant(y);
	Variant vtheta;
	vtheta = new Variant(theta);

	Variant result = call("stepTo" ,vlegName, vx, vy, vtheta);

		// no return value
    }

    



    /// <summary>
    /// Interpolates one or multiple joints to a target stiffness or along timed trajectories of stiffness. This is a blocking call.
    /// </summary>
    /// <param name="names"> Name or names of joints, chains, \"Body\", \"BodyJoints\" or \"BodyActuators\". </param>
    /// <param name="stiffnessLists"> An stiffness, list of stiffnesses or list of list of stiffnesses </param>
    /// <param name="timeLists"> A time, list of times or list of list of times. </param>

    
    
    
    
    
    
    
    public void stiffnessInterpolation( Variant names,  Variant stiffnessLists,  Variant timeLists)
    {

	Variant vnames;
	vnames = new Variant(names);
	Variant vstiffnessLists;
	vstiffnessLists = new Variant(stiffnessLists);
	Variant vtimeLists;
	vtimeLists = new Variant(timeLists);

	Variant result = call("stiffnessInterpolation" ,vnames, vstiffnessLists, vtimeLists);

		// no return value
    }

    



    /// <summary>
    /// returns true if the method is currently running
    /// </summary>
    /// <param name="id"> the ID of the method to wait for </param>

    
    
    
    public void stop( int id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("stop" ,vid);

		// no return value
    }

    



    /// <summary>
    /// Stop Walk task at next double support: This method will end the walk task less brutally than killWalk but more quickly than setWalkTargetVelocity(0.0, 0.0, 0.0, pFrequency).
    /// </summary>

    
    public void stopWalk()
    {


	Variant result = call("stopWalk" );

		// no return value
    }

    



    /// <summary>
    /// Moves an end-effector to the given position and orientation over time using homogenous transforms to describe the positions or changes. This is a blocking call.
    /// </summary>
    /// <param name="chainName"> Name of the chain. Could be: \"Head\", \"LArm\",\"RArm\", \"LLeg\", \"RLeg\", \"Torso\" </param>
    /// <param name="space"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="path"> Vector of Transform arrays </param>
    /// <param name="axisMask"> Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both </param>
    /// <param name="duration"> Vector of times in seconds corresponding to the path points </param>
    /// <param name="isAbsolute"> If true, the movement is absolute else relative </param>

    
    
    
    
    
    
    
    
    
    
    
    
    
    public void transformInterpolation( String chainName,  int space,  Variant path,  int axisMask,  Variant duration,  Boolean isAbsolute)
    {

	Variant vchainName;
	vchainName = new Variant(chainName);
	Variant vspace;
	vspace = new Variant(space);
	Variant vpath;
	vpath = new Variant(path);
	Variant vaxisMask;
	vaxisMask = new Variant(axisMask);
	Variant vduration;
	vduration = new Variant(duration);
	Variant visAbsolute;
	visAbsolute = new Variant(isAbsolute);

	Variant result = call("transformInterpolation" ,vchainName, vspace, vpath, vaxisMask, vduration, visAbsolute);

		// no return value
    }

    



    /// <summary>
    /// Moves end-effector to the given transforms over time. This is a blocking call.
    /// </summary>
    /// <param name="effectorNames"> Vector of chain names. Could be: \"Head\", \"LArm\", \"RArm\", \"LLeg\", \"RLeg\", \"Torso\" </param>
    /// <param name="taskSpaceForAllPaths"> Task space {SPACE_TORSO = 0, SPACE_WORLD = 1, SPACE_NAO = 2}. </param>
    /// <param name="paths"> Vector of transforms arrays. </param>
    /// <param name="axisMasks"> Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both </param>
    /// <param name="relativeTimes"> Vector of times in seconds corresponding to the path points </param>
    /// <param name="isAbsolute"> If true, the movement is absolute else relative </param>

    
    
    
    
    
    
    
    
    
    
    
    
    
    public void transformInterpolations( String[] effectorNames,  int taskSpaceForAllPaths,  Variant paths,  Variant axisMasks,  Variant relativeTimes,  Boolean isAbsolute)
    {

	Variant veffectorNames;
	veffectorNames = new Variant(effectorNames);
	Variant vtaskSpaceForAllPaths;
	vtaskSpaceForAllPaths = new Variant(taskSpaceForAllPaths);
	Variant vpaths;
	vpaths = new Variant(paths);
	Variant vaxisMasks;
	vaxisMasks = new Variant(axisMasks);
	Variant vrelativeTimes;
	vrelativeTimes = new Variant(relativeTimes);
	Variant visAbsolute;
	visAbsolute = new Variant(isAbsolute);

	Variant result = call("transformInterpolations" ,veffectorNames, vtaskSpaceForAllPaths, vpaths, vaxisMasks, vrelativeTimes, visAbsolute);

		// no return value
    }

    



    /// <summary>
    /// Update the target to follow by the head of NAO.
    /// </summary>
    /// <param name="pTargetPositionWy"> The target position wy in SPACE_NAO </param>
    /// <param name="pTargetPositionWz"> The target position wz in  SPACE_NAO </param>
    /// <param name="pTimeSinceDetectionMs"> The time in Ms since the target was detected </param>
    /// <param name="pUseOfWholeBody"> If true, the target is follow in cartesian space by the Head with whole Body constraints. </param>

    
    
    
    
    
    
    
    
    
    public void updateTrackerTarget( float pTargetPositionWy,  float pTargetPositionWz,  int pTimeSinceDetectionMs,  Boolean pUseOfWholeBody)
    {

	Variant vpTargetPositionWy;
	vpTargetPositionWy = new Variant(pTargetPositionWy);
	Variant vpTargetPositionWz;
	vpTargetPositionWz = new Variant(pTargetPositionWz);
	Variant vpTimeSinceDetectionMs;
	vpTimeSinceDetectionMs = new Variant(pTimeSinceDetectionMs);
	Variant vpUseOfWholeBody;
	vpUseOfWholeBody = new Variant(pUseOfWholeBody);

	Variant result = call("updateTrackerTarget" ,vpTargetPositionWy, vpTargetPositionWz, vpTimeSinceDetectionMs, vpUseOfWholeBody);

		// no return value
    }

    



    /// <summary>
    /// Returns the version of the module.
    /// </summary>
    /// <returns> A string containing the version of the module. </returns>

    
    public String version()
    {


	Variant result = call("version" );

	    	return  result.toString();
    }

    



    /// <summary>
    /// Wait for the end of a long running method that was called using 'post'
    /// </summary>
    /// <param name="id"> The ID of the method that was returned when calling the method using 'post' </param>
    /// <param name="timeoutPeriod"> The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero. </param>
    /// <returns> True if the timeout period terminated. False if the method returned. </returns>

    
    
    
    
    
    public Boolean wait( int id,  int timeoutPeriod)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vtimeoutPeriod;
	vtimeoutPeriod = new Variant(timeoutPeriod);

	Variant result = call("wait" ,vid, vtimeoutPeriod);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Waits until the WalkTask is finished: This method can be used to block your script/code execution until the walk task is totally finished.
    /// </summary>

    
    public void waitUntilWalkIsFinished()
    {


	Variant result = call("waitUntilWalkIsFinished" );

		// no return value
    }

    



    /// <summary>
    /// Initialize the walk process. Check the robot pose and take a right posture.This is blocking called.
    /// </summary>

    
    public void walkInit()
    {


	Variant result = call("walkInit" );

		// no return value
    }

    



    /// <summary>
    /// Return True if Walk is Active.
    /// </summary>
    /// <returns>  </returns>

    
    public Boolean walkIsActive()
    {


	Variant result = call("walkIsActive" );

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Makes Nao walk to the given relative Position. This is a blocking call.
    /// </summary>
    /// <param name="x"> Distance along the X axis in meters. </param>
    /// <param name="y"> Distance along the Y axis in meters. </param>
    /// <param name="theta"> Rotation around the Z axis in radians [-3.1415 to 3.1415]. </param>

    
    
    
    
    
    
    
    public void walkTo( float x,  float y,  float theta)
    {

	Variant vx;
	vx = new Variant(x);
	Variant vy;
	vy = new Variant(y);
	Variant vtheta;
	vtheta = new Variant(theta);

	Variant result = call("walkTo" ,vx, vy, vtheta);

		// no return value
    }

    



    /// <summary>
    /// Makes Nao walk to the given relative Position with custom gait parmaters.
    /// </summary>
    /// <param name="x"> Distance along the X axis in meters. </param>
    /// <param name="y"> Distance along the Y axis in meters. </param>
    /// <param name="theta"> Rotation around the Z axis in radians [-3.1415 to 3.1415]. </param>
    /// <param name="feetGaitConfig"> An ALValue with the custom gait configuration for both feet. </param>

    
    
    
    
    
    
    
    
    
    public void walkTo( float x,  float y,  float theta,  Variant feetGaitConfig)
    {

	Variant vx;
	vx = new Variant(x);
	Variant vy;
	vy = new Variant(y);
	Variant vtheta;
	vtheta = new Variant(theta);
	Variant vfeetGaitConfig;
	vfeetGaitConfig = new Variant(feetGaitConfig);

	Variant result = call("walkTo" ,vx, vy, vtheta, vfeetGaitConfig);

		// no return value
    }

    



    /// <summary>
    /// Makes Nao walk to the given relative Position. This is a blocking call.
    /// </summary>
    /// <param name="controlPoint"> An ALValue with all the control point [[x1,y1,theta1], ..., [xN,yN,thetaN] </param>

    
    
    
    public void walkTo( Variant controlPoint)
    {

	Variant vcontrolPoint;
	vcontrolPoint = new Variant(controlPoint);

	Variant result = call("walkTo" ,vcontrolPoint);

		// no return value
    }

    



    /// <summary>
    /// Makes Nao walk to the given relative Position. This is a blocking call.
    /// </summary>
    /// <param name="controlPoint"> An ALValue with all the control point [[x1,y1,theta1], ..., [xN,yN,thetaN] </param>
    /// <param name="feetGaitConfig"> An ALValue with the custom gait configuration for both feet </param>

    
    
    
    
    
    public void walkTo( Variant controlPoint,  Variant feetGaitConfig)
    {

	Variant vcontrolPoint;
	vcontrolPoint = new Variant(controlPoint);
	Variant vfeetGaitConfig;
	vfeetGaitConfig = new Variant(feetGaitConfig);

	Variant result = call("walkTo" ,vcontrolPoint, vfeetGaitConfig);

		// no return value
    }

    



    /// <summary>
    /// UserFriendly Whole Body API: enable Whole Body Balancer. It's a Generalized Inverse Kinematics which deals with cartesian control, balance, redundancy and task priority. The main goal is to generate and stabilized consistent motions without precomputed trajectories and adapt nao's behaviour to the situation. The generalized inverse kinematic problem takes in account equality constraints (keep foot fix), inequality constraints (joint limits, balance, ...) and quadratic minimization (cartesian / articular desired trajectories). We solve each step a quadratic programming on the robot.
    /// </summary>
    /// <param name="isEnabled"> Active / Disactive Whole Body Balancer. </param>

    
    
    
    public void wbEnable( Boolean isEnabled)
    {

	Variant visEnabled;
	visEnabled = new Variant(isEnabled);

	Variant result = call("wbEnable" ,visEnabled);

		// no return value
    }

    



    /// <summary>
    /// UserFriendly Whole Body API: enable to keep balance in support polygon.
    /// </summary>
    /// <param name="isEnable"> Enable Nao to keep balance. </param>
    /// <param name="supportLeg"> Name of the support leg: \"Legs\", \"LLeg\", \"RLeg\". </param>

    
    
    
    
    
    public void wbEnableBalanceConstraint( Boolean isEnable,  String supportLeg)
    {

	Variant visEnable;
	visEnable = new Variant(isEnable);
	Variant vsupportLeg;
	vsupportLeg = new Variant(supportLeg);

	Variant result = call("wbEnableBalanceConstraint" ,visEnable, vsupportLeg);

		// no return value
    }

    



    /// <summary>
    /// UserFriendly Whole Body API: enable whole body cartesian control of an effector.
    /// </summary>
    /// <param name="effectorName"> Name of the effector : \"Head\", \"LArm\" or \"RArm\". Nao goes to posture init. He manages his balance and keep foot fix. \"Head\" is controlled in rotation. \"LArm\" and \"RArm\" are controlled in position. </param>
    /// <param name="isEnabled"> Active / Disactive Effector Control. </param>

    
    
    
    
    
    public void wbEnableEffectorControl( String effectorName,  Boolean isEnabled)
    {

	Variant veffectorName;
	veffectorName = new Variant(effectorName);
	Variant visEnabled;
	visEnabled = new Variant(isEnabled);

	Variant result = call("wbEnableEffectorControl" ,veffectorName, visEnabled);

		// no return value
    }

    



    /// <summary>
    /// Advanced Whole Body API: enable to control an effector as an optimization.
    /// </summary>
    /// <param name="effectorName"> Name of the effector : \"All\", \"Arms\", \"Legs\", \"Head\", \"LArm\", \"RArm\", \"LLeg\", \"RLeg\", \"Torso\", \"Com\". </param>
    /// <param name="isActive"> if true, the effector control is taken in acount in the optimization criteria. </param>

    
    
    
    
    
    public void wbEnableEffectorOptimization( String effectorName,  Boolean isActive)
    {

	Variant veffectorName;
	veffectorName = new Variant(effectorName);
	Variant visActive;
	visActive = new Variant(isActive);

	Variant result = call("wbEnableEffectorOptimization" ,veffectorName, visActive);

		// no return value
    }

    



    /// <summary>
    /// UserFriendly Whole Body API: set the foot state: fixed foot, constrained in a plane or free.
    /// </summary>
    /// <param name="stateName"> Name of the foot state. \"Fixed\" set the foot fixed. \"Plane\" constrained the Foot in the plane. \"Free\" set the foot free. </param>
    /// <param name="supportLeg"> Name of the foot. \"LLeg\", \"RLeg\" or \"Legs\". </param>

    
    
    
    
    
    public void wbFootState( String stateName,  String supportLeg)
    {

	Variant vstateName;
	vstateName = new Variant(stateName);
	Variant vsupportLeg;
	vsupportLeg = new Variant(supportLeg);

	Variant result = call("wbFootState" ,vstateName, vsupportLeg);

		// no return value
    }

    



    /// <summary>
    /// Advanced Whole Body API: \"Com\" go to a desired support polygon. This is a blocking call.
    /// </summary>
    /// <param name="supportLeg"> Name of the support leg: \"Legs\", \"LLeg\", \"RLeg\". </param>
    /// <param name="duration"> Time in seconds. </param>

    
    
    
    
    
    public void wbGoToBalance( String supportLeg,  float duration)
    {

	Variant vsupportLeg;
	vsupportLeg = new Variant(supportLeg);
	Variant vduration;
	vduration = new Variant(duration);

	Variant result = call("wbGoToBalance" ,vsupportLeg, vduration);

		// no return value
    }

    



    /// <summary>
    /// UserFriendly Whole Body API: set new target for controlled effector. This is a non-blocking call.
    /// </summary>
    /// <param name="effectorName"> Name of the effector : \"Head\", \"LArm\" or \"RArm\". Nao goes to posture init. He manages his balance and keep foot fix. \"Head\" is controlled in rotation. \"LArm\" and \"RArm\" are controlled in position. </param>
    /// <param name="targetCoordinate"> \"Head\" is controlled in rotation (WX, WY, WZ). \"LArm\" and \"RArm\" are controlled in position (X, Y, Z). TargetCoordinate must be absolute and expressed in SPACE_NAO. If the desired position/orientation is unfeasible, target is resize to the nearest feasible motion. </param>

    
    
    
    
    
    public void wbSetEffectorControl( String effectorName,  Variant targetCoordinate)
    {

	Variant veffectorName;
	veffectorName = new Variant(effectorName);
	Variant vtargetCoordinate;
	vtargetCoordinate = new Variant(targetCoordinate);

	Variant result = call("wbSetEffectorControl" ,veffectorName, vtargetCoordinate);

		// no return value
    }

    




}


