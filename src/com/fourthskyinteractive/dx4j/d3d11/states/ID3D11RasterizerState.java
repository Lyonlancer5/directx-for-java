package com.fourthskyinteractive.dx4j.d3d11.states;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11DeviceChild;

@IID("9bb4ab81-ab1a-4d8f-b506-fc04200b6ee7")
@Library("d3d11")
@Runtime(COMRuntime.class)
public class ID3D11RasterizerState extends ID3D11DeviceChild {

	private int hashCode;
	
	public ID3D11RasterizerState() {
		super();
	}
//	public ID3D11RasterizerState(Pointer pointer) {
//		super(pointer);
//	}
	@Virtual(0)
	public final native void GetDesc(Pointer<D3D11_RASTERIZER_DESC> pDesc);
	
	public final D3D11_RASTERIZER_DESC GetDesc() {
		Pointer<D3D11_RASTERIZER_DESC> p = Pointer.allocate(D3D11_RASTERIZER_DESC.class);
		try {
			GetDesc(p);
			return p.get();
		} finally {
			p.release();
		}
	}
	
	public int hashCode() {
		if(hashCode == 0) {
			hashCode = GetDesc().hashCode();
		}
		return hashCode;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		if(hashCode() != obj.hashCode()) 
			return false;
		
		return true;
	}	
}
