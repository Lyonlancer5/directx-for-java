package com.fourthskyinteractive.dx4j.dxgi.adapter;

import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;
import org.bridj.cpp.com.IUnknown;

@IID("")
@Library("DXGI")
@Runtime(COMRuntime.class)
public class IDXGIDisplayControl extends IUnknown {

	public IDXGIDisplayControl() {
		// TODO Auto-generated constructor stub
	}

	@Virtual(0)
	public final native int IsStereoEnabled();
	
	@Virtual(1)
	public final native void SetStereoEnabled(int Enabled);
}
