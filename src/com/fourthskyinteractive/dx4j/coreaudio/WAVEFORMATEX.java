package com.fourthskyinteractive.dx4j.coreaudio;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

@Library("CoreAudio") 
public class WAVEFORMATEX extends StructObject {
	public WAVEFORMATEX() {
		super();
	}
	public WAVEFORMATEX(Pointer pointer) {
		super(pointer);
	}
	
	@Field(0) 
	public short wFormatTag() {
		return this.io.getShortField(this, 0);
	}
	@Field(0) 
	public WAVEFORMATEX wFormatTag(short wFormatTag) {
		this.io.setShortField(this, 0, wFormatTag);
		return this;
	}
	@Field(1) 
	public short nChannels() {
		return this.io.getShortField(this, 1);
	}
	@Field(1) 
	public WAVEFORMATEX nChannels(short nChannels) {
		this.io.setShortField(this, 1, nChannels);
		return this;
	}
	@Field(2) 
	public int nSamplesPerSec() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public WAVEFORMATEX nSamplesPerSec(int nSamplesPerSec) {
		this.io.setIntField(this, 2, nSamplesPerSec);
		return this;
	}
	@Field(3) 
	public int nAvgBytesPerSec() {
		return this.io.getIntField(this, 3);
	}
	@Field(3) 
	public WAVEFORMATEX nAvgBytesPerSec(int nAvgBytesPerSec) {
		this.io.setIntField(this, 3, nAvgBytesPerSec);
		return this;
	}
	@Field(4) 
	public short nBlockAlign() {
		return this.io.getShortField(this, 4);
	}
	@Field(4) 
	public WAVEFORMATEX nBlockAlign(short nBlockAlign) {
		this.io.setShortField(this, 4, nBlockAlign);
		return this;
	}
	@Field(5) 
	public short wBitsPerSample() {
		return this.io.getShortField(this, 5);
	}
	@Field(5) 
	public WAVEFORMATEX wBitsPerSample(short wBitsPerSample) {
		this.io.setShortField(this, 5, wBitsPerSample);
		return this;
	}
	@Field(6) 
	public short cbSize() {
		return this.io.getShortField(this, 6);
	}
	@Field(6) 
	public WAVEFORMATEX cbSize(short cbSize) {
		this.io.setShortField(this, 6, cbSize);
		return this;
	}
}