package com.fourthskyinteractive.dx4j.dxgi.adapter;

import com.fourthskyinteractive.dx4j.windows.POINT;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("DXGI")
public class DXGI_OUTDUPL_POINTER_SHAPE_INFO extends StructObject {
    @Field(0)
    public int Type() {
        return this.io.getIntField(this, 0);
    }
    @Field(0)
    public DXGI_OUTDUPL_POINTER_SHAPE_INFO Type(int Type) {
        this.io.setIntField(this, 0, Type);
        return this;
    }
    @Field(1)
    public int Width() {
        return this.io.getIntField(this, 1);
    }
    @Field(1)
    public DXGI_OUTDUPL_POINTER_SHAPE_INFO Width(int Width) {
        this.io.setIntField(this, 1, Width);
        return this;
    }
    @Field(2)
    public int Height() {
        return this.io.getIntField(this, 2);
    }
    @Field(2)
    public DXGI_OUTDUPL_POINTER_SHAPE_INFO Height(int Height) {
        this.io.setIntField(this, 2, Height);
        return this;
    }
    @Field(3)
    public int Pitch() {
        return this.io.getIntField(this, 3);
    }
    @Field(3)
    public DXGI_OUTDUPL_POINTER_SHAPE_INFO Pitch(int Pitch) {
        this.io.setIntField(this, 3, Pitch);
        return this;
    }
    /** C type : POINT */
    @Field(4)
    public POINT HotSpot() {
        return this.io.getNativeObjectField(this, 4);
    }
    /** C type : POINT */
    @Field(4)
    public DXGI_OUTDUPL_POINTER_SHAPE_INFO HotSpot(POINT HotSpot) {
        this.io.setNativeObjectField(this, 4, HotSpot);
        return this;
    }
    public DXGI_OUTDUPL_POINTER_SHAPE_INFO() {
        super();
    }
    public DXGI_OUTDUPL_POINTER_SHAPE_INFO(Pointer pointer) {
        super(pointer);
    }
}
