package com.fourthskyinteractive.dx4j.d3d11.resources;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d3d11") 
public class D3D11_SUBRESOURCE_DATA extends StructObject {
	public D3D11_SUBRESOURCE_DATA() {
		super();
	}
	public D3D11_SUBRESOURCE_DATA(Pointer pointer) {
		super(pointer);
	}
	/// C type : const void*
	@Field(0) 
	public Pointer<? > pSysMem() {
		return this.io.getPointerField(this, 0);
	}
	/// C type : const void*
	@Field(0) 
	public D3D11_SUBRESOURCE_DATA pSysMem(Pointer<? > pSysMem) {
		this.io.setPointerField(this, 0, pSysMem);
		return this;
	}
	@Field(1) 
	public int SysMemPitch() {
		return this.io.getIntField(this, 1);
	}
	@Field(1) 
	public D3D11_SUBRESOURCE_DATA SysMemPitch(int SysMemPitch) {
		this.io.setIntField(this, 1, SysMemPitch);
		return this;
	}
	@Field(2) 
	public int SysMemSlicePitch() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public D3D11_SUBRESOURCE_DATA SysMemSlicePitch(int SysMemSlicePitch) {
		this.io.setIntField(this, 2, SysMemSlicePitch);
		return this;
	}
}
