// Author: Aldebaran-Robotics
// Auto generated file.



package com.aldebaran.proxy;
public class ALLoggerProxy extends ALProxy
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
	public ALLoggerProxy(String ip, int port)
	{
		super("ALLogger", ip, port);
	}

    /// <summary>
    /// Log a debug message.
    /// </summary>
    /// <param name="moduleName"> Name of the module. </param>
    /// <param name="message"> Log Message. </param>

    
    
    
    
    
    public void debug( String moduleName,  String message)
    {

	Variant vmoduleName;
	vmoduleName = new Variant(moduleName);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("debug" ,vmoduleName, vmessage);

		// no return value
    }

    



    /// <summary>
    /// Log an error.
    /// </summary>
    /// <param name="moduleName"> Name of the module. </param>
    /// <param name="message"> Log Message. </param>

    
    
    
    
    
    public void error( String moduleName,  String message)
    {

	Variant vmoduleName;
	vmoduleName = new Variant(moduleName);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("error" ,vmoduleName, vmessage);

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
    /// Log a fatal error.
    /// </summary>
    /// <param name="moduleName"> Name of the module. </param>
    /// <param name="message"> Log Message. </param>

    
    
    
    
    
    public void fatal( String moduleName,  String message)
    {

	Variant vmoduleName;
	vmoduleName = new Variant(moduleName);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("fatal" ,vmoduleName, vmessage);

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
    /// Log a info message.
    /// </summary>
    /// <param name="moduleName"> Name of the module. </param>
    /// <param name="message"> Log Message. </param>

    
    
    
    
    
    public void info( String moduleName,  String message)
    {

	Variant vmoduleName;
	vmoduleName = new Variant(moduleName);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("info" ,vmoduleName, vmessage);

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
    /// Allows the logger to store logs in a file. Warning: this is not recomended on Nao.
    /// </summary>
    /// <param name="fileName"> The fileName to use. Relative to the user naoqi folder. </param>

    
    
    
    public void logInFile( String fileName)
    {

	Variant vfileName;
	vfileName = new Variant(fileName);

	Variant result = call("logInFile" ,vfileName);

		// no return value
    }

    



    /// <summary>
    /// Publish logs to a Log Forwarder. Pass an empty string in order to use the default value:  \"tcp://localhost:50998\"
    /// </summary>
    /// <param name="inputAddress"> Desired input ZMQ address of the Log Forwarder. </param>

    
    
    
    public void logInForwarder( String inputAddress)
    {

	Variant vinputAddress;
	vinputAddress = new Variant(inputAddress);

	Variant result = call("logInForwarder" ,vinputAddress);

		// no return value
    }

    



    /// <summary>
    /// Allows the logger to output logs to the standard output.
    /// </summary>

    
    public void logInStd()
    {


	Variant result = call("logInStd" );

		// no return value
    }

    



    /// <summary>
    /// Allows the logger to output logs to the system log. (Linux only)
    /// </summary>

    
    public void logInSys()
    {


	Variant result = call("logInSys" );

		// no return value
    }

    



    /// <summary>
    /// DEPRECIATED: Log a low priority debug message. Use debug instead.
    /// </summary>
    /// <param name="moduleName"> Name of the module. </param>
    /// <param name="message"> Log Message. </param>

    
    
    
    
    
    public void lowDebug( String moduleName,  String message)
    {

	Variant vmoduleName;
	vmoduleName = new Variant(moduleName);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("lowDebug" ,vmoduleName, vmessage);

		// no return value
    }

    



    /// <summary>
    /// DEPRECIATED: Log a low priority information message. Use info instead.
    /// </summary>
    /// <param name="moduleName"> Name of the module. </param>
    /// <param name="message"> Log Message. </param>

    
    
    
    
    
    public void lowInfo( String moduleName,  String message)
    {

	Variant vmoduleName;
	vmoduleName = new Variant(moduleName);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("lowInfo" ,vmoduleName, vmessage);

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
    /// Unsubscribe specified id from connection list.
    /// </summary>
    /// <param name="id"> Id used to register the handler. </param>

    
    
    
    public void removeHandler( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("removeHandler" ,vid);

		// no return value
    }

    



    /// <summary>
    /// output a simple line separator
    /// </summary>

    
    public void separator()
    {


	Variant result = call("separator" );

		// no return value
    }

    



    /// <summary>
    /// Creates a filter. Only messages containing the string will be logged. Use an empty string to remove the filter.
    /// </summary>
    /// <param name="filter"> The string that defines the filter. </param>

    
    
    
    public void setFilter( String filter)
    {

	Variant vfilter;
	vfilter = new Variant(filter);

	Variant result = call("setFilter" ,vfilter);

		// no return value
    }

    



    /// <summary>
    /// set verbosity: debug, info, warning, error, fatal, silent. Default is info
    /// </summary>
    /// <param name="verbosity"> verbosity value </param>

    
    
    
    public void setVerbosity( String verbosity)
    {

	Variant vverbosity;
	vverbosity = new Variant(verbosity);

	Variant result = call("setVerbosity" ,vverbosity);

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
    /// Log a warning.
    /// </summary>
    /// <param name="moduleName"> Name of the module. </param>
    /// <param name="message"> Log Message. </param>

    
    
    
    
    
    public void warn( String moduleName,  String message)
    {

	Variant vmoduleName;
	vmoduleName = new Variant(moduleName);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("warn" ,vmoduleName, vmessage);

		// no return value
    }

    




}


