package com.fourthskyinteractive.dx4j.d3d11.resources.views;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

@IID("b0e06fe0-8192-4e1a-b1ca-36d7414710b2")
@Library("d3d11")
@Runtime(COMRuntime.class)
public class ID3D11ShaderResourceView extends ID3D11View {

	public ID3D11ShaderResourceView() {
		super();
	}

//	public ID3D11ShaderResourceView(Pointer pointer) {
//		super(pointer);
//	}

	@Virtual(0)
	public native void GetDesc(Pointer<D3D11_SHADER_RESOURCE_VIEW_DESC> pDesc);
}
