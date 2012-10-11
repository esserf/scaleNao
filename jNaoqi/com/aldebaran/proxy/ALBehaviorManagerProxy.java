// Author: Aldebaran-Robotics
// Auto generated file.



package com.aldebaran.proxy;
public class ALBehaviorManagerProxy extends ALProxy
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
	public ALBehaviorManagerProxy(String ip, int port)
	{
		super("ALBehaviorManager", ip, port);
	}

    /// <summary>
    /// Set the given behavior as default
    /// </summary>
    /// <param name="prefixedBehavior"> Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) </param>

    
    
    
    public void addDefaultBehavior( String prefixedBehavior)
    {

	Variant vprefixedBehavior;
	vprefixedBehavior = new Variant(prefixedBehavior);

	Variant result = call("addDefaultBehavior" ,vprefixedBehavior);

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
    /// Get behaviors
    /// </summary>
    /// <returns> Returns the list of behaviors prefixed by their type (User/ or System/. </returns>

    
    public String[] getBehaviorNames()
    {


	Variant result = call("getBehaviorNames" );

	    	return (String[]) result.toStringArray();
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
    /// Get default behaviors
    /// </summary>
    /// <returns> Return default behaviors </returns>

    
    public String[] getDefaultBehaviors()
    {


	Variant result = call("getDefaultBehaviors" );

	    	return (String[]) result.toStringArray();
    }

    



    /// <summary>
    /// Get installed behaviors directories names, DEPRECATED: use getUserBehaviorsNames
    /// </summary>
    /// <returns> Returns the behaviors list </returns>

    
    public String[] getInstalledBehaviors()
    {


	Variant result = call("getInstalledBehaviors" );

	    	return (String[]) result.toStringArray();
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
    /// Get running behaviors
    /// </summary>
    /// <returns> Return running behaviors </returns>

    
    public String[] getRunningBehaviors()
    {


	Variant result = call("getRunningBehaviors" );

	    	return (String[]) result.toStringArray();
    }

    



    /// <summary>
    /// Get system behaviors
    /// </summary>
    /// <returns> Returns the list of system behaviors prefixed by System/. </returns>

    
    public String[] getSystemBehaviorNames()
    {


	Variant result = call("getSystemBehaviorNames" );

	    	return (String[]) result.toStringArray();
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
    /// Get user's behaviors
    /// </summary>
    /// <returns> Returns the list of user's behaviors prefixed by User/. </returns>

    
    public String[] getUserBehaviorNames()
    {


	Variant result = call("getUserBehaviorNames" );

	    	return (String[]) result.toStringArray();
    }

    



    /// <summary>
    /// Tell if supplied name corresponds to a behavior that has been installed, DEPRECATED: useisBehaviorPresent
    /// </summary>
    /// <param name="name"> The behavior directory name </param>
    /// <returns> Returns true if it is a valid behavior </returns>

    
    
    
    public Boolean isBehaviorInstalled( String name)
    {

	Variant vname;
	vname = new Variant(name);

	Variant result = call("isBehaviorInstalled" ,vname);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Tell if the supplied namecorresponds to an existing behavior.
    /// </summary>
    /// <param name="prefixedBehavior"> Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) </param>
    /// <returns> Returns true if it is an existing behavior </returns>

    
    
    
    public Boolean isBehaviorPresent( String prefixedBehavior)
    {

	Variant vprefixedBehavior;
	vprefixedBehavior = new Variant(prefixedBehavior);

	Variant result = call("isBehaviorPresent" ,vprefixedBehavior);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Tell if supplied name corresponds to a running behavior
    /// </summary>
    /// <param name="prefixedBehavior"> Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) </param>
    /// <returns> Returns true if it is a running behavior </returns>

    
    
    
    public Boolean isBehaviorRunning( String prefixedBehavior)
    {

	Variant vprefixedBehavior;
	vprefixedBehavior = new Variant(prefixedBehavior);

	Variant result = call("isBehaviorRunning" ,vprefixedBehavior);

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
    /// Play default behaviors
    /// </summary>

    
    public void playDefaultProject()
    {


	Variant result = call("playDefaultProject" );

		// no return value
    }

    



    /// <summary>
    /// Load a behavior
    /// </summary>
    /// <param name="prefixedBehavior"> Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) </param>
    /// <returns> Returns true if it was successfully loaded. </returns>

    
    
    
    public Boolean preloadBehavior( String prefixedBehavior)
    {

	Variant vprefixedBehavior;
	vprefixedBehavior = new Variant(prefixedBehavior);

	Variant result = call("preloadBehavior" ,vprefixedBehavior);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Remove a behavior from the filesystem
    /// </summary>
    /// <param name="prefixedBehavior"> Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) </param>
    /// <returns> Return true if succeeded, else false </returns>

    
    
    
    public Boolean removeBehavior( String prefixedBehavior)
    {

	Variant vprefixedBehavior;
	vprefixedBehavior = new Variant(prefixedBehavior);

	Variant result = call("removeBehavior" ,vprefixedBehavior);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Remove the given behavior from the default behaviors
    /// </summary>
    /// <param name="prefixedBehavior"> Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) </param>

    
    
    
    public void removeDefaultBehavior( String prefixedBehavior)
    {

	Variant vprefixedBehavior;
	vprefixedBehavior = new Variant(prefixedBehavior);

	Variant result = call("removeDefaultBehavior" ,vprefixedBehavior);

		// no return value
    }

    



    /// <summary>
    /// Run a behavior
    /// </summary>
    /// <param name="prefixedBehavior"> Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) </param>

    
    
    
    public void runBehavior( String prefixedBehavior)
    {

	Variant vprefixedBehavior;
	vprefixedBehavior = new Variant(prefixedBehavior);

	Variant result = call("runBehavior" ,vprefixedBehavior);

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
    /// Stop all behaviors
    /// </summary>

    
    public void stopAllBehaviors()
    {


	Variant result = call("stopAllBehaviors" );

		// no return value
    }

    



    /// <summary>
    /// Stop a behavior
    /// </summary>
    /// <param name="prefixedBehavior"> Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) </param>

    
    
    
    public void stopBehavior( String prefixedBehavior)
    {

	Variant vprefixedBehavior;
	vprefixedBehavior = new Variant(prefixedBehavior);

	Variant result = call("stopBehavior" ,vprefixedBehavior);

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


