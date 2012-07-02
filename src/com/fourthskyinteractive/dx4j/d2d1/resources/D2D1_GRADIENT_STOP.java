package com.fourthskyinteractive.dx4j.d2d1.resources;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

import com.fourthskyinteractive.dx4j.d2d1.resources.geometry.D2D1_COLOR_F;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d2d1") 
public class D2D1_GRADIENT_STOP extends StructObject {
	public D2D1_GRADIENT_STOP() {
		super();
	}
	public D2D1_GRADIENT_STOP(Pointer pointer) {
		super(pointer);
	}
	@Field(0) 
	public float position() {
		return this.io.getFloatField(this, 0);
	}
	@Field(0) 
	public D2D1_GRADIENT_STOP position(float position) {
		this.io.setFloatField(this, 0, position);
		return this;
	}
	/// C type : D2D1_COLOR_F
	@Field(1) 
	public D2D1_COLOR_F color() {
		return this.io.getNativeObjectField(this, 1);
	}
	/// C type : D2D1_COLOR_F
	@Field(1) 
	public D2D1_GRADIENT_STOP color(D2D1_COLOR_F color) {
		this.io.setNativeObjectField(this, 1, color);
		return this;
	}
}