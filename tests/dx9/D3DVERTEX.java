package dx9;

import org.bridj.StructObject;
import org.bridj.ann.Field;

/**
 * Created with IntelliJ IDEA.
 * User: evandro.paulino
 * Date: 19/06/13
 * Time: 08:16
 * To change this template use File | Settings | File Templates.
 */
public class D3DVERTEX extends StructObject {
    public D3DVERTEX() {}
    //public D3DVERTEX(Pointer<? extends StructObject> peer) { super(peer); }

    @Field(0) public float x() { return this.io.getFloatField(this, 0); }
    @Field(0) public D3DVERTEX x(float x) { this.io.setFloatField(this, 0, x); return this; }
    @Field(1) public float y() { return this.io.getFloatField(this, 1); }
    @Field(1) public D3DVERTEX y(float y) { this.io.setFloatField(this, 1, y); return this; }
    @Field(2) public float z() { return this.io.getFloatField(this, 2); }
    @Field(2) public D3DVERTEX z(float z) { this.io.setFloatField(this, 2, z); return this; }
    @Field(3) public float rhw() { return this.io.getFloatField(this, 3); }
    @Field(3) public D3DVERTEX rhw(float rhw) { this.io.setFloatField(this, 3, rhw); return this; }
    @Field(4) public int color() { return this.io.getIntField(this, 4); }
    @Field(4) public D3DVERTEX color(int color) { this.io.setIntField(this, 4, color); return this; }
}
