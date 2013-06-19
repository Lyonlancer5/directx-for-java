package dx9;

/**
 * Created with IntelliJ IDEA.
 * User: evandro.paulino
 * Date: 18/06/13
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.*;
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.Direct3DCreate9;
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DDEVTYPE.*;
import static org.bridj.BridJ.sizeOf;
import static org.bridj.Pointer.NULL;
import static org.bridj.Pointer.allocatePointer;
import static org.bridj.Pointer.pointerTo;
import static org.junit.Assert.assertNotNull;

import javax.swing.*;

import com.fourthskyinteractive.dx4j.d3d9.D3D9;
import com.fourthskyinteractive.dx4j.d3d9.D3D9Exception;
import com.fourthskyinteractive.dx4j.d3d9.core.*;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DVertexBuffer9;
import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.jawt.JAWT;
import org.bridj.jawt.JAWTUtils;
import org.bridj.jawt.JawtLibrary;
import org.junit.Test;

import com.fourthskyinteractive.dx4j.windows.HWND;

import java.awt.*;

public class TestD3D9 {

    @Test
    public void testD3D9() throws D3D9Exception {
        Pointer<IDirect3D9> pD3D9 = Direct3DCreate9(D3D_SDK_VERSION);
        assertNotNull(pD3D9);

        IDirect3D9 d3d9 = pD3D9.get();

        int adapterCount = d3d9.GetAdapterCount();
        System.out.println("Found " + adapterCount + " adapters");

        /*
        D3DADAPTER_IDENTIFIER9 identifier = new D3DADAPTER_IDENTIFIER9();
        d3d9.GetAdapterIdentifier(0, 0, pointerTo(identifier));

        D3DDISPLAYMODE mode = new D3DDISPLAYMODE();
        d3d9.GetAdapterDisplayMode(D3DADAPTER_DEFAULT, pointerTo(mode));
        */

        // Create JFrame
        JFrame frame = new JFrame("Test D3D11");
        frame.setSize(800, 600);
        frame.setIgnoreRepaint(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Configure presentation parameters
        D3DPRESENT_PARAMETERS d3dpp = D3D9.CreatePresentationParameters(frame.getWidth(), frame.getHeight(), true);
        final IDirect3DDevice9 device = d3d9.CreateDevice(D3DADAPTER_DEFAULT,
                                                    D3DDEVTYPE_HAL,
                                                    new HWND(JAWTUtils.getNativePeerHandle(frame)),
                                                    D3DCREATE_HARDWARE_VERTEXPROCESSING,
                                                    d3dpp);


        // Creating vertex buffer
        final IDirect3DVertexBuffer9 vertexBuffer = device.CreateVertexBuffer((int)(3 * sizeOf(D3DVERTEX.class)), 0, D3DFVF_XYZRHW | D3DFVF_DIFFUSE, D3DPOOL.D3DPOOL_DEFAULT);

        // Copying data
        Pointer<Pointer<?>> lockedMem = allocatePointer();
        if (vertexBuffer.Lock(0, (int)(3 * sizeOf(D3DVERTEX.class)), lockedMem, 0) == 0) {

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

        JawtLibrary.JNIEnv env = JAWTUtils.getJNIEnv();
        JAWT jawt = JAWTUtils.getJAWT(env);
        while(frame.isEnabled()) {

            if(frame.isVisible()) {
                JAWTUtils.withLockedSurface(env, jawt, frame, new JAWTUtils.LockedComponentRunnable() {
                    @Override
                    public void run(Component comp, long peer) {
                        // Clear screen
                        device.Clear(0, NULL, D3DCLEAR_TARGET, 0x00ffbb00, 1.0f, 0);
                        if(device.BeginScene() == 0) {
                            device.SetStreamSource(0, pointerTo(vertexBuffer), 0, (int)sizeOf(D3DVERTEX.class));
                            device.SetFVF(D3DFVF_XYZRHW | D3DFVF_DIFFUSE);
                            device.DrawPrimitive(D3DPRIMITIVETYPE.D3DPT_TRIANGLELIST, 0, 1);
                            device.EndScene();
                        }

                        device.Present(null, null, null, null) ;
                    }
                });

            try { Thread.sleep(5); } catch (InterruptedException e) {}
        }

        device.Release();
        d3d9.Release();
    }
}}
