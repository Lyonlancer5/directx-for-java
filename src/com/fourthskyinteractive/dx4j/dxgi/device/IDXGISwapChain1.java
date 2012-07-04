package com.fourthskyinteractive.dx4j.dxgi.device;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

@IID("")
@Library("DXGI")
@Runtime(COMRuntime.class)
public class IDXGISwapChain1 extends IDXGISwapChain {

	public IDXGISwapChain1() {
	}

	@Virtual(0)
	public final native int Present1(int SyncInterval, int Flags, Pointer<DXGI_PRESENT_PARAMETERS> pParams);
}
