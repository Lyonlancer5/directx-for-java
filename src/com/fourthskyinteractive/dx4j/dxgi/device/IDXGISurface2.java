package com.fourthskyinteractive.dx4j.dxgi.device;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.GUID;
import org.bridj.cpp.com.IID;

@IID("")
@Library("DXGI")
@Runtime(COMRuntime.class)
public class IDXGISurface2 extends IDXGISurface1 {

	public IDXGISurface2() {
		// TODO Auto-generated constructor stub
	}

	@Virtual(0)
	public final native int GetResource(Pointer<GUID> riid, Pointer<Pointer<?>> ppParentResource, Pointer<Integer> pSubresourceIndex); 
}
