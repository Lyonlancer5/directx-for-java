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
public class D3DBOX extends StructObject {
	public D3DBOX() {
		super();
	}
	public D3DBOX(Pointer<? extends StructObject> pointer) {
		super(pointer);
	}
	@Field(0) 
	public int Left() {
		return this.io.getIntField(this, 0);
	}
	@Field(0) 
	public D3DBOX Left(int Left) {
		this.io.setIntField(this, 0, Left);
		return this;
	}
	@Field(1) 
	public int Top() {
		return this.io.getIntField(this, 1);
	}
	@Field(1) 
	public D3DBOX Top(int Top) {
		this.io.setIntField(this, 1, Top);
		return this;
	}
	@Field(2) 
	public int Right() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public D3DBOX Right(int Right) {
		this.io.setIntField(this, 2, Right);
		return this;
	}
	@Field(3) 
	public int Bottom() {
		return this.io.getIntField(this, 3);
	}
	@Field(3) 
	public D3DBOX Bottom(int Bottom) {
		this.io.setIntField(this, 3, Bottom);
		return this;
	}
	@Field(4) 
	public int Front() {
		return this.io.getIntField(this, 4);
	}
	@Field(4) 
	public D3DBOX Front(int Front) {
		this.io.setIntField(this, 4, Front);
		return this;
	}
	@Field(5) 
	public int Back() {
		return this.io.getIntField(this, 5);
	}
	@Field(5) 
	public D3DBOX Back(int Back) {
		this.io.setIntField(this, 5, Back);
		return this;
	}
}
