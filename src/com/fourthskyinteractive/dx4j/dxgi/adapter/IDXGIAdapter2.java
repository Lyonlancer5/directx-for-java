package com.fourthskyinteractive.dx4j.dxgi.adapter;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;


@IID("")
@Library("DXGI")
@Runtime(COMRuntime.class)
public class IDXGIAdapter2 extends IDXGIAdapter1 {

	public IDXGIAdapter2() {
		// TODO Auto-generated constructor stub
	}

	@Virtual(0)
	public final native int GetDesc2(Pointer<DXGI_ADAPTER_DESC2> pDesc);
}
