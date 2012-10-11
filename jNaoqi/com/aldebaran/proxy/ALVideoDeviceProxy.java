// Author: Aldebaran-Robotics
// Auto generated file.



package com.aldebaran.proxy;
public class ALVideoDeviceProxy extends ALProxy
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
	public ALVideoDeviceProxy(String ip, int port)
	{
		super("ALVideoDevice", ip, port);
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
    /// Get the active camera
    /// </summary>
    /// <returns> 0: top camera - 1: bottom camera </returns>

    
    public int getActiveCamera()
    {


	Variant result = call("getActiveCamera" );

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Returns angles relative to camera axis given a normalized position in the image.
    /// </summary>
    /// <param name="imgPos"> normalized position in the image [0.0 - 1.0] </param>
    /// <returns> corresponding angles values in radians. </returns>

    
    
    
    public float[] getAngPosFromImgPos( float[] imgPos)
    {

	Variant vimgPos;
	vimgPos = new Variant(imgPos);

	Variant result = call("getAngPosFromImgPos" ,vimgPos);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Returns angles relative to camera axis given a normalized position in the image.
    /// </summary>
    /// <param name="imgSize"> normalized position in the image [0.0 - 1.0] </param>
    /// <returns> corresponding angles values in radians. </returns>

    
    
    
    public float[] getAngSizeFromImgSize( float[] imgSize)
    {

	Variant vimgSize;
	vimgSize = new Variant(imgSize);

	Variant result = call("getAngSizeFromImgSize" ,vimgSize);

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
    /// Returns a pointer to a locked ALImage, with data array pointing directly to raw data. No format conversion and no copy of the raw buffer.
    ///
    ///   When image is not necessary anymore, a call to releaseDirectRawImage() is requested.
    ///
    ///    Warning: 1. when using this mode for several G.V.M., if they need raw data for more than 25ms check that you have strictly less G.V.M. modules in this mode than the amount of kernel buffers!! 2. Release all kernel buffers before any action requesting a modification in camera running mode (e.g. resolution, switch between cameras).
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <returns> Pointer to the locked image buffer, NULL if error.   Warning, image pointer is valid only for C++ dynamic library. </returns>

    
    
    
    public void  getDirectRawImageLocal( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getDirectRawImageLocal" ,vid);

    }

    



    /// <summary>
    /// Fills pFrameOut with data coming directly from raw buffer (no format conversion).
    ///
    /// No need to call releaseDirectRawImage() because it is done automatically at the end of data transmission.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <returns> Array containing image informations : 
    ///
    ///     [0] : width;
    ///
    ///     [1] : height;
    ///
    ///     [2] : number of layers;
    ///
    ///     [3] : ColorSpace;
    ///
    ///     [4] : time stamp (highest 32 bits);
    ///
    ///     [5] : time stamp (lowest 32 bits);
    ///
    ///     [6] : array of size height * width * nblayers containing image data;
    ///
    ///     [7] : camera ID; </returns>

    
    
    
    public Variant getDirectRawImageRemote( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getDirectRawImageRemote" ,vid);

	    	return  result;
    }

    



    /// <summary>
    /// Get the color space of the requested G.V.M.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <returns> { 0 = kYuv, 9 = kYUV422, 10 = kYUV, 11 = kRGB, 12 = kHSY, 13 = kBGR } -1: can't access video source </returns>

    
    
    
    public int getGVMColorSpace( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getGVMColorSpace" ,vid);

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Get the frame rate of the requested G.V.M.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <returns> { 5, 10, 15, 30 }  -1: can't access video source </returns>

    
    
    
    public int getGVMFrameRate( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getGVMFrameRate" ,vid);

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Get the resolution of the requested G.V.M.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <returns> { 0 = kQQVGA, 1 = kQVGA, 2 = kVGA }  -1: can't access video source </returns>

    
    
    
    public int getGVMResolution( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getGVMResolution" ,vid);

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Applies transformations to the last image from video source and returns a pointer to a locked ALImage.
    ///
    /// When image is not necessary anymore, a call to releaseImage() is requested.
    ///
    /// If the G.V.M. didn't release preceding image, returns NULL.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice (formerly called V.I.M.) </param>
    /// <returns> Pointer of the locked image buffer, NULL if error.Warning, image pointer is valid only for C++ dynamic library. </returns>

    
    
    
    public void  getImageLocal( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getImageLocal" ,vid);

    }

    



    /// <summary>
    /// Applies transformations to the last image from video source and fills pFrameOut.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <returns> Array containing image informations : 
    ///
    ///     [0] : width;
    ///
    ///     [1] : height;
    ///
    ///     [2] : number of layers;
    ///
    ///     [3] : ColorSpace;
    ///
    ///     [4] : time stamp (highest 32 bits);
    ///
    ///     [5] : time stamp (lowest 32 bits);
    ///
    ///     [6] : array of size height * width * nblayers containing image data;
    ///
    ///     [7] : camera ID; </returns>

    
    
    
    public Variant getImageRemote( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("getImageRemote" ,vid);

	    	return  result;
    }

    



    /// <summary>
    /// Returns normalized image info from angles info in radians (as returned by vision extractors).
    /// </summary>
    /// <param name="angles"> camera angle values in radians. </param>
    /// <returns> corresponding normalized position info. </returns>

    
    
    
    public float[] getImgInfoFromAngInfo( float[] angles)
    {

	Variant vangles;
	vangles = new Variant(angles);

	Variant result = call("getImgInfoFromAngInfo" ,vangles);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Returns image info from angles info in radians (as returned by vision extractors). Express image info in the requested resolution.
    /// </summary>
    /// <param name="angInfo"> camera angle values in radians. </param>
    /// <param name="arg2"> arg </param>
    /// <returns> corresponding position info. </returns>

    
    
    
    
    
    public float[] getImgInfoFromAngInfoWithRes( float[] angInfo,  int arg2)
    {

	Variant vangInfo;
	vangInfo = new Variant(angInfo);
	Variant varg2;
	varg2 = new Variant(arg2);

	Variant result = call("getImgInfoFromAngInfoWithRes" ,vangInfo, varg2);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Returns normalized image position from camera angles in radians.
    /// </summary>
    /// <param name="angPos"> camera angle values in radians. </param>
    /// <returns> corresponding normalized position in the image [0.0 - 1.0] </returns>

    
    
    
    public float[] getImgPosFromAngPos( float[] angPos)
    {

	Variant vangPos;
	vangPos = new Variant(angPos);

	Variant result = call("getImgPosFromAngPos" ,vangPos);

	    	return (float[]) result.toFloatArray();
    }

    



    /// <summary>
    /// Returns normalized image position from camera angles in radians.
    /// </summary>
    /// <param name="angSize"> camera angle values in radians. </param>
    /// <returns> corresponding normalized position in the image [0.0 - 1.0] </returns>

    
    
    
    public float[] getImgSizeFromAngSize( float[] angSize)
    {

	Variant vangSize;
	vangSize = new Variant(angSize);

	Variant result = call("getImgSizeFromAngSize" ,vangSize);

	    	return (float[]) result.toFloatArray();
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
    /// Get the value of a video source specific parameter.
    /// </summary>
    /// <param name="pParam"> Parameter's reference among kCameraBrightnessID,
    ///
    ///  kCameraContrastID,
    ///
    ///  kCameraSaturationID,
    ///
    ///  kCameraHueID,
    ///
    ///  kCameraRedChromaID,
    ///
    ///  kCameraBlueChromaID,
    ///
    ///  kCameraGainID,
    ///
    ///  kCameraHFlipID,
    ///
    ///  kCameraVFlipID,
    ///
    ///  kCameraLensXID,
    ///
    ///  kCameraLensYID,
    ///
    ///  kCameraAutoExpositionID,
    ///
    ///  kCameraAecAlgorithmID [0:average-based; 1:histogram-based],
    ///
    ///  kCameraExposureCorrectionID [-6; 6] (correction by n/3 IL, switch automatically in average-based AEC algorithm if n!=0 and back to histogram-based for n=0),
    ///
    ///  kCameraExposureID,
    ///
    ///  kCameraAutoWhiteBalanceID,
    ///
    ///  kCameraAutoGainID,
    ///
    ///  kCameraSelectID [0:top camera; 1:bottom camera],
    ///
    ///  kCameraResolutionID,
    ///
    ///  kCameraFrameRateID,
    ///
    ///  kCameraBufferSizeID,
    ///
    ///  kCameraFastSwitchID (need both camera to run same format/ parameter value has no signification),
    ///
    ///  kCameraSharpnessID (0-1: no sharpness - 2: medium sharpness - 3-5: high sharpness) </param>
    /// <returns> Parameter's value. </returns>

    
    
    
    public int getParam( int pParam)
    {

	Variant vpParam;
	vpParam = new Variant(pParam);

	Variant result = call("getParam" ,vpParam);

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
    /// Get the color space of the video source image.
    /// </summary>
    /// <returns> { 0 = kYuv, 9 = kYUV422, 10 = kYUV, 11 = kRGB, 12 = kHSY, 13 = kBGR }  -1 can't access video source </returns>

    
    public int getVIMColorSpace()
    {


	Variant result = call("getVIMColorSpace" );

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Get the frame rate of the video source image.
    /// </summary>
    /// <returns> { 5, 10, 15, 30 }   -1: can't access video source </returns>

    
    public int getVIMFrameRate()
    {


	Variant result = call("getVIMFrameRate" );

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Get the resolution of the video source image.
    /// </summary>
    /// <returns> { 0 = kQQVGA, 1 = kQVGA, 2 = kVGA }  -1: can't access video source </returns>

    
    public int getVIMResolution()
    {


	Variant result = call("getVIMResolution" );

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Advanced method that asks if the framegrabber is off.
    /// </summary>
    /// <returns> true if off </returns>

    
    public int isFrameGrabberOff()
    {


	Variant result = call("isFrameGrabberOff" );

	    	return  result.toInt();
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
    /// Callback when client is disconnected
    /// </summary>
    /// <param name="eventName"> The echoed event name </param>
    /// <param name="eventContents"> The name of the client that has disconnected </param>
    /// <param name="message"> The message give when subscribing. </param>

    
    
    
    
    
    
    
    public void onClientDisconnected( String eventName,  Variant eventContents,  String message)
    {

	Variant veventName;
	veventName = new Variant(eventName);
	Variant veventContents;
	veventContents = new Variant(eventContents);
	Variant vmessage;
	vmessage = new Variant(message);

	Variant result = call("onClientDisconnected" ,veventName, veventContents, vmessage);

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
    /// BETA - background record of an .arv raw format video from the images processed by a G.V.M.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from the V.I.M. </param>
    /// <param name="path"> path/name of the video to be recorded </param>
    /// <param name="totalNumber"> number of images to be recorded. 0xFFFFFFFF for \"unlimited\" </param>
    /// <param name="period"> one image recorded every pPeriod images </param>
    /// <returns> true if success </returns>

    
    
    
    
    
    
    
    
    
    public Boolean recordVideo( String id,  String path,  int totalNumber,  int period)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vpath;
	vpath = new Variant(path);
	Variant vtotalNumber;
	vtotalNumber = new Variant(totalNumber);
	Variant vperiod;
	vperiod = new Variant(period);

	Variant result = call("recordVideo" ,vid, vpath, vtotalNumber, vperiod);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Release image buffer locked by getDirectRawImageLocal().
    ///
    /// If G.V.M. had no locked image buffer, does nothing.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from the V.I.M. </param>
    /// <returns> true if success </returns>

    
    
    
    public int releaseDirectRawImage( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("releaseDirectRawImage" ,vid);

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Release image buffer locked by getImageLocal().
    ///
    /// If G.V.M. had no locked image buffer, does nothing.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <returns> true if success </returns>

    
    
    
    public int releaseImage( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("releaseImage" ,vid);

	    	return  result.toInt();
    }

    



    /// <summary>
    /// return the width and the height of a resolution
    /// </summary>
    /// <param name="resolution"> { 0 = kQQVGA, 1 = kQVGA, 2 = kVGA } </param>
    /// <returns> array of sizes: (return [-1;-1] if the format is invalid)  
    ///
    ///     [0] : width;
    ///
    ///     [1] : height; </returns>

    
    
    
    public Variant resolutionToSizes( int resolution)
    {

	Variant vresolution;
	vresolution = new Variant(resolution);

	Variant result = call("resolutionToSizes" ,vresolution);

	    	return  result;
    }

    



    /// <summary>
    /// Set the colorspace of the output image.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <param name="colorSpace"> { 0 = kYuv, 9 = kYUV422, 10 = kYUV, 11 = kRGB, 12 = kHSY, 13 = kBGR } </param>
    /// <returns> true if success </returns>

    
    
    
    
    
    public Boolean setColorSpace( String id,  int colorSpace)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vcolorSpace;
	vcolorSpace = new Variant(colorSpace);

	Variant result = call("setColorSpace" ,vid, vcolorSpace);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Set the required frame rate.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <param name="frameRate"> images per seconds { 5, 10, 15, 30 } </param>
    /// <returns> true if success </returns>

    
    
    
    
    
    public Boolean setFrameRate( String id,  int frameRate)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vframeRate;
	vframeRate = new Variant(frameRate);

	Variant result = call("setFrameRate" ,vid, vframeRate);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Sets the value of a specific parameter for the video source.
    /// </summary>
    /// <param name="param"> Parameter's reference among:
    ///
    ///  kCameraBrightnessID,
    ///
    ///  kCameraContrastID,
    ///
    ///  kCameraSaturationID,
    ///
    ///  kCameraHueID,
    ///
    ///  kCameraRedChromaID,
    ///
    ///  kCameraBlueChromaID,
    ///
    ///  kCameraGainID,
    ///
    ///  kCameraHFlipID,
    ///
    ///  kCameraVFlipID,
    ///
    ///  kCameraLensXID (not managed by camera),
    ///
    ///  kCameraLensYID (not managed by camera),
    ///
    ///  kCameraAutoExpositionID,
    ///
    ///  kCameraAecAlgorithmID [0:average-based; 1:histogram-based],
    ///
    ///  kCameraExposureCorrectionID [-6; 6] (correction by n/3 EV, switch automatically in average-based AEC algorithm if n!=0 and back to histogram-based for n=0),
    ///
    ///  kCameraExposureID,
    ///
    ///  kCameraAutoWhiteBalanceID,
    ///
    ///  kCameraAutoGainID,
    ///
    ///  kCameraSelectID [0:top camera; 1:bottom camera],
    ///
    ///  kCameraResolutionID,
    ///
    ///  kCameraFrameRateID (not managed currently),
    ///
    ///  kCameraBufferSizeID,
    ///
    ///  kCameraSharpnessID (0-1: no sharpness - 2: medium sharpness - 3-5: high sharpness),
    ///
    ///  kCameraFastSwitchID : advanced method that needs both camera to run same format. Parameter value has no meaning.
    ///
    ///     Remarks: Disabled camera (freezed actually) will get back to auto gain/exposure/white balance settings after a while. This is a camera issue.
    ///
    ///              Fast switch usually switchs between cameras in 66ms (33ms for waked up sensor exposure + 33ms for data transfer) after previous image completion. However, sometimes we can observe a clipped image from the former camera after 66ms. This is an electronical issue and so we suggest to considere only images after 100ms </param>
    /// <param name="newValue"> Parameter's new value. </param>

    
    
    
    
    
    public void setParam( int param,  int newValue)
    {

	Variant vparam;
	vparam = new Variant(param);
	Variant vnewValue;
	vnewValue = new Variant(newValue);

	Variant result = call("setParam" ,vparam, vnewValue);

		// no return value
    }

    



    /// <summary>
    /// Sets a specific parameter for the video source at its default value.
    /// </summary>
    /// <param name="param"> Parameter's reference. </param>

    
    
    
    public void setParamDefault( int param)
    {

	Variant vparam;
	vparam = new Variant(param);

	Variant result = call("setParamDefault" ,vparam);

		// no return value
    }

    



    /// <summary>
    /// Set the size of the output image.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <param name="size"> { 0 = kQQVGA, 1 = kQVGA, 2 = kVGA } </param>
    /// <returns> true if success </returns>

    
    
    
    
    
    public Boolean setResolution( String id,  int size)
    {

	Variant vid;
	vid = new Variant(id);
	Variant vsize;
	vsize = new Variant(size);

	Variant result = call("setResolution" ,vid, vsize);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// return the resolution from sizes
    /// </summary>
    /// <param name="width"> width of the image </param>
    /// <param name="height"> height of the image </param>
    /// <returns> { 0 = kQQVGA, 1 = kQVGA, 2 = kVGA }  or -1 if the inputs are invalid </returns>

    
    
    
    
    
    public int sizesToResolution( int width,  int height)
    {

	Variant vwidth;
	vwidth = new Variant(width);
	Variant vheight;
	vheight = new Variant(height);

	Variant result = call("sizesToResolution" ,vwidth, vheight);

	    	return  result.toInt();
    }

    



    /// <summary>
    /// Advanced method that opens and initialize video source device if it was not before.
    ///
    /// Note that the first module subscribing to ALVideoDevice will launch it automatically.
    /// </summary>
    /// <returns> true if success </returns>

    
    public int startFrameGrabber()
    {


	Variant result = call("startFrameGrabber" );

	    	return  result.toInt();
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
    /// Advanced method that close video source device.
    /// </summary>
    /// <returns> true if success </returns>

    
    public int stopFrameGrabber()
    {


	Variant result = call("stopFrameGrabber" );

	    	return  result.toInt();
    }

    



    /// <summary>
    /// BETA - stop writing the video sequence
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>
    /// <returns> true if success </returns>

    
    
    
    public Boolean stopVideo( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("stopVideo" ,vid);

	    	return  result.toBoolean();
    }

    



    /// <summary>
    /// Register to ALVideoDevice (formerly Video Input Module/V.I.M.). When a General Video Module(G.V.M.) registers to ALVideoDevice, a buffer of the requested image format is added to the buffers list.
    ///
    /// Returns the name under which the G.V.M. is registered to ALVideoDevice (useful when two G.V.M. try to register using the same name
    /// </summary>
    /// <param name="gvmName"> Name of the registering G.V.M. </param>
    /// <param name="resolution"> Resolution requested. { 0 = kQQVGA, 1 = kQVGA, 2 = kVGA } </param>
    /// <param name="colorSpace"> Colorspace requested. { 0 = kYuv, 9 = kYUV422, 10 = kYUV, 11 = kRGB, 12 = kHSY, 13 = kBGR } </param>
    /// <param name="fps"> Fps (frames per second) requested. { 5, 10, 15, 30 } </param>
    /// <returns> Name under which the G.V.M. is known from ALVideoDevice, 0 if failed. </returns>

    
    
    
    
    
    
    
    
    
    public String subscribe( String gvmName,  int resolution,  int colorSpace,  int fps)
    {

	Variant vgvmName;
	vgvmName = new Variant(gvmName);
	Variant vresolution;
	vresolution = new Variant(resolution);
	Variant vcolorSpace;
	vcolorSpace = new Variant(colorSpace);
	Variant vfps;
	vfps = new Variant(fps);

	Variant result = call("subscribe" ,vgvmName, vresolution, vcolorSpace, vfps);

	    	return  result.toString();
    }

    



    /// <summary>
    /// Used to unregister a G.V.M. from ALVideoDevice.
    /// </summary>
    /// <param name="id"> Name under which the G.V.M. is known from ALVideoDevice. </param>

    
    
    
    public void unsubscribe( String id)
    {

	Variant vid;
	vid = new Variant(id);

	Variant result = call("unsubscribe" ,vid);

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


