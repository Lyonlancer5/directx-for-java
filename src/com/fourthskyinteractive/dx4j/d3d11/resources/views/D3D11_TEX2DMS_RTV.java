package com.fourthskyinteractive.dx4j.d3d11.resources.views;
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
public class D3D11_TEX2DMS_RTV extends StructObject {
	public D3D11_TEX2DMS_RTV() {
		super();
	}
	public D3D11_TEX2DMS_RTV(Pointer pointer) {
		super(pointer);
	}
	@Field(0) 
	public int UnusedField_NothingToDefine() {
		return this.io.getIntField(this, 0);
	}
	@Field(0) 
	public D3D11_TEX2DMS_RTV UnusedField_NothingToDefine(int UnusedField_NothingToDefine) {
		this.io.setIntField(this, 0, UnusedField_NothingToDefine);
		return this;
	}
}
