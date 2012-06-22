package d3d9;

import static com.fourthskyinteractive.dx4j.d3d9.D3D9.*;
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DFORMAT.*;
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DSWAPEFFECT.*;
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DDEVTYPE.*;
import static org.bridj.BridJ.*;
import static org.bridj.Pointer.*;
import static org.junit.Assert.*;

import java.awt.Component;

import javax.swing.JFrame;

import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.jawt.JAWT;
import org.bridj.jawt.JAWTUtils;
import org.bridj.jawt.JAWTUtils.LockedComponentRunnable;
import org.bridj.jawt.JawtLibrary.JNIEnv;
import org.junit.Test;

import com.fourthskyinteractive.dx4j.d3d9.core.D3DADAPTER_IDENTIFIER9;
import com.fourthskyinteractive.dx4j.d3d9.core.D3DDISPLAYMODE;
import com.fourthskyinteractive.dx4j.d3d9.core.D3DPRESENT_PARAMETERS;
import com.fourthskyinteractive.dx4j.d3d9.core.IDirect3D9;
import com.fourthskyinteractive.dx4j.d3d9.core.IDirect3DDevice9;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DVertexBuffer9;
import com.fourthskyinteractive.dx4j.windows.HWND;

public class TestD3D9 {

	@Test
	public void testD3D9() throws Exception {
		Pointer<IDirect3D9> pD3D9 = Direct3DCreate9(D3D_SDK_VERSION);
		assertNotNull(pD3D9);

		IDirect3D9 d3d9 = pD3D9.get();
		assertNotNull(d3d9);

		int adapterCount = d3d9.GetAdapterCount();
		assertTrue(adapterCount > 0);

		D3DADAPTER_IDENTIFIER9 identifier = new D3DADAPTER_IDENTIFIER9();
		d3d9.GetAdapterIdentifier(0, 0, pointerTo(identifier));
		
		D3DDISPLAYMODE mode = new D3DDISPLAYMODE();
		d3d9.GetAdapterDisplayMode(D3DADAPTER_DEFAULT, pointerTo(mode));
			
		D3DPRESENT_PARAMETERS d3dpp = new D3DPRESENT_PARAMETERS();
		d3dpp.Windowed(1);
		d3dpp.SwapEffect(D3DSWAPEFFECT_DISCARD);
		d3dpp.BackBufferFormat(D3DFMT_UNKNOWN);
		d3dpp.PresentationInterval(D3DPRESENT_INTERVAL_ONE);

		// Create JFrame
		JFrame frame = new JFrame("Test D3D9");
		frame.setSize(800, 600);
		frame.setIgnoreRepaint(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		final IDirect3DDevice9 device = d3d9.CreateDevice(D3DADAPTER_DEFAULT, 
														  D3DDEVTYPE_HAL, 
														  new HWND(JAWTUtils.getNativePeerHandle(frame)), 
														  D3DCREATE_HARDWARE_VERTEXPROCESSING, 
														  d3dpp);
		assertNotNull(device);
		
		// Vertex structure
		class D3DVERTEX extends StructObject {
			public D3DVERTEX() {}
			public D3DVERTEX(Pointer<? extends StructObject> peer) { super(peer); }
			
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

		// Creating vertex buffer 
		final IDirect3DVertexBuffer9 vertexBuffer = device.CreateVertexBuffer((int)(3 * sizeOf(D3DVERTEX.class)), 0, D3DFVF_XYZRHW | D3DFVF_DIFFUSE, D3DPOOL.D3DPOOL_DEFAULT);
		
		// Copying data
		Pointer<Pointer<?>> lockedMem = allocatePointer();
		if (vertexBuffer.Lock(0, (int)(3 * BridJ.sizeOf(D3DVERTEX.class)), lockedMem, 0) == 0) {
			
			// Direct attribuition
			Pointer<D3DVERTEX> pVertices = lockedMem.get().as(D3DVERTEX.class);
			pVertices.set(0, new D3DVERTEX().x(50.0f).y(50.0f).z(0.0f).rhw(1.0f).color(0x00ff00));
			pVertices.set(1, new D3DVERTEX().x(250.0f).y(50.0f).z(0.0f).rhw(1.0f).color(0x0000ff));
			pVertices.set(2, new D3DVERTEX().x(50.0f).y(250.0f).z(0.0f).rhw(1.0f).color(0xff0000));
			
			// Alternative way: copy data
//			Pointer<D3DVERTEX> vertices = allocateArray(D3DVERTEX.class, 3);
//			vertices.set(0, new D3DVERTEX().x(50.0f).y(50.0f).z(0.0f).rhw(1.0f).color(0x00ff00));
//			vertices.set(1, new D3DVERTEX().x(250.0f).y(50.0f).z(0.0f).rhw(1.0f).color(0x0000ff));
//			vertices.set(2, new D3DVERTEX().x(50.0f).y(250.0f).z(0.0f).rhw(1.0f).color(0xff0000));
//			vertices.copyTo(lockedMem.get());			
			
			vertexBuffer.Unlock();
		}
		
		JNIEnv env = JAWTUtils.getJNIEnv();
		JAWT jawt = JAWTUtils.getJAWT(env);
		
		while(frame.isEnabled()) {

			if(frame.isVisible()) {
				JAWTUtils.withLockedSurface(env, jawt, frame, new LockedComponentRunnable() {
					
					@Override
					public void run(Component comp, long peer) {
						// Clear screen
						device.Clear(0, null, D3DCLEAR_TARGET, 0x00ffbb00, 1.0f, 0);
						if(device.BeginScene() == 0) {
							device.SetStreamSource(0, pointerTo(vertexBuffer), 0, (int)sizeOf(D3DVERTEX.class));
							device.SetFVF(D3DFVF_XYZRHW | D3DFVF_DIFFUSE);
							device.DrawPrimitive(D3DPRIMITIVETYPE.D3DPT_TRIANGLELIST, 0, 1);
							device.EndScene();
						}
						
						device.Present(null, null, null, null);
					}
				});
			}
			
			try { Thread.sleep(5); } catch (InterruptedException e) {}
		}
		
		device.Release();
		d3d9.Release();
	}
}
