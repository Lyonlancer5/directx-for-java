package dx11.particlesgs;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;

import com.fourthskyinteractive.dx4j.d3dx10.D3DXMATRIX;
import com.fourthskyinteractive.dx4j.d3dx10.D3DXVECTOR4;

public class CB extends StructObject {
	public CB() { super(); }
	public CB(Pointer<? extends StructObject> pointer) { super(pointer); }
	
	@Field(0) public D3DXMATRIX worldViewProj() { return this.io.getNativeObjectField(this, 0); }
	@Field(0) public CB worldViewProj(D3DXMATRIX value) { this.io.setNativeObjectField(this, 0, value); return this; }
	
	@Field(1) public D3DXMATRIX inverseViewMatrix() { return this.io.getNativeObjectField(this, 1); }
	@Field(1) public CB inverseViewMatrix(D3DXMATRIX value) { this.io.setNativeObjectField(this, 1, value); return this; }
	
	@Field(2) public float globalTime() { return this.io.getFloatField(this, 2); }
	@Field(2) public CB globalTime(float value) { this.io.setFloatField(this, 2, value); return this; }
	
	@Field(3) public float elapsedTime() { return this.io.getFloatField(this, 3); }
	@Field(3) public CB elapsedTime(float value) { this.io.setFloatField(this, 3, value); return this; }
	
	@Field(4) public D3DXVECTOR4 frameGravity() { return this.io.getNativeObjectField(this, 4); } 
	@Field(4) public CB frameGravity(D3DXVECTOR4 value) { this.io.setNativeObjectField(this, 4, value); return this; }
	
	@Field(5) public float secondsPerFirework() { return this.io.getFloatField(this, 5); }
	@Field(5) public CB secondsPerFirework(float value) { this.io.setFloatField(this, 5, value); return this; }
	
	@Field(6) public int numEmber1s() { return this.io.getIntField(this, 6); }
	@Field(6) public CB numEmber1s(int value) { this.io.setIntField(this, 6, value); return this; }
	
	@Field(7) public float numEmber2s() { return this.io.getFloatField(this, 7); }
	@Field(7) public CB numEmber2s(float value) { this.io.setFloatField(this, 7, value); return this; }		
}
