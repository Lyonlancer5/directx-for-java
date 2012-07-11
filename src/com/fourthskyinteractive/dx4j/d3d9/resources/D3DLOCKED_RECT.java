package com.fourthskyinteractive.dx4j.d3d9.resources;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d3d9") 
public class D3DLOCKED_RECT extends StructObject {
	public D3DLOCKED_RECT() {
		super();
	}
	public D3DLOCKED_RECT(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	@Field(0) 
	public int Pitch() {
		return this.io.getIntField(this, 0);
	}
	@Field(0) 
	public D3DLOCKED_RECT Pitch(int Pitch) {
		this.io.setIntField(this, 0, Pitch);
		return this;
	}
	/// C type : void*
	@Field(1) 
	public Pointer<? > pBits() {
		return this.io.getPointerField(this, 1);
	}
	/// C type : void*
	@Field(1) 
	public D3DLOCKED_RECT pBits(Pointer<? > pBits) {
		this.io.setPointerField(this, 1, pBits);
		return this;
	}
}
