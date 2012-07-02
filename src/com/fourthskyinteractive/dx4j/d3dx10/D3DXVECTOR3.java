package com.fourthskyinteractive.dx4j.d3dx10;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;

public class D3DXVECTOR3 extends StructObject {

	public D3DXVECTOR3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public D3DXVECTOR3(Pointer<? extends StructObject> peer) {
		super(peer);
		// TODO Auto-generated constructor stub
	}

	public D3DXVECTOR3(float x, float y, float z) {
		super();
		x(x).y(y).z(z);
	}
	
	@Field(0)
	public float x() {
		return this.io.getFloatField(this, 0);
	}
	
	@Field(0)
	public D3DXVECTOR3 x(float x) {
		this.io.setFloatField(this, 0, x);
		return this;
	}
	
	@Field(1)
	public float y() {
		return this.io.getFloatField(this, 1);
	}
	
	@Field(1)
	public D3DXVECTOR3 y(float y) {
		this.io.setFloatField(this, 1, y);
		return this;
	}
	
	@Field(2)
	public float z() {
		return this.io.getFloatField(this, 2);
	}
	
	@Field(2)
	public D3DXVECTOR3 z(float z) {
		this.io.setFloatField(this, 2, z);
		return this;
	}
}
