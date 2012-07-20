package com.fourthskyinteractive.dx4j.d3d11.core;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Resource;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11View;

import static org.bridj.Pointer.*;

@IID("")
@Library("D3D11_1")
@Runtime(COMRuntime.class)
public class ID3D11DeviceContext1 extends ID3D11DeviceContext {

	public ID3D11DeviceContext1() {
		// TODO Auto-generated constructor stub
	}

	@Virtual(0)
	public final native void DiscardView(Pointer<ID3D11View> pResourceView);
	
	@Virtual(1)
	public final native void DiscardResource(Pointer<ID3D11Resource> pResource);
	
	public final void DiscardView(ID3D11View view) {
		DiscardView(pointerTo(view));
	}
	
	public final void DiscardResource(ID3D11Resource resource) {
		DiscardResource(pointerTo(resource));
	}
			
}
