package com.fourthskyinteractive.dx4j.d2d1.resources.brush;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

import com.fourthskyinteractive.dx4j.d2d1.resources.geometry.D2D1_COLOR_F;

@IID("2cd906a9-12e2-11dc-9fed-001143a055f9")
@Library("d2d1")
@Runtime(COMRuntime.class)
public class ID2D1SolidColorBrush extends ID2D1Brush {

	public ID2D1SolidColorBrush() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public ID2D1SolidColorBrush(Pointer<? extends IUnknown> peer) {
//		super(peer);
//		// TODO Auto-generated constructor stub
//	}

	@Virtual(0)
	public native void SetColor(Pointer<D2D1_COLOR_F> color);
	@Virtual(1)
	public native D2D1_COLOR_F GetColor();
}
