package dx11.particlesgs;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;

import com.fourthskyinteractive.dx4j.d3dx10.D3DXVECTOR3;

public class PARTICLE_VERTEX extends StructObject {
	public PARTICLE_VERTEX() { super(); }
	public PARTICLE_VERTEX(Pointer<? extends StructObject> pointer) { super(pointer); }
	
	@Field(0) public D3DXVECTOR3 pos() { return this.io.getNativeObjectField(this, 0); }
	@Field(1) public D3DXVECTOR3 vel() { return this.io.getNativeObjectField(this, 1); }
	
	@Field(2) public float timer() { return this.io.getFloatField(this, 2); }
	@Field(2) public PARTICLE_VERTEX timer(float value) { this.io.setFloatField(this, 2, value); return this; }
	
	@Field(3) public int type() { return this.io.getIntField(this, 3); }
	@Field(3) public PARTICLE_VERTEX type(int value) { this.io.setIntField(this, 3, value); return this; }
}