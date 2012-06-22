package com.fourthskyinteractive.dx4j.d2d1;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d2d1") 
public class D2D1_BITMAP_PROPERTIES extends StructObject {
	public D2D1_BITMAP_PROPERTIES() {
		super();
	}
	public D2D1_BITMAP_PROPERTIES(Pointer pointer) {
		super(pointer);
	}
	/// C type : D2D1_PIXEL_FORMAT
	@Field(0) 
	public D2D1_PIXEL_FORMAT pixelFormat() {
		return this.io.getNativeObjectField(this, 0);
	}
	@Field(1) 
	public float dpiX() {
		return this.io.getFloatField(this, 1);
	}
	@Field(1) 
	public D2D1_BITMAP_PROPERTIES dpiX(float dpiX) {
		this.io.setFloatField(this, 1, dpiX);
		return this;
	}
	@Field(2) 
	public float dpiY() {
		return this.io.getFloatField(this, 2);
	}
	@Field(2) 
	public D2D1_BITMAP_PROPERTIES dpiY(float dpiY) {
		this.io.setFloatField(this, 2, dpiY);
		return this;
	}
}
