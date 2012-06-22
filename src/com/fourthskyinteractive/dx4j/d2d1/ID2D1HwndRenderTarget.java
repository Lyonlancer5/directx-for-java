package com.fourthskyinteractive.dx4j.d2d1;

import org.bridj.Pointer;
import org.bridj.ValuedEnum;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;

import com.fourthskyinteractive.dx4j.d2d1.D2d1Library.D2D1_WINDOW_STATE;

@IID("2cd90698-12e2-11dc-9fed-001143a055f9")
@Library("d2d1")
@Runtime(COMRuntime.class)
public class ID2D1HwndRenderTarget extends ID2D1RenderTarget {

	public ID2D1HwndRenderTarget() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public ID2D1HwndRenderTarget(Pointer<? extends IUnknown> peer) {
//		super(peer);
//		// TODO Auto-generated constructor stub
//	}

	@Virtual(0)
	public native ValuedEnum<D2D1_WINDOW_STATE> CheckWindowState();
	@Virtual(1)
	public native int Resize(Pointer<D2D1_SIZE_U> pixelSize);
	@Virtual(2)
	public native Pointer<?> GetHwnd();
}
