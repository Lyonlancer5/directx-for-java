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
public class D2D1_QUADRATIC_BEZIER_SEGMENT extends StructObject {
	public D2D1_QUADRATIC_BEZIER_SEGMENT() {
		super();
	}
	public D2D1_QUADRATIC_BEZIER_SEGMENT(Pointer pointer) {
		super(pointer);
	}
	/// C type : D2D1_POINT_2F
	@Field(0) 
	public D2D1_POINT_2F point1() {
		return this.io.getNativeObjectField(this, 0);
	}
	/// C type : D2D1_POINT_2F
	@Field(1) 
	public D2D1_POINT_2F point2() {
		return this.io.getNativeObjectField(this, 1);
	}
}
