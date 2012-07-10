package com.fourthskyinteractive.dx4j.d3d11.shader;
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
public class D3D11_CLASS_INSTANCE_DESC extends StructObject {
	public D3D11_CLASS_INSTANCE_DESC() {
		super();
	}
	public D3D11_CLASS_INSTANCE_DESC(Pointer pointer) {
		super(pointer);
	}
	@Field(0) 
	public int InstanceId() {
		return this.io.getIntField(this, 0);
	}
	@Field(0) 
	public D3D11_CLASS_INSTANCE_DESC InstanceId(int InstanceId) {
		this.io.setIntField(this, 0, InstanceId);
		return this;
	}
	@Field(1) 
	public int InstanceIndex() {
		return this.io.getIntField(this, 1);
	}
	@Field(1) 
	public D3D11_CLASS_INSTANCE_DESC InstanceIndex(int InstanceIndex) {
		this.io.setIntField(this, 1, InstanceIndex);
		return this;
	}
	@Field(2) 
	public int TypeId() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public D3D11_CLASS_INSTANCE_DESC TypeId(int TypeId) {
		this.io.setIntField(this, 2, TypeId);
		return this;
	}
	@Field(3) 
	public int ConstantBuffer() {
		return this.io.getIntField(this, 3);
	}
	@Field(3) 
	public D3D11_CLASS_INSTANCE_DESC ConstantBuffer(int ConstantBuffer) {
		this.io.setIntField(this, 3, ConstantBuffer);
		return this;
	}
	@Field(4) 
	public int BaseConstantBufferOffset() {
		return this.io.getIntField(this, 4);
	}
	@Field(4) 
	public D3D11_CLASS_INSTANCE_DESC BaseConstantBufferOffset(int BaseConstantBufferOffset) {
		this.io.setIntField(this, 4, BaseConstantBufferOffset);
		return this;
	}
	@Field(5) 
	public int BaseTexture() {
		return this.io.getIntField(this, 5);
	}
	@Field(5) 
	public D3D11_CLASS_INSTANCE_DESC BaseTexture(int BaseTexture) {
		this.io.setIntField(this, 5, BaseTexture);
		return this;
	}
	@Field(6) 
	public int BaseSampler() {
		return this.io.getIntField(this, 6);
	}
	@Field(6) 
	public D3D11_CLASS_INSTANCE_DESC BaseSampler(int BaseSampler) {
		this.io.setIntField(this, 6, BaseSampler);
		return this;
	}
	@Field(7) 
	public int Created() {
		return this.io.getIntField(this, 7);
	}
	@Field(7) 
	public D3D11_CLASS_INSTANCE_DESC Created(int Created) {
		this.io.setIntField(this, 7, Created);
		return this;
	}
}
