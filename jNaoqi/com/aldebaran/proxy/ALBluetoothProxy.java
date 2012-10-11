// Author: Aldebaran-Robotics
// Auto generated file.



package com.aldebaran.proxy;
public class ALBluetoothProxy extends ALProxy
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
	public ALBluetoothProxy(String ip, int port)
	{
		super("ALBluetooth", ip, port);
	}

    /// <summary>
    /// Connect to all associated devices that we found.
    /// </summary>

    
    public void connect()
    {


	Variant result = call("connect" );

		// no return value
    }

    



    /// <summary>
    /// Connect to a specific device.
    /// </summary>
    /// <param name="devicename"> the device name, this will be used to refer to the device later </param>

    
    
    
    public void connect( String devicename)
    {

	Variant vdevicename;
	vdevicename = new Variant(devicename);

	Variant result = call("connect" ,vdevicename);

		// no return value
    }

    



    /// <summary>
    /// Disconnect all bluetooth devices
    /// </summary>

    
    public void disconnect()
    {


	Variant result = call("disconnect" );

		// no return value
    }

    



    /// <summary>
    /// Disconnect a bluetooth device
    /// </summary>
    /// <param name="devicename"> the device name to disconnect </param>

    
    
    
    public void disconnect( String devicename)
    {

	Variant vdevicename;
	vdevicename = new Variant(devicename);

	Variant result = call("disconnect" ,vdevicename);

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
    /// list all bluetooth devices that are associated with nao.
    /// </summary>
    /// <returns> a list of bluetooth device  &lt;name, address&gt; </returns>

    
    public Variant getAssociatedDeviceList()
    {


	Variant result = call("getAssociatedDeviceList" );

	    	return  result;
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
    /// list all connected bluetooth devices
    /// </summary>
    /// <returns> a list of connected bluetooth device  &lt;name&gt; </returns>

    
    public String[] getConnectedDeviceList()
    {


	Variant result = call("getConnectedDeviceList" );

	    	return (String[]) result.toStringArray();
    }

    



    /// <summary>
    /// list all available bluetooth devices (need a scan before)
    /// </summary>
    /// <returns> a list of bluetooth device  &lt;name, address&gt; </returns>

    
    public Variant getDeviceList()
    {


	Variant result = call("getDeviceList" );

	    	return  result;
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
    /// Is a device connected?
    /// </summary>
    /// <param name="devicename"> the device name </param>
    /// <returns> return true is the device is connected </returns>

    
    
    
    public Boolean isConnected( String devicename)
    {

	Variant vdevicename;
	vdevicename = new Variant(devicename);

	Variant result = call("isConnected" ,vdevicename);

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
    /// Scan for bluetooth devices, this may take up to 10 seconds
    /// </summary>
    /// <returns> a list of bluetooth devices  &lt;name, address&gt; </returns>

    
    public Variant scan()
    {


	Variant result = call("scan" );

	    	return  result;
    }

    



    /// <summary>
    /// Send data to a bluetooth device, each value should be provided.
    /// </summary>
    /// <param name="devicename"> the device name </param>
    /// <param name="PWMs"> array of 4 signed short, should be between -32768 and 32768 (duty cycle ranging from -100% to 100%) </param>
    /// <param name="servos"> array of 2 unsigned short, should be between 500 and 2500 (pulse width in microsecond) </param>
    /// <param name="GPIOs"> array of 4 bool </param>

    
    
    
    
    
    
    
    
    
    public void send( String devicename,  Variant PWMs,  Variant servos,  Variant GPIOs)
    {

	Variant vdevicename;
	vdevicename = new Variant(devicename);
	Variant vPWMs;
	vPWMs = new Variant(PWMs);
	Variant vservos;
	vservos = new Variant(servos);
	Variant vGPIOs;
	vGPIOs = new Variant(GPIOs);

	Variant result = call("send" ,vdevicename, vPWMs, vservos, vGPIOs);

		// no return value
    }

    



    /// <summary>
    /// set the device list that nao should handle. Association will be persistent after reboot.
    /// </summary>
    /// <param name="deviceList"> list of bluetooth devices &lt;name, address&gt; </param>

    
    
    
    public void setAssociatedDeviceList( Variant deviceList)
    {

	Variant vdeviceList;
	vdeviceList = new Variant(deviceList);

	Variant result = call("setAssociatedDeviceList" ,vdeviceList);

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


