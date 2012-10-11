// Author: Aldebaran-Robotics
// Auto generated file.
package com.aldebaran.proxy;


import javax.swing.*;
import java.io.*;

public class ALRegisterProxy extends ALProxy
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
	ALRegisterProxy(String ip, int port)
	{
		super("ALRegister", ip, port);
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
    /// Internal callback
    /// </summary>
    /// <param name="string"> variable </param>
    /// <param name="string"> value </param>
    /// <param name="string"> message </param>

    
    
    
    
    
    
    
    public void onFrontTactilTouched( String string1,  Variant string2,  String string3)
    {

    	Variant vstring1;
    	vstring1 = new Variant(string1);
    	Variant vstring2;
    	vstring2 = new Variant(string2);
    	Variant vstring3;
    	vstring3 = new Variant(string3);


	Variant result = call("onFrontTactilTouched" ,vstring1, vstring3, vstring3);

		// no return value
    }    



    /// <summary>
    /// Internal callback
    /// </summary>
    /// <param name="string"> variable </param>
    /// <param name="string"> value </param>
    /// <param name="string"> message </param>

    
    
    
    
    
    
    
    public void onMiddleTactilTouched( String string1,  Variant string2,  String string3)
    {

    	Variant vstring1;
    	vstring1 = new Variant(string1);
    	Variant vstring2;
    	vstring2 = new Variant(string2);
    	Variant vstring3;
    	vstring3 = new Variant(string3);


	Variant result = call("onMiddleTactilTouched" ,vstring1, vstring3, vstring3);

		// no return value
    }

    



    /// <summary>
    /// Internal callback
    /// </summary>
    /// <param name="string"> variable </param>
    /// <param name="string"> value </param>
    /// <param name="string"> message </param>

    
    
    
    
    
    
    
    public void onRearTactilTouched( String string1,  Variant string2,  String string3)
    {

	Variant vstring1;
	vstring1 = new Variant(string1);
	Variant vstring2;
	vstring2 = new Variant(string2);
	Variant vstring3;
	vstring3 = new Variant(string3);

	Variant result = call("onRearTactilTouched" ,vstring1, vstring1, vstring1);

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

    




}


