package com.fourthskyinteractive.dx4j.dxgi;

import static org.bridj.Pointer.allocatePointer;
import static org.bridj.Pointer.pointerTo;

import java.util.ArrayList;
import java.util.List;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;
import org.bridj.cpp.com.IUnknown;

import com.fourthskyinteractive.dx4j.dxgi.adapter.IDXGIAdapter;
import com.fourthskyinteractive.dx4j.dxgi.device.DXGI_SWAP_CHAIN_DESC;
import com.fourthskyinteractive.dx4j.dxgi.device.IDXGISwapChain;
import com.fourthskyinteractive.dx4j.windows.HMODULE;
/**
 * <i>native declaration : DXGI.h:1810</i><br>
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
@IID("7b7166ec-21c7-44ae-b21a-c9ae321ae369") 
@Library("dxgi") 
@Runtime(COMRuntime.class)
public class IDXGIFactory extends IDXGIObject {
	public IDXGIFactory() {
		super();
	}
//	public IDXGIFactory(Pointer pointer) {
//		super(pointer);
//	}
	@Deprecated @Virtual(0) 
	public native int EnumAdapters(int Adapter, Pointer<Pointer<IDXGIAdapter>> ppAdapter);
	@Virtual(1) 
	public native int MakeWindowAssociation(Pointer<?> WindowHandle, int Flags);
	@Virtual(2) 
	public native int GetWindowAssociation(Pointer<Pointer<?> > pWindowHandle);
	@Deprecated @Virtual(3) 
	public native int CreateSwapChain(Pointer<? extends IUnknown> pDevice, Pointer<DXGI_SWAP_CHAIN_DESC > pDesc, Pointer<Pointer<IDXGISwapChain > > ppSwapChain);
	@Virtual(4) 
	public native int CreateSoftwareAdapter(HMODULE Module, Pointer<Pointer<IDXGIAdapter > > ppAdapter);
	
	// "Javanized" methods
	public IDXGISwapChain CreateSwapChain(IUnknown device, DXGI_SWAP_CHAIN_DESC desc) throws DXGIException {
		Pointer<Pointer<IDXGISwapChain>> ppSwapChain = null;
		
		try {
			ppSwapChain = allocatePointer(IDXGISwapChain.class);
			int result = CreateSwapChain(pointerTo(device), pointerTo(desc), ppSwapChain);
			if(result != 0) {
				throw new DXGIException(result);
			}
			
			return ppSwapChain.get().getNativeObject(IDXGISwapChain.class);
			
		} finally {
			if(ppSwapChain != null) {
				ppSwapChain.release();
				ppSwapChain = null;
			}
		}
	}
	
	public List<IDXGIAdapter> EnumAdapters() {
		List<IDXGIAdapter> adapters = new ArrayList<IDXGIAdapter>();
		Pointer<Pointer<IDXGIAdapter>> pp = allocatePointer(IDXGIAdapter.class);
		
		try {
			int i = 0;
			while (this.EnumAdapters(i, pp) != DXGI.DXGI_ERROR_NOT_FOUND) {
				adapters.add(pp.get().getNativeObject(IDXGIAdapter.class));				
				i++;
			}			
			
		} finally {
			pp.release();
			pp = null;
		}
		
		return adapters;
	}
}
