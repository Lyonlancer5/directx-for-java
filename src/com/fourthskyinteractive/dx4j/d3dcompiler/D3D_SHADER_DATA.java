package com.fourthskyinteractive.dx4j.d3dcompiler;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.CLong;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("d3dcompiler") 
public class D3D_SHADER_DATA extends StructObject {
	public D3D_SHADER_DATA() {
		super();
	}
	public D3D_SHADER_DATA(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	/// C type : LPCVOID
	@Field(0) 
	public Pointer<? > pBytecode() {
		return this.io.getPointerField(this, 0);
	}
	/// C type : LPCVOID
	@Field(0) 
	public D3D_SHADER_DATA pBytecode(Pointer<? > pBytecode) {
		this.io.setPointerField(this, 0, pBytecode);
		return this;
	}
	/// C type : SIZE_T
	@CLong 
	@Field(1) 
	public long BytecodeLength() {
		return this.io.getSizeTField(this, 1);
	}
	/// C type : SIZE_T
	@CLong 
	@Field(1) 
	public D3D_SHADER_DATA BytecodeLength(long BytecodeLength) {
		this.io.setSizeTField(this, 1, BytecodeLength);
		return this;
	}
}
