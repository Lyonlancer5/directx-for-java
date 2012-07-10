package com.fourthskyinteractive.dx4j.d2d1.resources.geometry;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;


@IID("2cd906a4-12e2-11dc-9fed-001143a055f9")
@Library("d2d1")
@Runtime(COMRuntime.class)
public class ID2D1EllipseGeometry extends ID2D1Geometry {

	public ID2D1EllipseGeometry() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public ID2D1EllipseGeometry(Pointer<? extends IUnknown> peer) {
//		super(peer);
//		// TODO Auto-generated constructor stub
//	}

	@Virtual(0)
	public native void GetEllipse(Pointer<D2D1_ELLIPSE> ellipse);
}
