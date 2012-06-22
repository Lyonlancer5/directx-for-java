package com.fourthskyinteractive.dx4j.dxgi;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ValuedEnum;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

import com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_SWAP_EFFECT;
import com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_USAGE;
import com.fourthskyinteractive.dx4j.windows.HWND;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("dxgi") 
public class DXGI_SWAP_CHAIN_DESC extends StructObject {
	public DXGI_SWAP_CHAIN_DESC() {
		super();
	}
	public DXGI_SWAP_CHAIN_DESC(Pointer pointer) {
		super(pointer);
	}
	/// C type : DXGI_MODE_DESC
	@Field(0) 
	public DXGI_MODE_DESC BufferDesc() {
		return this.io.getNativeObjectField(this, 0);
	}
	/// C type : DXGI_SAMPLE_DESC
	@Field(1) 
	public DXGI_SAMPLE_DESC SampleDesc() {
		return this.io.getNativeObjectField(this, 1);
	}
	@Field(2)
	public ValuedEnum<DXGI_USAGE> BufferUsage() {
		return this.io.getEnumField(this, 2);
	}
	@Field(2) 
	public DXGI_SWAP_CHAIN_DESC BufferUsage(DXGI_USAGE BufferUsage) {
		this.io.setEnumField(this, 2, BufferUsage);
		return this;
	}
	@Field(3) 
	public int BufferCount() {
		return this.io.getIntField(this, 3);
	}
	@Field(3) 
	public DXGI_SWAP_CHAIN_DESC BufferCount(int BufferCount) {
		this.io.setIntField(this, 3, BufferCount);
		return this;
	}
	/// C type : HWND
	@Field(4) 
	public HWND OutputWindow() {
		return this.io.getTypedPointerField(this, 4);
	}
	/// C type : HWND
	@Field(4) 
	public DXGI_SWAP_CHAIN_DESC OutputWindow(HWND OutputWindow) {
		this.io.setPointerField(this, 4, OutputWindow);
		return this;
	}
	@Field(5) 
	public int Windowed() {
		return this.io.getIntField(this, 5);
	}
	@Field(5) 
	public DXGI_SWAP_CHAIN_DESC Windowed(int Windowed) {
		this.io.setIntField(this, 5, Windowed);
		return this;
	}
	@Field(6)
	public ValuedEnum<DXGI_SWAP_EFFECT> SwapEffect() {
		return this.io.getEnumField(this, 6);
	}
	@Field(6) 
	public DXGI_SWAP_CHAIN_DESC SwapEffect(DXGI_SWAP_EFFECT SwapEffect) {
		this.io.setEnumField(this, 6, SwapEffect);
		return this;
	}
	@Field(7) 
	public int Flags() {
		return this.io.getIntField(this, 7);
	}
	@Field(7) 
	public DXGI_SWAP_CHAIN_DESC Flags(int Flags) {
		this.io.setIntField(this, 7, Flags);
		return this;
	}
}
