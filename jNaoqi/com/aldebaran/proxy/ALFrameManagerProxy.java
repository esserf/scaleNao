// Author: Aldebaran-Robotics
// Auto generated file.



package com.aldebaran.proxy;
public class ALFrameManagerProxy extends ALProxy
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
	public ALFrameManagerProxy(String ip, int port)
	{
		super("ALFrameManager", ip, port);
	}

    /// <summary>
    /// Stop playing any behavior in FrameManager, and delete all of them.
    /// </summary>

    
    public void cleanBehaviors()
    {


	Variant result = call("cleanBehaviors" );

		// no return value
    }

    



    /// <summary>
    /// It will play a behavior and block until the behavior is finished. Note that it can block forever if the behavior output is never called.
    /// </summary>
    /// <param name="id"> The id of the box. </param>

    
    
    
    public void completeBehavior( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("completeBehavior" ,vid);

		// no return value
    }

    



    /// <summary>
    /// Creates and play completely a timeline
    /// </summary>
    /// <param name="xmlFile"> The choregraphe project (in plain text for the moment). </param>
    /// <returns> return a unique identifier for the created box that contains the timeline. You must call deleteBehavior on it at some point. </returns>

    
    
    
    public String createAndPlayTimeline( String xmlFile)
    {

	Variant vxmlFile;
	vxmlFile = new Variant(xmlFile);

	Variant result = call("createAndPlayTimeline" ,vxmlFile);

	    	return  result.toString();
    }

    



    /// <summary>
    /// Called by ALMemory when subcription data is updated.
    /// </summary>
    /// <param name="dataName"> Name of the subscribed data. </param>
    /// <param name="data"> Value of the the subscribed data </param>
    /// <param name="message"> The message give when subscribing. </param>

    
    
    
    
    
    
    
    public void dataChanged( String dataName,  Variant data,  String message)
    {

	Variant vdataName;
	vdataName = new Variant(dataName);
	Variant vdata;
	vdata = new Variant(data);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("dataChanged" ,vdataName, vdata, vmessage);

		// no return value
    }

    



    /// <summary>
    /// Deletes a behavior (meaning a box). Stop the whole behavior contained in this box first.
    /// </summary>
    /// <param name="id"> The id of the box to delete. </param>

    
    
    
    public void deleteBehavior( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("deleteBehavior" ,vid);

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
    /// Exit the reading of a timeline contained in a given box
    /// </summary>
    /// <param name="id"> The id of the box. </param>

    
    
    
    public void exitBehavior( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("exitBehavior" ,vid);

		// no return value
    }

    



    /// <summary>
    /// Returns a playing behavior absolute path.
    /// </summary>
    /// <param name="id"> The id of the behavior. </param>
    /// <returns> Returns the absolute path of given behavior. </returns>

    
    
    
    public String getBehaviorPath( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getBehaviorPath" ,vid);

	    	return  result.toString();
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
    /// Returns in seconds, the duration of a given movement stored in a box. Returns 0 if the behavior has no motion layers.
    /// </summary>
    /// <param name="id"> The id of the box. </param>
    /// <returns> Returns the time in seconds. </returns>

    
    
    
    public float getMotionLength( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getMotionLength" ,vid);

	    	return  result.toFloat();
    }

    



    /// <summary>
    /// Gets the FPS of a given timeline
    /// </summary>
    /// <param name="id"> The id of the timeline. </param>
    /// <returns> Returns the timeline's FPS. </returns>

    
    
    
    public int getTimelineFps( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getTimelineFps" ,vid);

	    	return  result.toInt();
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
    /// Goes to a certain frame and continue playing
    /// </summary>
    /// <param name="id"> The id of the box containing the box. </param>
    /// <param name="frame"> The behavior frame name we want the timeline to go to. If will jump to the starting index of the name given. </param>

    
    
    
    
    
    public void gotoAndPlay( String id,  String frame)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vframe;
	vframe = new Variant(frame);

	Variant result = call("gotoAndPlay" ,vid, vframe);

		// no return value
    }

    



    /// <summary>
    /// Goes to a certain frame and continue playing
    /// </summary>
    /// <param name="id"> The id of the box containing the box. </param>
    /// <param name="frame"> The frame we want the timeline to go to. </param>

    
    
    
    
    
    public void gotoAndPlay( String id,  int frame)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vframe;
	vframe = new Variant(frame);

	Variant result = call("gotoAndPlay" ,vid, vframe);

		// no return value
    }

    



    /// <summary>
    /// Goes to a certain frame and pause
    /// </summary>
    /// <param name="id"> The id of the box containing the box. </param>
    /// <param name="frame"> The behavior frame name we want the timeline to go to. If will jump to the starting index of the name given. </param>

    
    
    
    
    
    public void gotoAndStop( String id,  String frame)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vframe;
	vframe = new Variant(frame);

	Variant result = call("gotoAndStop" ,vid, vframe);

		// no return value
    }

    



    /// <summary>
    /// Goes to a certain frame and pause
    /// </summary>
    /// <param name="id"> The id of the box containing the box. </param>
    /// <param name="frame"> The frame we want the timeline to go to. </param>

    
    
    
    
    
    public void gotoAndStop( String id,  int frame)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vframe;
	vframe = new Variant(frame);

	Variant result = call("gotoAndStop" ,vid, vframe);

		// no return value
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
    /// Creates a new behavior, from a box found in an xml file. Note that you have to give the xml file contents, so this method is not very user friendly. You have to open the file, and send the string that matches the file contents if you are working from a file. You probably want to use newBehaviorFromFile instead.
    /// </summary>
    /// <param name="path"> The path to reach the box to instantiate in the project (\"\" if root). </param>
    /// <param name="xmlFile"> The choregraphe project (in plain text for the moment). </param>
    /// <returns> return a unique identifier for the created box. </returns>

    
    
    
    
    
    public String newBehavior( String path,  String xmlFile)
    {

	Variant vpath;
	vpath = new Variant(path);
	Variant vxmlFile;
	vxmlFile = new Variant(xmlFile);

	Variant result = call("newBehavior" ,vpath, vxmlFile);

	    	return  result.toString();
    }

    



    /// <summary>
    /// Creates a new behavior, from the current Choregraphe behavior (uploaded to /tmp/currentChoregrapheBehavior/behavior.xar).
    /// </summary>
    /// <returns> return a unique identifier for the created behavior </returns>

    
    public String newBehaviorFromChoregraphe()
    {


	Variant result = call("newBehaviorFromChoregraphe" );

	    	return  result.toString();
    }

    



    /// <summary>
    /// Creates a new behavior, from a box found in an xml file stored in the robot.
    /// </summary>
    /// <param name="xmlFilePath"> Path to Xml file, ex : \"/home/youhou/mybehavior.xar\". </param>
    /// <param name="path"> The path to reach the box to instantiate in the project (\"\" if root). </param>
    /// <returns> return a unique identifier for the created box, that can be used by playBehavior </returns>

    
    
    
    
    
    public String newBehaviorFromFile( String xmlFilePath,  String path)
    {

	Variant vxmlFilePath;
	vxmlFilePath = new Variant(xmlFilePath);
	Variant vpath;
	vpath = new Variant(path);

	Variant result = call("newBehaviorFromFile" ,vxmlFilePath, vpath);

	    	return  result.toString();
    }

    



    /// <summary>
    /// Transmit Python error to Choregraphe or logger. Should not be called manually. DEPRECATED.
    /// </summary>
    /// <param name="boxname"> Name of the box raising the error </param>
    /// <param name="methodname"> Name of the method </param>
    /// <param name="error"> Error string </param>

    
    
    
    
    
    
    
    public void onPythonError( String boxname,  String methodname,  String error)
    {

	Variant vboxname;
	vboxname = new Variant(boxname);
	Variant vmethodname;
	vmethodname = new Variant(methodname);
	Variant verror;
	verror = new Variant(error);

	Variant result = call("onPythonError" ,vboxname, vmethodname, verror);

		// no return value
    }

    



    /// <summary>
    /// Print Python message in Choregraphe or logger. Should not be called manually. DEPRECATED.
    /// </summary>
    /// <param name="message"> Message to print </param>

    
    
    
    public void onPythonPrint( String message)
    {

	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("onPythonPrint" ,vmessage);

		// no return value
    }

    



    /// <summary>
    /// Transmit Ruby error to Choregraphe or logger. Should not be called manually. DEPRECATED.
    /// </summary>
    /// <param name="boxname"> Name of the box raising the error </param>
    /// <param name="methodname"> Name of the method </param>
    /// <param name="error"> Error string </param>

    
    
    
    
    
    
    
    public void onRubyError( String boxname,  String methodname,  String error)
    {

	Variant vboxname;
	vboxname = new Variant(boxname);
	Variant vmethodname;
	vmethodname = new Variant(methodname);
	Variant verror;
	verror = new Variant(error);

	Variant result = call("onRubyError" ,vboxname, vmethodname, verror);

		// no return value
    }

    



    /// <summary>
    /// Print Ruby message in Choregraphe or logger. Should not be called manually. DEPRECATED.
    /// </summary>
    /// <param name="message"> Message to print </param>

    
    
    
    public void onRubyPrint( String message)
    {

	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("onRubyPrint" ,vmessage);

		// no return value
    }

    



    /// <summary>
    /// Transmit Urbi error to Choregraphe or logger. Should not be called manually. DEPRECATED.
    /// </summary>
    /// <param name="boxname"> Name of the box raising the error </param>
    /// <param name="methodname"> Name of the method </param>
    /// <param name="location"> Location of the error </param>
    /// <param name="error"> Error string </param>

    
    
    
    
    
    
    
    
    
    public void onUrbiError( String boxname,  String methodname,  String location,  String error)
    {

	Variant vboxname;
	vboxname = new Variant(boxname);
	Variant vmethodname;
	vmethodname = new Variant(methodname);
	Variant vlocation;
	vlocation = new Variant(location);
	Variant verror;
	verror = new Variant(error);

	Variant result = call("onUrbiError" ,vboxname, vmethodname, vlocation, verror);

		// no return value
    }

    



    /// <summary>
    /// Print Urbi message in Choregraphe or logger. Should not be called manually. DEPRECATED.
    /// </summary>
    /// <param name="message"> Message to print </param>

    
    
    
    public void onUrbiPrint( String message)
    {

	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("onUrbiPrint" ,vmessage);

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
    /// Starts a behavior
    /// </summary>
    /// <param name="id"> The id of the box. </param>

    
    
    
    public void playBehavior( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("playBehavior" ,vid);

		// no return value
    }

    



    /// <summary>
    /// Play default behavior; DEPRECATED: use ALBehaviorManager.playDefaultProject
    /// </summary>

    
    public void playDefaultProject()
    {


	Variant result = call("playDefaultProject" );

		// no return value
    }

    



    /// <summary>
    /// Starts playing a timeline contained in a given box. If the box is a flow diagram, it will look for the first onStart input of type Bang, and stimulate it !
    /// </summary>
    /// <param name="id"> The id of the box. </param>

    
    
    
    public void playTimeline( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("playTimeline" ,vid);

		// no return value
    }

    



    /// <summary>
    /// Sets the FPS of a given timeline
    /// </summary>
    /// <param name="id"> The id of the timeline. </param>
    /// <param name="fps"> The FPS to set. </param>

    
    
    
    
    
    public void setTimelineFps( String id,  int fps)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vfps;
	vfps = new Variant(fps);

	Variant result = call("setTimelineFps" ,vid, vfps);

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
    /// Stops playing a timeline contained in a given box, at the current frame
    /// </summary>
    /// <param name="id"> The id of the box. </param>

    
    
    
    public void stopTimeline( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("stopTimeline" ,vid);

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

    




}


