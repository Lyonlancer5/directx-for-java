package com.fourthskyinteractive.dx4j.dxgi.device;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;

public class DXGI_PRESENT_PARAMETERS extends StructObject {

	public DXGI_PRESENT_PARAMETERS() {
		// TODO Auto-generated constructor stub
	}

	public DXGI_PRESENT_PARAMETERS(Pointer<? extends StructObject> peer) {
		super(peer);
		// TODO Auto-generated constructor stub
	}

	@Field(0)
	public int DirtyRectsCount() {
		return this.io.getIntField(this, 0);
	}

}
