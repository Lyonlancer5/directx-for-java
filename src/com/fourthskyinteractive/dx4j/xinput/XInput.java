package com.fourthskyinteractive.dx4j.xinput;

import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.cpp.com.COMRuntime;

@Runtime(COMRuntime.class)
@Library("XInput1_3")
public class XInput {
	static {
		BridJ.register();
	}
	
	// Button constants 
	private static final int XINPUT_GAMEPAD_DPAD_UP         = 0x00000001;
	private static final int XINPUT_GAMEPAD_DPAD_DOWN       = 0x00000002;
	private static final int XINPUT_GAMEPAD_DPAD_LEFT       = 0x00000004;
	private static final int XINPUT_GAMEPAD_DPAD_RIGHT      = 0x00000008;
	private static final int XINPUT_GAMEPAD_START           = 0x00000010;
	private static final int XINPUT_GAMEPAD_BACK            = 0x00000020;
	private static final int XINPUT_GAMEPAD_LEFT_THUMB      = 0x00000040;
	private static final int XINPUT_GAMEPAD_RIGHT_THUMB     = 0x00000080;
	private static final int XINPUT_GAMEPAD_LEFT_SHOULDER   = 0x0100;
	private static final int XINPUT_GAMEPAD_RIGHT_SHOULDER  = 0x0200;
	private static final int XINPUT_GAMEPAD_A               = 0x1000;
	private static final int XINPUT_GAMEPAD_B               = 0x2000;
	private static final int XINPUT_GAMEPAD_X               = 0x4000;
	private static final int XINPUT_GAMEPAD_Y               = 0x8000;
	
	public static native void XInputEnable(int enable);
	
	public static native short XInputSetState(short dwUserIndex, Pointer<XINPUT_VIBRATION> pVibration);
}
