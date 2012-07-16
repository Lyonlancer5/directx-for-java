package com.fourthskyinteractive.dx4j.d3d9.core;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ValuedEnum;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

import com.fourthskyinteractive.dx4j.d3d9.D3D9;
import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DBASISTYPE;
import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DDEGREETYPE;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d3d9") 
public class D3DRECTPATCH_INFO extends StructObject {
	public D3DRECTPATCH_INFO() {
		super();
	}
	public D3DRECTPATCH_INFO(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	@Field(0) 
	public int StartVertexOffsetWidth() {
		return this.io.getIntField(this, 0);
	}
	@Field(0) 
	public D3DRECTPATCH_INFO StartVertexOffsetWidth(int StartVertexOffsetWidth) {
		this.io.setIntField(this, 0, StartVertexOffsetWidth);
		return this;
	}
	@Field(1) 
	public int StartVertexOffsetHeight() {
		return this.io.getIntField(this, 1);
	}
	@Field(1) 
	public D3DRECTPATCH_INFO StartVertexOffsetHeight(int StartVertexOffsetHeight) {
		this.io.setIntField(this, 1, StartVertexOffsetHeight);
		return this;
	}
	@Field(2) 
	public int Width() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public D3DRECTPATCH_INFO Width(int Width) {
		this.io.setIntField(this, 2, Width);
		return this;
	}
	@Field(3) 
	public int Height() {
		return this.io.getIntField(this, 3);
	}
	@Field(3) 
	public D3DRECTPATCH_INFO Height(int Height) {
		this.io.setIntField(this, 3, Height);
		return this;
	}
	@Field(4) 
	public int Stride() {
		return this.io.getIntField(this, 4);
	}
	@Field(4) 
	public D3DRECTPATCH_INFO Stride(int Stride) {
		this.io.setIntField(this, 4, Stride);
		return this;
	}
	/// C type : D3DBASISTYPE
	@Field(5) 
	public ValuedEnum<D3DBASISTYPE > Basis() {
		return this.io.getEnumField(this, 5);
	}
	/// C type : D3DBASISTYPE
	@Field(5) 
	public D3DRECTPATCH_INFO Basis(ValuedEnum<D3DBASISTYPE > Basis) {
		this.io.setEnumField(this, 5, Basis);
		return this;
	}
	/// C type : D3DDEGREETYPE
	@Field(6) 
	public ValuedEnum<D3DDEGREETYPE > Degree() {
		return this.io.getEnumField(this, 6);
	}
	/// C type : D3DDEGREETYPE
	@Field(6) 
	public D3DRECTPATCH_INFO Degree(ValuedEnum<D3DDEGREETYPE > Degree) {
		this.io.setEnumField(this, 6, Degree);
		return this;
	}
}