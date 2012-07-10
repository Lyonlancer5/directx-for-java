package com.fourthskyinteractive.dx4j.d2d1.resources.rendertarget;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ValuedEnum;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

import com.fourthskyinteractive.dx4j.d2d1.D2D1;
import com.fourthskyinteractive.dx4j.d2d1.D2D1.D2D1_FEATURE_LEVEL;
import com.fourthskyinteractive.dx4j.d2d1.D2D1.D2D1_RENDER_TARGET_TYPE;
import com.fourthskyinteractive.dx4j.d2d1.D2D1.D2D1_RENDER_TARGET_USAGE;
import com.fourthskyinteractive.dx4j.d2d1.core.D2D1_PIXEL_FORMAT;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d2d1") 
public class D2D1_RENDER_TARGET_PROPERTIES extends StructObject {
	public D2D1_RENDER_TARGET_PROPERTIES() {
		super();
	}
	public D2D1_RENDER_TARGET_PROPERTIES(Pointer pointer) {
		super(pointer);
	}
	
	public D2D1_RENDER_TARGET_PROPERTIES(ValuedEnum<D2D1_RENDER_TARGET_TYPE > type) {
		super();
	}
		
	
	/// C type : D2D1_RENDER_TARGET_TYPE
	@Field(0) 
	public ValuedEnum<D2D1_RENDER_TARGET_TYPE > type() {
		return this.io.getEnumField(this, 0);
	}
	/// C type : D2D1_RENDER_TARGET_TYPE
	@Field(0) 
	public D2D1_RENDER_TARGET_PROPERTIES type(ValuedEnum<D2D1_RENDER_TARGET_TYPE > type) {
		this.io.setEnumField(this, 0, type);
		return this;
	}
	/// C type : D2D1_PIXEL_FORMAT
	@Field(1) 
	public D2D1_PIXEL_FORMAT pixelFormat() {
		return this.io.getNativeObjectField(this, 1);
	}
	@Field(2) 
	public float dpiX() {
		return this.io.getFloatField(this, 2);
	}
	@Field(2) 
	public D2D1_RENDER_TARGET_PROPERTIES dpiX(float dpiX) {
		this.io.setFloatField(this, 2, dpiX);
		return this;
	}
	@Field(3) 
	public float dpiY() {
		return this.io.getFloatField(this, 3);
	}
	@Field(3) 
	public D2D1_RENDER_TARGET_PROPERTIES dpiY(float dpiY) {
		this.io.setFloatField(this, 3, dpiY);
		return this;
	}
	/// C type : D2D1_RENDER_TARGET_USAGE
	@Field(4) 
	public ValuedEnum<D2D1_RENDER_TARGET_USAGE > usage() {
		return this.io.getEnumField(this, 4);
	}
	/// C type : D2D1_RENDER_TARGET_USAGE
	@Field(4) 
	public D2D1_RENDER_TARGET_PROPERTIES usage(ValuedEnum<D2D1_RENDER_TARGET_USAGE > usage) {
		this.io.setEnumField(this, 4, usage);
		return this;
	}
	/// C type : D2D1_FEATURE_LEVEL
	@Field(5) 
	public ValuedEnum<D2D1_FEATURE_LEVEL > minLevel() {
		return this.io.getEnumField(this, 5);
	}
	/// C type : D2D1_FEATURE_LEVEL
	@Field(5) 
	public D2D1_RENDER_TARGET_PROPERTIES minLevel(ValuedEnum<D2D1_FEATURE_LEVEL > minLevel) {
		this.io.setEnumField(this, 5, minLevel);
		return this;
	}
}
