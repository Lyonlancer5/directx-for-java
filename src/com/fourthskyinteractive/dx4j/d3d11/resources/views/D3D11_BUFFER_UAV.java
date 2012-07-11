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
public class D3D11_BUFFER_UAV extends StructObject {
	public D3D11_BUFFER_UAV() {
		super();
	}
	public D3D11_BUFFER_UAV(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	@Field(0) 
	public int FirstElement() {
		return this.io.getIntField(this, 0);
	}
	@Field(0) 
	public D3D11_BUFFER_UAV FirstElement(int FirstElement) {
		this.io.setIntField(this, 0, FirstElement);
		return this;
	}
	@Field(1) 
	public int NumElements() {
		return this.io.getIntField(this, 1);
	}
	@Field(1) 
	public D3D11_BUFFER_UAV NumElements(int NumElements) {
		this.io.setIntField(this, 1, NumElements);
		return this;
	}
	@Field(2) 
	public int Flags() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public D3D11_BUFFER_UAV Flags(int Flags) {
		this.io.setIntField(this, 2, Flags);
		return this;
	}
}
