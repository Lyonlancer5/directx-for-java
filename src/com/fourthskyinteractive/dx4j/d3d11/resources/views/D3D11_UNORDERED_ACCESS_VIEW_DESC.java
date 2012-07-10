package com.fourthskyinteractive.dx4j.d3d11.resources.views;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ValuedEnum;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_UAV_DIMENSION;
import com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d3d11") 
public class D3D11_UNORDERED_ACCESS_VIEW_DESC extends StructObject {
	public D3D11_UNORDERED_ACCESS_VIEW_DESC() {
		super();
	}
	public D3D11_UNORDERED_ACCESS_VIEW_DESC(Pointer pointer) {
		super(pointer);
	}
	/// C type : DXGI_FORMAT
	@Field(0) 
	public ValuedEnum<DXGI_FORMAT > Format() {
		return this.io.getEnumField(this, 0);
	}
	/// C type : DXGI_FORMAT
	@Field(0) 
	public D3D11_UNORDERED_ACCESS_VIEW_DESC Format(ValuedEnum<DXGI_FORMAT > Format) {
		this.io.setEnumField(this, 0, Format);
		return this;
	}
	/// C type : D3D11_UAV_DIMENSION
	@Field(1) 
	public ValuedEnum<D3D11_UAV_DIMENSION > ViewDimension() {
		return this.io.getEnumField(this, 1);
	}
	/// C type : D3D11_UAV_DIMENSION
	@Field(1) 
	public D3D11_UNORDERED_ACCESS_VIEW_DESC ViewDimension(ValuedEnum<D3D11_UAV_DIMENSION > ViewDimension) {
		this.io.setEnumField(this, 1, ViewDimension);
		return this;
	}
	
	@Field(2) 
	public D3D11_BUFFER_UAV Buffer(){
    	return this.io.getNativeObjectField(this, 2);
	}
    
	@Field(value = 3, unionWith = 2) 
	public D3D11_TEX1D_UAV Texture1D(){
    	return this.io.getNativeObjectField(this, 3);
	}
    
	@Field(value = 4, unionWith = 2) 
	public D3D11_TEX1D_ARRAY_UAV Texture1DArray(){
    	return this.io.getNativeObjectField(this, 4);
	}
    
	@Field(value = 5, unionWith = 2) 
	public D3D11_TEX2D_UAV Texture2D(){
    	return this.io.getNativeObjectField(this, 5);
	}
    
	@Field(value = 6, unionWith = 2) 
	public D3D11_TEX2D_ARRAY_UAV Texture2DArray(){
    	return this.io.getNativeObjectField(this, 6);
	}
    
	@Field(value = 7, unionWith = 2) 
	public D3D11_TEX3D_UAV Texture3D(){
    	return this.io.getNativeObjectField(this, 7);
	}

}
