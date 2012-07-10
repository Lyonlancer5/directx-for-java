package com.fourthskyinteractive.dx4j.d3d11.core;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ValuedEnum;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

import com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d3d11") 
public class D3D11_FEATURE_DATA_FORMAT_SUPPORT2 extends StructObject {
	public D3D11_FEATURE_DATA_FORMAT_SUPPORT2() {
		super();
	}
	public D3D11_FEATURE_DATA_FORMAT_SUPPORT2(Pointer pointer) {
		super(pointer);
	}
	/// C type : DXGI_FORMAT
	@Field(0) 
	public ValuedEnum<DXGI_FORMAT > InFormat() {
		return this.io.getEnumField(this, 0);
	}
	/// C type : DXGI_FORMAT
	@Field(0) 
	public D3D11_FEATURE_DATA_FORMAT_SUPPORT2 InFormat(ValuedEnum<DXGI_FORMAT > InFormat) {
		this.io.setEnumField(this, 0, InFormat);
		return this;
	}
	@Field(1) 
	public int OutFormatSupport2() {
		return this.io.getIntField(this, 1);
	}
	@Field(1) 
	public D3D11_FEATURE_DATA_FORMAT_SUPPORT2 OutFormatSupport2(int OutFormatSupport2) {
		this.io.setIntField(this, 1, OutFormatSupport2);
		return this;
	}
}
