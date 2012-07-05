package com.fourthskyinteractive.dx4j.dxgi.device;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

import com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_OFFER_RESOURCE_PRIORITY;
import com.fourthskyinteractive.dx4j.windows.HANDLE;

@IID("")
@Library("DXGI")
@Runtime(COMRuntime.class)
public class IDXGIDevice2 extends IDXGIDevice1 {

	public IDXGIDevice2() {
		// TODO Auto-generated constructor stub
	}
	
	@Virtual(0)
	public final native int EnqueueSetEvent(HANDLE hEvent);
	
	@Virtual(1)
	public final native int OfferResources(int NumResources, Pointer<Pointer<IDXGIResource>> ppResources, DXGI_OFFER_RESOURCE_PRIORITY Priority);
	
	@Virtual(2)
	public final native int ReclaimResources(int NumResources, Pointer<Pointer<IDXGIResource>> ppResources, Pointer<Integer> pDiscarded);
}
