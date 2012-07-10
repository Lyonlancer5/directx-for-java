package com.fourthskyinteractive.dx4j.dxgi.adapter;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;
import org.bridj.cpp.com.IUnknown;

import com.fourthskyinteractive.dx4j.dxgi.DXGI_MODE_DESC;
import com.fourthskyinteractive.dx4j.dxgi.IDXGIObject;
import com.fourthskyinteractive.dx4j.dxgi.device.IDXGISurface;
/**
 * <i>native declaration : DXGI.h:1257</i><br>
 * Error: Conversion Error : uuid("aec22fb8-76f3-4639-9be0-28eb43a67a2e") novtable struct IDXGIObject {<br>
 * 	/// Original signature : <code>int SetPrivateData(const GUID&, UINT, const void*)</code><br>
 * 	virtual int SetPrivateData(const GUID& Name, UINT DataSize, const void* pData);<br>
 * 	/// Original signature : <code>int SetPrivateDataInterface(const GUID&, const IUnknown*)</code><br>
 * 	virtual int SetPrivateDataInterface(const GUID& Name, const IUnknown* pUnknown);<br>
 * 	/// Original signature : <code>int GetPrivateData(const GUID&, UINT*, void*)</code><br>
 * 	virtual int GetPrivateData(const GUID& Name, UINT* pDataSize, void* pData);<br>
 * 	/// Original signature : <code>int GetParent(const IID&, void**)</code><br>
 * 	virtual int GetParent(const IID& riid, void** ppParent);<br>
 * } (Cannot find parent IUnknown of struct uuid("aec22fb8-76f3-4639-9be0-28eb43a67a2e") novtable struct IDXGIObject {<br>
 * 	/// Original signature : <code>int SetPrivateData(const GUID&, UINT, const void*)</code><br>
 * 	virtual int SetPrivateData(const GUID& Name, UINT DataSize, const void* pData);<br>
 * 	/// Original signature : <code>int SetPrivateDataInterface(const GUID&, const IUnknown*)</code><br>
 * 	virtual int SetPrivateDataInterface(const GUID& Name, const IUnknown* pUnknown);<br>
 * 	/// Original signature : <code>int GetPrivateData(const GUID&, UINT*, void*)</code><br>
 * 	virtual int GetPrivateData(const GUID& Name, UINT* pDataSize, void* pData);<br>
 * 	/// Original signature : <code>int GetParent(const IID&, void**)</code><br>
 * 	virtual int GetParent(const IID& riid, void** ppParent);<br>
 * })<br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@IID("ae02eedb-c735-4690-8d52-5a8dc20213aa") 
@Library("dxgi") 
@Runtime(COMRuntime.class)
public class IDXGIOutput extends IDXGIObject {
	public IDXGIOutput() {
		super();
	}
//	public IDXGIOutput(Pointer pointer) {
//		super(pointer);
//	}
	@Virtual(0) 
	public native int GetDesc(Pointer<DXGI_OUTPUT_DESC > pDesc);
	@Virtual(2) 
	public native int FindClosestMatchingMode(Pointer<DXGI_MODE_DESC> pModeToMatch, Pointer<DXGI_MODE_DESC> pClosestMatch, Pointer<IUnknown > pConcernedDevice);
	@Virtual(3) 
	public native int WaitForVBlank();
	@Virtual(4) 
	public native int TakeOwnership(Pointer<IUnknown> pDevice, int Exclusive);
	@Virtual(5) 
	public native void ReleaseOwnership();
	@Virtual(6) 
	public native int GetGammaControlCapabilities(Pointer<DXGI_GAMMA_CONTROL_CAPABILITIES> pGammaCaps);
	@Virtual(7) 
	public native int SetGammaControl(Pointer<DXGI_GAMMA_CONTROL> pArray);
	@Virtual(8) 
	public native int GetGammaControl(Pointer<DXGI_GAMMA_CONTROL> pArray);
	@Virtual(9) 
	public native int SetDisplaySurface(Pointer<IDXGISurface > pScanoutSurface);
	@Virtual(10) 
	public native int GetDisplaySurfaceData(Pointer<IDXGISurface > pDestination);
	@Virtual(11) 
	public native int GetFrameStatistics(Pointer<DXGI_FRAME_STATISTICS > pStats);
}
