package dxgi;


import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11CreateDevice;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_SDK_VERSION;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_DRIVER_TYPE.D3D_DRIVER_TYPE_HARDWARE;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT.DXGI_FORMAT_R8G8B8A8_UNORM;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_SWAP_EFFECT.DXGI_SWAP_EFFECT_DISCARD;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_USAGE.DXGI_USAGE_RENDER_TARGET_OUTPUT;
import static org.bridj.Pointer.*;
import static org.junit.Assert.assertEquals;

import java.awt.Component;

import javax.swing.JFrame;

import org.bridj.Pointer;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.jawt.JAWT;
import org.bridj.jawt.JAWTUtils;
import org.bridj.jawt.JawtLibrary.JNIEnv;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sun.awt.AWTSecurityManager;
import com.fourthskyinteractive.dx4j.windows.HWND;

import com.fourthskyinteractive.dx4j.d3d11.core.D3D11_VIEWPORT;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11Device;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11DeviceContext;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Texture1D;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Texture2D;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11RenderTargetView;
import com.fourthskyinteractive.dx4j.dxgi.DXGI_SWAP_CHAIN_DESC;
import com.fourthskyinteractive.dx4j.dxgi.IDXGIAdapter1;
import com.fourthskyinteractive.dx4j.dxgi.IDXGIDevice1;
import com.fourthskyinteractive.dx4j.dxgi.IDXGIFactory1;
import com.fourthskyinteractive.dx4j.dxgi.IDXGISwapChain;

public class TestDXGI {

	ID3D11Device device;
	ID3D11DeviceContext immediateContext;
	
	@After
	public void destroy() {
		// Release objects
		immediateContext.Release();
		device.Release();
	}
	
	@Before
	public void init() {
		device = D3D11CreateDevice(null, D3D_DRIVER_TYPE_HARDWARE, 0, null);
		immediateContext = device.GetImmediateContext();
	}
	
	@Test
	public void testSwapChain() throws InterruptedException {
		// Get DXGI factory (shall create swap chain with same factory of D3D11 device)
		IDXGIDevice1 dxgiDevice = device.QueryInterface(IDXGIDevice1.class);
		IDXGIAdapter1 dxgiAdapter = dxgiDevice.GetParent(IDXGIAdapter1.class);
		IDXGIFactory1 dxgiFactory = dxgiAdapter.GetParent(IDXGIFactory1.class);
		
		dxgiAdapter.Release();
		dxgiAdapter = null;
		
		// Create JFrame
		JFrame frame = new JFrame("Test D3D11");
		frame.setSize(800, 600);
		frame.setIgnoreRepaint(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// Create Swap Chain
		DXGI_SWAP_CHAIN_DESC desc = new DXGI_SWAP_CHAIN_DESC();
		desc.BufferCount(1)
			.Windowed(1)
			.OutputWindow(new HWND(pointerToAddress(JAWTUtils.getNativePeerHandle(frame))))
			.BufferUsage(DXGI_USAGE_RENDER_TARGET_OUTPUT)
			.SwapEffect(DXGI_SWAP_EFFECT_DISCARD)
			.BufferDesc().Width(800)
						 .Height(600)
						 .Format(DXGI_FORMAT_R8G8B8A8_UNORM)
						 .RefreshRate().Numerator(60)
						 			   .Denominator(1);
		desc.SampleDesc().Count(1)
						 .Quality(0);
				
		final IDXGISwapChain swapChain = dxgiFactory.CreateSwapChain(dxgiDevice, desc);
		dxgiDevice.Release();
		dxgiDevice = null;
		
		// Get back buffer
		ID3D11Texture2D backBuffer = swapChain.GetBuffer(0, ID3D11Texture2D.class);
		
		// Create render target view
		final ID3D11RenderTargetView rtView = device.CreateRenderTargetView(backBuffer, null);
		
		// Set render target
		Pointer<Pointer<ID3D11RenderTargetView>> ppRTV = allocatePointer(ID3D11RenderTargetView.class);
		ppRTV.set(pointerTo(rtView));
		immediateContext.OMSetRenderTargets(1, ppRTV, null);
		ppRTV.release();
		
		// Set viewport
		D3D11_VIEWPORT vp = new D3D11_VIEWPORT();
		vp.Width(800).Height(600).MinDepth(0).MaxDepth(1).TopLeftX(0).TopLeftY(0);
		immediateContext.RSSetViewports(1, pointerTo(vp));
		
		// Clear screen with some color
		final Pointer<Float> pColor = allocateFloats(4).setFloats(new float[] {0.7f, 0.8f, 0.3f, 1.0f});
		
		JNIEnv env = JAWTUtils.getJNIEnv();
		JAWT jawt = JAWTUtils.getJAWT(env);
		while(frame.isEnabled()) {

			JAWTUtils.withLockedSurface(env, jawt, frame, new JAWTUtils.LockedComponentRunnable() {
				
				@Override
				public void run(Component arg0, long arg1) {
					// TODO Auto-generated method stub
					immediateContext.ClearRenderTargetView(pointerTo(rtView), pColor);
					// Present screen
					swapChain.Present(0, 0);
					//frame.repaint();
				}
			});
		}
		
		// Wait to see results
		//Thread.sleep(5000);

		// Release Swap chain and Factory
		rtView.Release();
		backBuffer.Release();		
		swapChain.Release();
		dxgiFactory.Release();
		
		// Dispose JFrame
		frame.dispose();
	}
}
