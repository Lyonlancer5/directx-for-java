package com.fourthskyinteractive.dx4j.d3d11.resources.views;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

@IID("9fdac92a-1876-48c3-afad-25b94f84a9b6")
@Library("d3d11")
@Runtime(COMRuntime.class)
public class ID3D11DepthStencilView extends ID3D11View {

	public ID3D11DepthStencilView() {
		super();
	}

//	public ID3D11DepthStencilView(Pointer pointer) {
//		super(pointer);
//	}
	@Virtual(0)
	public native void GetDesc(Pointer<D3D11_DEPTH_STENCIL_VIEW_DESC> pDesc);
}
