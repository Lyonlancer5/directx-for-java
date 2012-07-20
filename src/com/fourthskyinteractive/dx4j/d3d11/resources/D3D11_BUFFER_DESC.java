package com.fourthskyinteractive.dx4j.d3d11.resources;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ValuedEnum;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BIND_FLAG;
import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_CPU_ACCESS_FLAG;
import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_RESOURCE_MISC_FLAG;
import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_USAGE;
/**
 * <i>native declaration : line 668</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d3d11") 
public class D3D11_BUFFER_DESC extends StructObject {
	public D3D11_BUFFER_DESC() {
		super();
	}
	public D3D11_BUFFER_DESC(ValuedEnum<D3D11_BIND_FLAG> bindFlag, ValuedEnum<D3D11_USAGE> usage,
			 ValuedEnum<D3D11_CPU_ACCESS_FLAG> cpuAccess, ValuedEnum<D3D11_RESOURCE_MISC_FLAG> flags, 
			 int byteWidth) {
		super();
		this.BindFlags(bindFlag).Usage(usage).CPUAccessFlags(cpuAccess)
		.MiscFlags(flags).ByteWidth(byteWidth).StructureByteStride(0);
	}
	public D3D11_BUFFER_DESC(ValuedEnum<D3D11_BIND_FLAG> bindFlag, ValuedEnum<D3D11_USAGE> usage,
							 ValuedEnum<D3D11_CPU_ACCESS_FLAG> cpuAccess, ValuedEnum<D3D11_RESOURCE_MISC_FLAG> flags, int byteWidth,
							 int byteStride) {
		super();
		this.BindFlags(bindFlag).Usage(usage).CPUAccessFlags(cpuAccess)
			.MiscFlags(flags).ByteWidth(byteWidth).StructureByteStride(byteStride);
	}
	public D3D11_BUFFER_DESC(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	@Field(0) 
	public int ByteWidth() {
		return this.io.getIntField(this, 0);
	}
	@Field(0) 
	public D3D11_BUFFER_DESC ByteWidth(int ByteWidth) {
		this.io.setIntField(this, 0, ByteWidth);
		return this;
	}
	/// C type : D3D11_USAGE
	@Field(1) 
	public ValuedEnum<D3D11_USAGE> Usage() {
		return this.io.getEnumField(this, 1);
	}
	/// C type : D3D11_USAGE
	@Field(1) 
	public D3D11_BUFFER_DESC Usage(ValuedEnum<D3D11_USAGE> Usage) {
		this.io.setEnumField(this, 1, Usage);
		return this;
	}
	@Field(2) 
	public ValuedEnum<D3D11_BIND_FLAG> BindFlags() {
		return this.io.getEnumField(this, 2);
	}
	@Field(2) 
	public D3D11_BUFFER_DESC BindFlags(ValuedEnum<D3D11_BIND_FLAG> BindFlags) {
		this.io.setEnumField(this, 2, BindFlags);
		return this;
	}
	@Field(3) 
	public ValuedEnum<D3D11_CPU_ACCESS_FLAG> CPUAccessFlags() {
		return this.io.getEnumField(this, 3);
	}
	@Field(3) 
	public D3D11_BUFFER_DESC CPUAccessFlags(ValuedEnum<D3D11_CPU_ACCESS_FLAG> CPUAccessFlags) {
		this.io.setEnumField(this, 3, CPUAccessFlags);
		return this;
	}
	@Field(4) 
	public ValuedEnum<D3D11_RESOURCE_MISC_FLAG> MiscFlags() {
		return this.io.getEnumField(this, 4);
	}
	@Field(4) 
	public D3D11_BUFFER_DESC MiscFlags(ValuedEnum<D3D11_RESOURCE_MISC_FLAG> MiscFlags) {
		this.io.setEnumField(this, 4, MiscFlags);
		return this;
	}
	@Field(5) 
	public int StructureByteStride() {
		return this.io.getIntField(this, 5);
	}
	@Field(5) 
	public D3D11_BUFFER_DESC StructureByteStride(int StructureByteStride) {
		this.io.setIntField(this, 5, StructureByteStride);
		return this;
	}
}
