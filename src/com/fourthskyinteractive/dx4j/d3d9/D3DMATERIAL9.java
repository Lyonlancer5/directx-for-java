package com.fourthskyinteractive.dx4j.d3d9;
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
public class D3DMATERIAL9 extends StructObject {
	public D3DMATERIAL9() {
		super();
	}
	public D3DMATERIAL9(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	/// C type : D3DCOLORVALUE
	@Field(0) 
	public D3DCOLORVALUE Diffuse() {
		return this.io.getNativeObjectField(this, 0);
	}
	/// C type : D3DCOLORVALUE
	@Field(1) 
	public D3DCOLORVALUE Ambient() {
		return this.io.getNativeObjectField(this, 1);
	}
	/// C type : D3DCOLORVALUE
	@Field(2) 
	public D3DCOLORVALUE Specular() {
		return this.io.getNativeObjectField(this, 2);
	}
	/// C type : D3DCOLORVALUE
	@Field(3) 
	public D3DCOLORVALUE Emissive() {
		return this.io.getNativeObjectField(this, 3);
	}
	@Field(4) 
	public float Power() {
		return this.io.getFloatField(this, 4);
	}
	@Field(4) 
	public D3DMATERIAL9 Power(float Power) {
		this.io.setFloatField(this, 4, Power);
		return this;
	}
}
