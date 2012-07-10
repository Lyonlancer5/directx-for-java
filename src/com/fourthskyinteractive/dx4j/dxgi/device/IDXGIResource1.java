package com.fourthskyinteractive.dx4j.dxgi.device;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

import com.fourthskyinteractive.dx4j.windows.HANDLE;
import com.fourthskyinteractive.dx4j.windows.kernel32.SECURITY_ATTRIBUTES;

@IID("")
@Library("DXGI")
@Runtime(COMRuntime.class)
public class IDXGIResource1 extends IDXGIResource {

	public IDXGIResource1() {
		// TODO Auto-generated constructor stub
	}

	@Virtual(0)
	public final native int CreateSharedHandle(Pointer<SECURITY_ATTRIBUTES> pAttributes, int dwAccess, Pointer<Byte> lpName, Pointer<HANDLE> pHandle);
	
	@Virtual(1)
	public final native int CreateSubresourceSurface(int index, Pointer<Pointer<IDXGISurface2>> ppSurface); 
}