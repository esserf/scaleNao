// Author: Aldebaran-Robotics
// Auto generated file.



package com.aldebaran.proxy;
public class ALTelepatheProxy extends ALProxy
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
	public ALTelepatheProxy(String ip, int port)
	{
		super("ALTelepathe", ip, port);
	}

    /// <summary>
    /// Clears the login and password for accessing Aldebaran's network.Login can be tracked in the ALMemory key ALTelepathe/Login
    /// </summary>

    
    public void clearLoginInformation()
    {


	Variant result = call("clearLoginInformation" );

		// no return value
    }

    



    /// <summary>
    /// Connects the robot to the messaging network.
    ///
    /// Returns once connected. Throws runtime error otherwise.
    /// </summary>

    
    public void connectNetwork()
    {


	Variant result = call("connectNetwork" );

		// no return value
    }

    



    /// <summary>
    /// Disconnects the robot from the messaging network.
    ///
    /// Returns once disconnected. Does not throw.
    /// </summary>

    
    public void disconnectNetwork()
    {


	Variant result = call("disconnectNetwork" );

		// no return value
    }

    



    /// <summary>
    /// Enable / disable RPC handling for received messages.
    /// </summary>
    /// <param name="enabled"> Whether RPC is enabled </param>

    
    
    
    public void enableRPC( Boolean enabled)
    {

	Variant venabled;
	venabled = new Variant(enabled);

	Variant result = call("enableRPC" ,venabled);

		// no return value
    }

    



    /// <summary>
    /// Relays ALMemory callbacks to Internet remote peers.
    /// </summary>
    /// <param name="key"> The ALMemory key that was updated. </param>
    /// <param name="data"> The new value stored at the given key. </param>
    /// <param name="message"> Message will define the remote method to call (remoteModule.method) </param>

    
    
    
    
    
    
    
    public void eventCallback( String key,  Variant data,  String message)
    {

	Variant vkey;
	vkey = new Variant(key);
	Variant vdata;
	vdata = new Variant(data);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("eventCallback" ,vkey, vdata, vmessage);

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
    /// Gets the name of the parent broker.
    /// </summary>
    /// <returns> The name of the parent broker. </returns>

    
    public String getBrokerName()
    {


	Variant result = call("getBrokerName" );

	    	return  result.toString();
    }

    



    /// <summary>
    /// Gets the current period.
    /// </summary>
    /// <returns> Refresh period (in milliseconds). </returns>

    
    public int getCurrentPeriod()
    {


	Variant result = call("getCurrentPeriod" );

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Gets the current precision.
    /// </summary>
    /// <returns> Precision of the extractor. </returns>

    
    public float getCurrentPrecision()
    {


	Variant result = call("getCurrentPrecision" );

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
    /// Gets the period for a specific subscription.
    /// </summary>
    /// <param name="name"> Name of the module which has subscribed. </param>
    /// <returns> Refresh period (in milliseconds). </returns>

    
    
    
    public int getMyPeriod( String name)
    {

	Variant vname;
	vname = new Variant(name);

	Variant result = call("getMyPeriod" ,vname);

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Gets the precision for a specific subscription.
    /// </summary>
    /// <param name="name"> name of the module which has subscribed </param>
    /// <returns> precision of the extractor </returns>

    
    
    
    public float getMyPrecision( String name)
    {

	Variant vname;
	vname = new Variant(name);

	Variant result = call("getMyPrecision" ,vname);

	    	return  result.toFloat();
    }

    



    /// <summary>
    /// Get the list of values updated in ALMemory.
    /// </summary>
    /// <returns> Array of values updated by this extractor in ALMemory </returns>

    
    public String[] getOutputNames()
    {


	Variant result = call("getOutputNames" );

	    	return (String[]) result.toStringArray();
    }

    



    /// <summary>
    /// Gets the parameters given by the module.
    /// </summary>
    /// <returns> Array of names and parameters of all subscribers. </returns>

    
    public Variant getSubscribersInfo()
    {


	Variant result = call("getSubscribersInfo" );

	    	return  result;
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
    /// Says whether a media call is currently established.
    /// </summary>
    /// <returns> Whether ALTelepathe is calling or not. </returns>

    
    public Boolean isCalling()
    {


	Variant result = call("isCalling" );

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Gets the current connection status.
    ///
    /// Value is the same as in the ALMemory key ALTelepathe/Connected
    /// </summary>
    /// <returns> Whether ALTelepathe is online or not. </returns>

    
    public Boolean isConnected()
    {


	Variant result = call("isConnected" );

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Says whether RPC is enabled or not.
    /// </summary>
    /// <returns> Whether RPC is enabled </returns>

    
    public Boolean isRPCEnabled()
    {


	Variant result = call("isRPCEnabled" );

	    	return  result.toBoolean();
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
    /// Just a ping. Always returns true
    /// </summary>
    /// <returns> returns true </returns>

    
    public Boolean ping()
    {


	Variant result = call("ping" );

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// enable/disable the printing of some debug information
    /// </summary>
    /// <param name="arg1"> arg </param>
    /// <param name="arg2"> arg </param>
    /// <param name="arg3"> arg </param>
    /// <param name="arg4"> arg </param>

    
    
    
    
    
    
    
    
    
    public void processRemote( int arg1,  int arg2,  Variant arg3,  Variant arg4)
    {

	Variant varg1;
	varg1 = new Variant(arg1);
	Variant varg2;
	varg2 = new Variant(arg2);
	Variant varg3;
	varg3 = new Variant(arg3);
	Variant varg4;
	varg4 = new Variant(arg4);

	Variant result = call("processRemote" ,varg1, varg2, varg3, varg4);

		// no return value
    }

    



    /// <summary>
    /// enable/disable the printing of some debug information
    /// </summary>
    /// <param name="arg1"> arg </param>
    /// <param name="arg2"> arg </param>
    /// <param name="arg3"> arg </param>

    
    
    
    
    
    
    
    public void processSoundRemote( int arg1,  int arg2,  Variant arg3)
    {

	Variant varg1;
	varg1 = new Variant(arg1);
	Variant varg2;
	varg2 = new Variant(arg2);
	Variant varg3;
	varg3 = new Variant(arg3);

	Variant result = call("processSoundRemote" ,varg1, varg2, varg3);

		// no return value
    }

    



    /// <summary>
    /// Sends a text message to the chosen destination.
    /// </summary>
    /// <param name="destination"> The id of the destination contact. </param>
    /// <param name="message"> The message to send to the contact. </param>

    
    
    
    
    
    public void sendMessage( String destination,  String message)
    {

	Variant vdestination;
	vdestination = new Variant(destination);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("sendMessage" ,vdestination, vmessage);

		// no return value
    }

    



    /// <summary>
    /// Performs an Internet Remote Procedure Call.
    ///
    /// Returns once call has been received.Throws runtime error otherwise.
    /// </summary>
    /// <param name="destination"> Target contact id </param>
    /// <param name="module"> The target module </param>
    /// <param name="method"> The method to call </param>
    /// <param name="args"> The method arguments </param>
    /// <returns> RPC return value </returns>

    
    
    
    
    
    
    
    
    
    public Variant sendRPC( String destination,  String module,  String method,  Variant args)
    {

	Variant vdestination;
	vdestination = new Variant(destination);
	Variant vmodule;
	vmodule = new Variant(module);
	Variant vmethod;
	vmethod = new Variant(method);
	Variant vargs;
	vargs = new Variant(args);

	Variant result = call("sendRPC" ,vdestination, vmodule, vmethod, vargs);

	    	return  result;
    }

    



    /// <summary>
    /// enable/disable the printing of some debug information
    /// </summary>
    /// <param name="bSetOrUnset"> enable the functionnality when true. </param>

    
    
    
    public void setDebugMode( Boolean bSetOrUnset)
    {

	Variant vbSetOrUnset;
	vbSetOrUnset = new Variant(bSetOrUnset);

	Variant result = call("setDebugMode" ,vbSetOrUnset);

		// no return value
    }

    



    /// <summary>
    /// Sets the login and password for accessing Aldebaran's network.Login can be tracked in the ALMemory key ALTelepathe/Login
    /// </summary>
    /// <param name="login"> A valid Aldebaran Robotics user name. </param>
    /// <param name="password"> The matching password with the user name. </param>
    /// <param name="autoconnect"> Whether to connect automatically at startup. </param>

    
    
    
    
    
    
    
    public void setLoginInformation( String login,  String password,  Boolean autoconnect)
    {

	Variant vlogin;
	vlogin = new Variant(login);
	Variant vpassword;
	vpassword = new Variant(password);
	Variant vautoconnect;
	vautoconnect = new Variant(autoconnect);

	Variant result = call("setLoginInformation" ,vlogin, vpassword, vautoconnect);

		// no return value
    }

    



    /// <summary>
    /// Starts a media call.Returns once the call is accepted remotely.Throws runtime error if the call can't be established.Timeouts after 30 seconds if call not accepted remotely.
    /// </summary>
    /// <param name="contact"> The contact id to call. </param>
    /// <param name="audio"> Whether audio is enabled for the call. </param>
    /// <param name="video"> Whether video is enabled for the call. </param>

    
    
    
    
    
    
    
    public void startCall( String contact,  Boolean audio,  Boolean video)
    {

	Variant vcontact;
	vcontact = new Variant(contact);
	Variant vaudio;
	vaudio = new Variant(audio);
	Variant vvideo;
	vvideo = new Variant(video);

	Variant result = call("startCall" ,vcontact, vaudio, vvideo);

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
    /// Stops the current media call.
    /// </summary>

    
    public void stopCall()
    {


	Variant result = call("stopCall" );

		// no return value
    }

    



    /// <summary>
    /// Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData(\"keyName\"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    /// </summary>
    /// <param name="name"> Name of the module which subscribes. </param>
    /// <param name="period"> Refresh period (in milliseconds) if relevant. </param>
    /// <param name="precision"> Precision of the extractor if relevant. </param>

    
    
    
    
    
    
    
    public void subscribe( String name,  int period,  float precision)
    {

	Variant vname;
	vname = new Variant(name);
	Variant vperiod;
	vperiod = new Variant(period);
	Variant vprecision;
	vprecision = new Variant(precision);

	Variant result = call("subscribe" ,vname, vperiod, vprecision);

		// no return value
    }

    



    /// <summary>
    /// Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData(\"keyName\"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    /// </summary>
    /// <param name="name"> Name of the module which subscribes. </param>

    
    
    
    public void subscribe( String name)
    {

	Variant vname;
	vname = new Variant(name);

	Variant result = call("subscribe" ,vname);

		// no return value
    }

    



    /// <summary>
    /// Unsubscribes from the extractor.
    /// </summary>
    /// <param name="name"> Name of the module which had subscribed. </param>

    
    
    
    public void unsubscribe( String name)
    {

	Variant vname;
	vname = new Variant(name);

	Variant result = call("unsubscribe" ,vname);

		// no return value
    }

    



    /// <summary>
    /// Updates the period if relevant.
    /// </summary>
    /// <param name="name"> Name of the module which has subscribed. </param>
    /// <param name="period"> Refresh period (in milliseconds). </param>

    
    
    
    
    
    public void updatePeriod( String name,  int period)
    {

	Variant vname;
	vname = new Variant(name);
	Variant vperiod;
	vperiod = new Variant(period);

	Variant result = call("updatePeriod" ,vname, vperiod);

		// no return value
    }

    



    /// <summary>
    /// Updates the precision if relevant.
    /// </summary>
    /// <param name="name"> Name of the module which has subscribed. </param>
    /// <param name="precision"> Precision of the extractor. </param>

    
    
    
    
    
    public void updatePrecision( String name,  float precision)
    {

	Variant vname;
	vname = new Variant(name);
	Variant vprecision;
	vprecision = new Variant(precision);

	Variant result = call("updatePrecision" ,vname, vprecision);

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


