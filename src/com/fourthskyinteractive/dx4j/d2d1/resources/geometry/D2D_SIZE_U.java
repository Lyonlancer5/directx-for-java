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
public class D2D_SIZE_U extends StructObject {
	public D2D_SIZE_U() {
		super();
	}
	public D2D_SIZE_U(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	/// C type : UINT32
	@Field(0) 
	public int width() {
		return this.io.getIntField(this, 0);
	}
	/// C type : UINT32
	@Field(0) 
	public D2D_SIZE_U width(int width) {
		this.io.setIntField(this, 0, width);
		return this;
	}
	/// C type : UINT32
	@Field(1) 
	public int height() {
		return this.io.getIntField(this, 1);
	}
	/// C type : UINT32
	@Field(1) 
	public D2D_SIZE_U height(int height) {
		this.io.setIntField(this, 1, height);
		return this;
	}
}
