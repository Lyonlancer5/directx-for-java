package com.fourthskyinteractive.dx4j.windows.kernel32;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;

public class SECURITY_ATTRIBUTES extends StructObject {

	public SECURITY_ATTRIBUTES() {
		// TODO Auto-generated constructor stub
	}

	public SECURITY_ATTRIBUTES(Pointer<? extends StructObject> peer) {
		super(peer);
		// TODO Auto-generated constructor stub
	}

	@Field(0)
	public int  nLength() {
		return this.io.getIntField(this, 0);
	}
	@Field(0)
	public SECURITY_ATTRIBUTES nLength(int nLength) {
		this.io.setIntField(this, 0, nLength);
		return this;		
	}
	
	@Field(1)
	public Pointer<?> lpSecurityDescriptor() {
		return this.io.getPointerField(this, 1);
	}
	@Field(1)
	public SECURITY_ATTRIBUTES lpSecurityDescriptor(int lpSecurityDescriptor) {
		this.io.setIntField(this, 1, lpSecurityDescriptor);
		return this;		
	}
	
	@Field(2)
	public int bInheritHandle() {
		return this.io.getIntField(this, 2);
	}
	@Field(2)
	public SECURITY_ATTRIBUTES bInheritHandle(int bInheritHandle) {
		this.io.setIntField(this, 2, bInheritHandle);
		return this;		
	}
}
