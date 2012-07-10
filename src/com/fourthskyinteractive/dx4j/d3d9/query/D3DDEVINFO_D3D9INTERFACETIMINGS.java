package com.fourthskyinteractive.dx4j.d3d9.query;
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
public class D3DDEVINFO_D3D9INTERFACETIMINGS extends StructObject {
	public D3DDEVINFO_D3D9INTERFACETIMINGS() {
		super();
	}
	public D3DDEVINFO_D3D9INTERFACETIMINGS(Pointer pointer) {
		super(pointer);
	}
	@Field(0) 
	public float WaitingForGPUToUseApplicationResourceTimePercent() {
		return this.io.getFloatField(this, 0);
	}
	@Field(0) 
	public D3DDEVINFO_D3D9INTERFACETIMINGS WaitingForGPUToUseApplicationResourceTimePercent(float WaitingForGPUToUseApplicationResourceTimePercent) {
		this.io.setFloatField(this, 0, WaitingForGPUToUseApplicationResourceTimePercent);
		return this;
	}
	@Field(1) 
	public float WaitingForGPUToAcceptMoreCommandsTimePercent() {
		return this.io.getFloatField(this, 1);
	}
	@Field(1) 
	public D3DDEVINFO_D3D9INTERFACETIMINGS WaitingForGPUToAcceptMoreCommandsTimePercent(float WaitingForGPUToAcceptMoreCommandsTimePercent) {
		this.io.setFloatField(this, 1, WaitingForGPUToAcceptMoreCommandsTimePercent);
		return this;
	}
	@Field(2) 
	public float WaitingForGPUToStayWithinLatencyTimePercent() {
		return this.io.getFloatField(this, 2);
	}
	@Field(2) 
	public D3DDEVINFO_D3D9INTERFACETIMINGS WaitingForGPUToStayWithinLatencyTimePercent(float WaitingForGPUToStayWithinLatencyTimePercent) {
		this.io.setFloatField(this, 2, WaitingForGPUToStayWithinLatencyTimePercent);
		return this;
	}
	@Field(3) 
	public float WaitingForGPUExclusiveResourceTimePercent() {
		return this.io.getFloatField(this, 3);
	}
	@Field(3) 
	public D3DDEVINFO_D3D9INTERFACETIMINGS WaitingForGPUExclusiveResourceTimePercent(float WaitingForGPUExclusiveResourceTimePercent) {
		this.io.setFloatField(this, 3, WaitingForGPUExclusiveResourceTimePercent);
		return this;
	}
	@Field(4) 
	public float WaitingForGPUOtherTimePercent() {
		return this.io.getFloatField(this, 4);
	}
	@Field(4) 
	public D3DDEVINFO_D3D9INTERFACETIMINGS WaitingForGPUOtherTimePercent(float WaitingForGPUOtherTimePercent) {
		this.io.setFloatField(this, 4, WaitingForGPUOtherTimePercent);
		return this;
	}
}
