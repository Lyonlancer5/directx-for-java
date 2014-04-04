package com.fourthskyinteractive.dx4j.dxgi.adapter;

import com.fourthskyinteractive.dx4j.windows.POINT;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.cpp.com.RECT;

/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("dxgi")
public class DXGI_OUTDUPL_MOVE_RECT extends StructObject {
    /** C type : POINT */
    @Field(0)
    public POINT SourcePoint() {
        return this.io.getNativeObjectField(this, 0);
    }
    /** C type : POINT */
    @Field(0)
    public DXGI_OUTDUPL_MOVE_RECT SourcePoint(POINT SourcePoint) {
        this.io.setNativeObjectField(this, 0, SourcePoint);
        return this;
    }
    /** C type : RECT */
    @Field(1)
    public RECT DestinationRect() {
        return this.io.getNativeObjectField(this, 1);
    }
    /** C type : RECT */
    @Field(1)
    public DXGI_OUTDUPL_MOVE_RECT DestinationRect(RECT DestinationRect) {
        this.io.setNativeObjectField(this, 1, DestinationRect);
        return this;
    }
    public DXGI_OUTDUPL_MOVE_RECT() {
        super();
    }
    @SuppressWarnings("unchecked")
	public DXGI_OUTDUPL_MOVE_RECT(@SuppressWarnings("rawtypes") Pointer pointer) {
        super(pointer);
    }
}
