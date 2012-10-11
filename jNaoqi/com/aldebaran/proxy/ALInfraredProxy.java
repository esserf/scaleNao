// Author: Aldebaran-Robotics
// Auto generated file.



package com.aldebaran.proxy;
public class ALInfraredProxy extends ALProxy
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
	public ALInfraredProxy(String ip, int port)
	{
		super("ALInfrared", ip, port);
	}

    /// <summary>
    /// Called during polling in order to update further information.
    /// </summary>
    /// <param name="Keyname"> Name of the next remote control key to reccord. </param>
    /// <returns> Returns the last message given by irrecord (LIRC program to record IR remote controls). </returns>

    
    
    
    public String confRemoteRecordAddKey( String Keyname)
    {

	Variant vKeyname;
	vKeyname = new Variant(Keyname);

	Variant result = call("confRemoteRecordAddKey" ,vKeyname);

	    	return  result.toString();
    }

    



    /// <summary>
    /// Kill irrecord (LIRC program to record IR remote controls).
    /// </summary>
    /// <returns> Returns \"#BEGIN#\" to tell the web page to start from the beginning. </returns>

    
    public String confRemoteRecordCancel()
    {


	Variant result = call("confRemoteRecordCancel" );

	    	return  result.toString();
    }

    



    /// <summary>
    /// Called when the user validate a new key name.
    /// </summary>
    /// <returns> Returns the last message given by irrecord (LIRC program to record IR remote controls). </returns>

    
    public String confRemoteRecordGetStatus()
    {


	Variant result = call("confRemoteRecordGetStatus" );

	    	return  result.toString();
    }

    



    /// <summary>
    /// Called when the user click on NEXT.
    /// </summary>
    /// <returns> Returns the last message given by irrecord (lirc program to record IR remote control). </returns>

    
    public String confRemoteRecordNext()
    {


	Variant result = call("confRemoteRecordNext" );

	    	return  result.toString();
    }

    



    /// <summary>
    /// Rewrite the LIRC daemon configuration file (lircd.conf) with everyremotes configuration concatenated, and reload it in LIRC daemons
    /// </summary>

    
    public void confRemoteRecordSave()
    {


	Variant result = call("confRemoteRecordSave" );

		// no return value
    }

    



    /// <summary>
    /// Start remote record process.
    /// </summary>
    /// <param name="Rm_name"> Name of the remote control to reccord. </param>

    
    
    
    public void confRemoteRecordStart( String Rm_name)
    {

	Variant vRm_name;
	vRm_name = new Variant(Rm_name);

	Variant result = call("confRemoteRecordStart" ,vRm_name);

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
    /// Init IR reception (connect as a client to the LIRC daemon).
    /// </summary>
    /// <param name="RepeatThreshold"> Give the keep-pressing threshold after which the repetition of a key is taken into consideration. </param>

    
    
    
    public void initReception( int RepeatThreshold)
    {

	Variant vRepeatThreshold;
	vRepeatThreshold = new Variant(RepeatThreshold);

	Variant result = call("initReception" ,vRepeatThreshold);

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
    /// Just a ping. Always returns true
    /// </summary>
    /// <returns> returns true </returns>

    
    public Boolean ping()
    {


	Variant result = call("ping" );

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Send 4 octets by IR.
    /// </summary>
    /// <param name="Data_IR"> 4 octets to send through IR. </param>

    
    
    
    public void send32( String Data_IR)
    {

	Variant vData_IR;
	vData_IR = new Variant(Data_IR);

	Variant result = call("send32" ,vData_IR);

		// no return value
    }

    



    /// <summary>
    /// Send 4 octets by IR.
    /// </summary>
    /// <param name="Octet1"> Octet 1 to send through IR. </param>
    /// <param name="Octet2"> Octet 2 to send through IR. </param>
    /// <param name="Octet3"> Octet 3 to send through IR. </param>
    /// <param name="Octet4"> Octet 4 to send through IR. </param>

    
    
    
    
    
    
    
    
    
    public void send32( int Octet1,  int Octet2,  int Octet3,  int Octet4)
    {

	Variant vOctet1;
	vOctet1 = new Variant(Octet1);
	Variant vOctet2;
	vOctet2 = new Variant(Octet2);
	Variant vOctet3;
	vOctet3 = new Variant(Octet3);
	Variant vOctet4;
	vOctet4 = new Variant(Octet4);

	Variant result = call("send32" ,vOctet1, vOctet2, vOctet3, vOctet4);

		// no return value
    }

    



    /// <summary>
    /// Send 1 octet by IR.
    /// </summary>
    /// <param name="Octet"> octet to send through IR. </param>

    
    
    
    public void send8( int Octet)
    {

	Variant vOctet;
	vOctet = new Variant(Octet);

	Variant result = call("send8" ,vOctet);

		// no return value
    }

    



    /// <summary>
    /// Send an IP by IR.
    /// </summary>
    /// <param name="IP"> IP adress to send through IR. </param>

    
    
    
    public void sendIpAddress( String IP)
    {

	Variant vIP;
	vIP = new Variant(IP);

	Variant result = call("sendIpAddress" ,vIP);

		// no return value
    }

    



    /// <summary>
    /// Simulate a remote control (Nao as a remote control).
    /// </summary>
    /// <param name="Remote"> IR remote control name. </param>
    /// <param name="Key"> IR remote control key name. </param>

    
    
    
    
    
    public void sendRemoteKey( String Remote,  String Key)
    {

	Variant vRemote;
	vRemote = new Variant(Remote);
	Variant vKey;
	vKey = new Variant(Key);

	Variant result = call("sendRemoteKey" ,vRemote, vKey);

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

    




}


