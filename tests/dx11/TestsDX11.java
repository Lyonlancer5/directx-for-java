package dx11;

import java.awt.Component;

import javax.swing.JFrame;

import org.bridj.jawt.JAWT;
import org.bridj.jawt.JAWTUtils;
import org.bridj.jawt.JAWTUtils.LockedComponentRunnable;
import org.bridj.jawt.JawtLibrary.JNIEnv;

import static org.bridj.BridJ.*;
import static org.bridj.Pointer.*;

import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_FEATURE_LEVEL;
import com.fourthskyinteractive.dx4j.d3d11.D3D11Exception;
import com.fourthskyinteractive.dx4j.d3d11.core.D3D11_VIEWPORT;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D10Blob;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11Device;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11DeviceContext;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_BUFFER_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_SUBRESOURCE_DATA;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Buffer;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Texture2D;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11RenderTargetView;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11PixelShader;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11VertexShader;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_INPUT_ELEMENT_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11InputLayout;
import com.fourthskyinteractive.dx4j.d3dcompiler.D3DCompilerException;
import com.fourthskyinteractive.dx4j.dxgi.DXGI;
import com.fourthskyinteractive.dx4j.dxgi.DXGIException;
import com.fourthskyinteractive.dx4j.dxgi.adapter.IDXGIAdapter1;
import com.fourthskyinteractive.dx4j.dxgi.device.IDXGIDevice1;
import com.fourthskyinteractive.dx4j.dxgi.IDXGIFactory1;
import com.fourthskyinteractive.dx4j.dxgi.device.IDXGISwapChain;

import static com.fourthskyinteractive.dx4j.d3d11.D3D11.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_DRIVER_TYPE.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_FEATURE_LEVEL.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_USAGE.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BIND_FLAG.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_CPU_ACCESS_FLAG.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_INPUT_CLASSIFICATION.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_PRIMITIVE_TOPOLOGY.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_RESOURCE_MISC_FLAG.*;

import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT.*;

import static com.fourthskyinteractive.dx4j.d3dcompiler.D3DCompiler.*;

public class TestsDX11 {

	/**
	 * @param args
	 * @throws D3D11Exception 
	 * @throws D3DCompilerException 
	 * @throws DXGIException 
	 */
	public static void main(String[] args) throws D3D11Exception, D3DCompilerException, DXGIException {

		// Create JFrame
		JFrame frame = new JFrame("D3D11 Tutorial");
		frame.setSize(800, 600);
		frame.setIgnoreRepaint(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// Create device
        D3D_FEATURE_LEVEL featureLevel = D3D_FEATURE_LEVEL_10_0;
		final ID3D11Device device = CreateDevice(D3D_DRIVER_TYPE_WARP,
												 0, 
												 new D3D_FEATURE_LEVEL[] { featureLevel });
		final ID3D11DeviceContext immediateContext = device.GetImmediateContext();

        featureLevel = device.GetFeatureLevel();

		IDXGIDevice1 DXGIDevice = device.QueryInterface(IDXGIDevice1.class);
		IDXGIFactory1 DXGIFactory= DXGIDevice.GetParent(IDXGIAdapter1.class)
											 .GetParent(IDXGIFactory1.class);

		final IDXGISwapChain swapChain = DXGIFactory.CreateSwapChain(DXGIDevice, DXGI.SwapChainDescription(frame));
		DXGIDevice.Release();
		DXGIFactory.Release();

		ID3D11Texture2D backBuffer = swapChain.GetBuffer(0, ID3D11Texture2D.class);
		final ID3D11RenderTargetView rtView = device.CreateRenderTargetView(backBuffer, null);
		backBuffer.Release();

		immediateContext.OMSetRenderTargets(rtView, null);
		immediateContext.RSSetViewport(new D3D11_VIEWPORT(frame.getWidth(), frame.getHeight()));

		// Shader
		String shaders = "float4 VS( float4 Pos : POSITION ) : SV_POSITION        \n" +
						"{                                                        \n" +
						"      return Pos;                                        \n" +
						"}                                                        \n" +
						"                                                         \n" +
						"float4 PS( float4 Pos : SV_POSITION ) : SV_Target        \n" +
						"{                                                        \n" +
						"  return float4( 0.0f, 1.0f, 0.0f, 1.0f );               \n" +
						"}";

		// Compiling for vertex shader and input layout
		ID3D10Blob code = D3DCompile(shaders, "VS", featureLevel.vsShaderVersion, 0, 0);

		// Create input layout
		D3D11_INPUT_ELEMENT_DESC layoutDesc = new D3D11_INPUT_ELEMENT_DESC("POSITION", 0, DXGI_FORMAT_R32G32B32_FLOAT, 0, 0, D3D11_INPUT_PER_VERTEX_DATA, 0);
		final ID3D11InputLayout layout = device.CreateInputLayout(new D3D11_INPUT_ELEMENT_DESC[] { layoutDesc }, code);
		immediateContext.IASetInputLayout(layout);

		// Creating vertex shader
		final ID3D11VertexShader vs = device.CreateVertexShader(code, null);
		code.Release();

		// Creating pixel shader
		code = D3DCompile(shaders, "PS", featureLevel.psShaderVersion, 0, 0);
		final ID3D11PixelShader ps = device.CreatePixelShader(code, null);
		code.Release();

		// Create vertex buffer
		D3D11_BUFFER_DESC bufferDesc = new D3D11_BUFFER_DESC(D3D11_BIND_VERTEX_BUFFER, 
															 D3D11_USAGE_DEFAULT, 
															 D3D11_CPU_ACCESS_NONE, 
															 D3D11_RESOURCE_MISC_NONE,
															 (int)(9 * sizeOf(Float.class)));
		D3D11_SUBRESOURCE_DATA initData = new D3D11_SUBRESOURCE_DATA();
		initData.SysMemPitch(0)
                .SysMemSlicePitch(0)
                .pSysMem(0.0f, 1.0f, 0.5f, 1f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f);
		final ID3D11Buffer vertexBuffer = device.CreateBuffer(bufferDesc, initData);

		JNIEnv env = JAWTUtils.getJNIEnv();
		JAWT jawt = JAWTUtils.getJAWT(env);
		while(frame.isEnabled()) {

			if(frame.isVisible())
				JAWTUtils.withLockedSurface(env, jawt, frame, new LockedComponentRunnable() {
					@Override
					public void run(Component comp, long peer) {
                    immediateContext.ClearRenderTargetView(pointerTo(rtView), pointerToFloats(0.0f, 0.125f, 0.3f, 1.0f));

                    int stride = (int) (sizeOf(Float.class) * 3);
                    immediateContext.IASetVertexBuffers(0, 1, pointerToPointer(pointerTo(vertexBuffer)), pointerToInt(stride), pointerToInt(0));

                    immediateContext.IASetInputLayout(layout);
                    immediateContext.VSSetShader(pointerTo(vs), null, 0);
                    immediateContext.PSSetShader(pointerTo(ps), null, 0);

                    immediateContext.IASetPrimitiveTopology(D3D_PRIMITIVE_TOPOLOGY_TRIANGLELIST);
                    immediateContext.Draw(3, 0);

                    swapChain.Present(0, 0);

                    //immediateContext.ClearState();
					}
				});

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		vs.Release();
		ps.Release();
		layout.Release();
		vertexBuffer.Release();
		swapChain.Release();
		device.Release();
	}

}
