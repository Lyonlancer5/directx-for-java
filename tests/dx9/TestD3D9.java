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
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DFORMAT.*;
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DSWAPEFFECT.*;
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DDEVTYPE.*;
import static com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DMULTISAMPLE_TYPE.*;
import static org.junit.Assert.assertNotNull;

import javax.swing.*;

import com.fourthskyinteractive.dx4j.d3d9.D3D9Exception;
import com.fourthskyinteractive.dx4j.d3d9.core.*;
import org.bridj.Pointer;
import org.bridj.jawt.JAWTUtils;
import org.junit.Test;

import com.fourthskyinteractive.dx4j.windows.HWND;

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
        D3DPRESENT_PARAMETERS d3dpp = new D3DPRESENT_PARAMETERS();
        d3dpp.Windowed(1);
        d3dpp.SwapEffect(D3DSWAPEFFECT_DISCARD);
        d3dpp.BackBufferCount(1);
        d3dpp.BackBufferFormat(D3DFMT_UNKNOWN);
        d3dpp.BackBufferWidth(frame.getWidth());
        d3dpp.BackBufferHeight(frame.getHeight());
        d3dpp.EnableAutoDepthStencil(0);
        d3dpp.MultiSampleType(D3DMULTISAMPLE_NONE);
        d3dpp.MultiSampleQuality(0);
        d3dpp.FullScreen_RefreshRateInHz(D3DPRESENT_RATE_DEFAULT);
        d3dpp.PresentationInterval(D3DPRESENT_INTERVAL_DEFAULT);
        d3dpp.Flags(0);

        IDirect3DDevice9 device = d3d9.CreateDevice(D3DADAPTER_DEFAULT,
                                                    D3DDEVTYPE_HAL,
                                                    new HWND(JAWTUtils.getNativePeerHandle(frame)),
                                                    D3DCREATE_SOFTWARE_VERTEXPROCESSING,
                                                    d3dpp);

        device.Release();
        d3d9.Release();
    }
}
