package com.fourthskyinteractive.dx4j.d3d11.layer;

import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;
import org.bridj.cpp.com.IUnknown;

@IID("")
@Library("d3d11")
@Runtime(COMRuntime.class)
public class ID3D11InfoQueue extends IUnknown {
	public ID3D11InfoQueue() {
		super();
	}
//	public ID3D11InfoQueue(Pointer<? extends IUnknown> peer) {
//		super(peer);
//	}

}
