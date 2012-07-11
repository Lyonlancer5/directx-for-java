package com.fourthskyinteractive.dx4j.d2d1.resources.geometry;
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
public class D2D1_POINT_2F extends StructObject {
	public D2D1_POINT_2F() {
		super();
	}
	public D2D1_POINT_2F(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	public D2D1_POINT_2F(float x, float y) {
		super();
		this.x(x).y(y);
	}
	@Field(0) 
	public float x() {
		return this.io.getFloatField(this, 0);
	}
	@Field(0) 
	public D2D1_POINT_2F x(float x) {
		this.io.setFloatField(this, 0, x);
		return this;
	}
	@Field(1) 
	public float y() {
		return this.io.getFloatField(this, 1);
	}
	@Field(1) 
	public D2D1_POINT_2F y(float y) {
		this.io.setFloatField(this, 1, y);
		return this;
	}
}
