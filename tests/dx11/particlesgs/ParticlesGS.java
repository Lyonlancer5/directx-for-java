package dx11.particlesgs;

import static com.fourthskyinteractive.dx4j.d3d11.D3D11.CreateDevice;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11CreateDevice;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_SO_NO_RASTERIZED_STREAM;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BIND_FLAG.D3D11_BIND_CONSTANT_BUFFER;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BIND_FLAG.D3D11_BIND_DEPTH_STENCIL;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BIND_FLAG.D3D11_BIND_SHADER_RESOURCE;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BIND_FLAG.D3D11_BIND_STREAM_OUTPUT;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BIND_FLAG.D3D11_BIND_VERTEX_BUFFER;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BLEND.D3D11_BLEND_ONE;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BLEND.D3D11_BLEND_SRC_ALPHA;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BLEND.D3D11_BLEND_ZERO;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BLEND_OP.D3D11_BLEND_OP_ADD;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_CLEAR_FLAG.D3D11_CLEAR_DEPTH;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_CPU_ACCESS_FLAG.D3D11_CPU_ACCESS_NONE;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_CPU_ACCESS_FLAG.D3D11_CPU_ACCESS_WRITE;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_DEPTH_WRITE_MASK.D3D11_DEPTH_WRITE_MASK_ZERO;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_DSV_DIMENSION.D3D11_DSV_DIMENSION_TEXTURE2D;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_DSV_FLAG.D3D11_DSV_READ_NONE;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_FILTER.D3D11_FILTER_COMPARISON_MIN_MAG_MIP_LINEAR;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_FILTER.D3D11_FILTER_COMPARISON_MIN_MAG_MIP_POINT;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_INPUT_CLASSIFICATION.D3D11_INPUT_PER_VERTEX_DATA;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_MAP.D3D11_MAP_WRITE_DISCARD;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_RESOURCE_MISC_FLAG.D3D11_RESOURCE_MISC_NONE;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_TEXTURE_ADDRESS_MODE.D3D11_TEXTURE_ADDRESS_CLAMP;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_TEXTURE_ADDRESS_MODE.D3D11_TEXTURE_ADDRESS_WRAP;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_USAGE.D3D11_USAGE_DEFAULT;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_USAGE.D3D11_USAGE_DYNAMIC;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_DRIVER_TYPE.D3D_DRIVER_TYPE_HARDWARE;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_DRIVER_TYPE.D3D_DRIVER_TYPE_WARP;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_FEATURE_LEVEL.D3D_FEATURE_LEVEL_10_0;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_FEATURE_LEVEL.D3D_FEATURE_LEVEL_11_0;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_PRIMITIVE_TOPOLOGY.D3D_PRIMITIVE_TOPOLOGY_POINTLIST;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_SRV_DIMENSION.D3D_SRV_DIMENSION_TEXTURE1D;
import static com.fourthskyinteractive.dx4j.d3dcompiler.D3DCompiler.D3DCompile;
import static com.fourthskyinteractive.dx4j.d3dx10.D3DX10.*;
import static com.fourthskyinteractive.dx4j.d3dx11.D3DX11.D3DX11CreateShaderResourceViewFromFileA;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT.DXGI_FORMAT_D32_FLOAT;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT.DXGI_FORMAT_R32G32B32A32_FLOAT;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT.DXGI_FORMAT_R32G32B32_FLOAT;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT.DXGI_FORMAT_R32_FLOAT;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT.DXGI_FORMAT_R32_TYPELESS;
import static com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT.DXGI_FORMAT_R32_UINT;
import static org.bridj.BridJ.delete;
import static org.bridj.BridJ.sizeOf;
import static org.bridj.Pointer.NULL;
import static org.bridj.Pointer.allocateFloats;
import static org.bridj.Pointer.allocatePointer;
import static org.bridj.Pointer.pointerTo;
import static org.bridj.Pointer.pointerToCString;
import static org.bridj.Pointer.pointerToFloats;
import static org.bridj.Pointer.pointerToInt;
import static org.bridj.Pointer.pointerToPointer;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import com.fourthskyinteractive.dx4j.d3dcompiler.D3DCompilerException;
import com.fourthskyinteractive.dx4j.dxgi.DXGIException;
import org.bridj.Pointer;
import org.bridj.jawt.JAWT;
import org.bridj.jawt.JAWTUtils;
import org.bridj.jawt.JAWTUtils.LockedComponentRunnable;
import org.bridj.jawt.JawtLibrary.JNIEnv;

import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_BIND_FLAG;
import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_FEATURE_LEVEL;
import com.fourthskyinteractive.dx4j.d3d11.D3D11Exception;
import com.fourthskyinteractive.dx4j.d3d11.core.D3D11_VIEWPORT;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D10Blob;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11Device;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11DeviceContext;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_BUFFER_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_MAPPED_SUBRESOURCE;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_SUBRESOURCE_DATA;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_TEXTURE1D_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_TEXTURE2D_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Buffer;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Texture1D;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Texture2D;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.D3D11_DEPTH_STENCIL_VIEW_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.D3D11_SHADER_RESOURCE_VIEW_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11DepthStencilView;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11RenderTargetView;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11ShaderResourceView;
import com.fourthskyinteractive.dx4j.d3d11.shader.D3D11_SO_DECLARATION_ENTRY;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11GeometryShader;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11PixelShader;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11VertexShader;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_BLEND_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_DEPTH_STENCIL_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_INPUT_ELEMENT_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_SAMPLER_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11BlendState;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11DepthStencilState;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11InputLayout;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11SamplerState;
import com.fourthskyinteractive.dx4j.d3dx10.D3DXMATRIX;
import com.fourthskyinteractive.dx4j.d3dx10.D3DXVECTOR3;
import com.fourthskyinteractive.dx4j.d3dx10.D3DXVECTOR4;
import com.fourthskyinteractive.dx4j.dxgi.DXGI;
import com.fourthskyinteractive.dx4j.dxgi.IDXGIFactory1;
import com.fourthskyinteractive.dx4j.dxgi.adapter.IDXGIAdapter1;
import com.fourthskyinteractive.dx4j.dxgi.device.IDXGIDevice1;
import com.fourthskyinteractive.dx4j.dxgi.device.IDXGISwapChain;

public class ParticlesGS {
	
	public static final int findMultipleOf16(int number) {
		int i = 0, j = 0;
		
		
		return j;
	}
	
	public static final int MAX_PARTICLES = 40000;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws D3D11Exception 
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) throws IOException, D3D11Exception, DXGIException, D3DCompilerException {
		boolean firstRun = true;
		float lastTimestamp = 0.0f;
		
		// DirectX 11 objects
		IDXGISwapChain swapChain = null;
		ID3D11RenderTargetView rtView = null;
		ID3D11DepthStencilView depthView = null;
		ID3D11InputLayout inputLayout = null;
		ID3D11VertexShader vsSceneMain = null;
		ID3D11GeometryShader gsAdvanceParticlesMain = null;
		ID3D11VertexShader vsPassThroughmain = null;
		ID3D11GeometryShader gsSceneMain = null;
		ID3D11PixelShader psSceneMain = null;
		ID3D11Buffer constBuffer = null;
		ID3D11Buffer particleStartBuffer = null;
		ID3D11Buffer particleDrawFrom = null;
		ID3D11Buffer particleStreamTo = null;
		ID3D11ShaderResourceView particleTexSRV = null;
		ID3D11ShaderResourceView randomTexSRV = null;
		ID3D11SamplerState sampLinear = null;
		ID3D11SamplerState sampPoint = null;
		ID3D11BlendState additiveBlending = null;
		ID3D11BlendState noBlending = null;
		ID3D11DepthStencilState disableDepth = null;
		D3DXMATRIX viewMatrix, projMatrix;
		
		// Create JFrame
		JFrame frame = new JFrame("D3D11 Tutorial 2");
		frame.setSize(800, 600);
		frame.setIgnoreRepaint(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
				
		// Create device
        // Create device
        D3D_FEATURE_LEVEL featureLevel = D3D_FEATURE_LEVEL_10_0;
        final ID3D11Device device = CreateDevice(D3D_DRIVER_TYPE_WARP,
                0,
                new D3D_FEATURE_LEVEL[] { featureLevel });
        final ID3D11DeviceContext immediateContext = device.GetImmediateContext();
		
		// Creating swap chain
		IDXGIDevice1 dxgiDevice = device.QueryInterface(IDXGIDevice1.class);
		IDXGIFactory1 dxgiFactory = dxgiDevice.GetParent(IDXGIAdapter1.class)
											  .GetParent(IDXGIFactory1.class);
		
		swapChain = dxgiFactory.CreateSwapChain(dxgiDevice, DXGI.SwapChainDescription(frame));
		dxgiDevice.Release();
		dxgiFactory.Release();
		
		{
			// Creating render target buffer
			ID3D11Texture2D backBuffer = swapChain.GetBuffer(0, ID3D11Texture2D.class);
			rtView = device.CreateRenderTargetView(backBuffer, null);
			backBuffer.Release();
			
			// Creating depth stencil buffer
			D3D11_TEXTURE2D_DESC depthDesc = new D3D11_TEXTURE2D_DESC().ArraySize(1)
																	   .BindFlags(D3D11_BIND_DEPTH_STENCIL)
																	   .CPUAccessFlags(D3D11_CPU_ACCESS_NONE)
																	   .Format(DXGI_FORMAT_R32_TYPELESS)
																	   .Width(800)
																	   .Height(600)
																	   .MipLevels(1)
																	   .MiscFlags(D3D11_RESOURCE_MISC_NONE)
																	   .Usage(D3D11_USAGE_DEFAULT);
			depthDesc.SampleDesc().Count(1)
								  .Quality(0);
			ID3D11Texture2D depthTexture = device.CreateTexture2D(depthDesc, null);
			
			D3D11_DEPTH_STENCIL_VIEW_DESC depthViewDesc = new D3D11_DEPTH_STENCIL_VIEW_DESC()
															.Flags(D3D11_DSV_READ_NONE)
															.Format(DXGI_FORMAT_D32_FLOAT)
															.ViewDimension(D3D11_DSV_DIMENSION_TEXTURE2D);
			depthViewDesc.Texture2D().MipSlice(0);
			depthView = device.CreateDepthStencilView(depthTexture, depthViewDesc);
			depthTexture.Release();
	
			// Configuring screen
			immediateContext.OMSetRenderTargets(rtView, depthView);
			immediateContext.RSSetViewport(new D3D11_VIEWPORT(frame.getWidth(), frame.getHeight()));
		}
		
		{
			// Defining layout structure
			D3D11_INPUT_ELEMENT_DESC layout[] = new D3D11_INPUT_ELEMENT_DESC[] {
					new D3D11_INPUT_ELEMENT_DESC("POSITION", 0, DXGI_FORMAT_R32G32B32_FLOAT, 0, 0, D3D11_INPUT_PER_VERTEX_DATA, 0),
					new D3D11_INPUT_ELEMENT_DESC("NORMAL", 0, DXGI_FORMAT_R32G32B32_FLOAT, 0, 12, D3D11_INPUT_PER_VERTEX_DATA, 0),
					new D3D11_INPUT_ELEMENT_DESC("TIMER", 0, DXGI_FORMAT_R32_FLOAT, 0, 24, D3D11_INPUT_PER_VERTEX_DATA, 0),
					new D3D11_INPUT_ELEMENT_DESC("TYPE", 0, DXGI_FORMAT_R32_UINT, 0, 28, D3D11_INPUT_PER_VERTEX_DATA, 0)
			};
	
			// Create shaders (using file don't works, instead read source in a string
			StringBuilder shaderSource = new StringBuilder(4000);
			BufferedReader reader = new BufferedReader(new FileReader("resources/shaders/particlesgs.fx"));
			String line = "";
			while((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
			reader.close();
			
			ID3D10Blob compiledCode = D3DCompile(shaderSource.toString(), "VSPassThroughmain", "vs_4_0", 0, 0);
			
			// Creating input layout using first vertex shader (both have the same input signature, can use anyone)
			inputLayout = device.CreateInputLayout(layout, compiledCode);
			
			// Creating advance particles shaders
			vsPassThroughmain = device.CreateVertexShader(compiledCode, null);
			compiledCode.Release();
			
			compiledCode = D3DCompile(shaderSource.toString(), "GSAdvanceParticlesMain", "gs_4_0", 0, 0);
			D3D11_SO_DECLARATION_ENTRY[] soDeclaration = new D3D11_SO_DECLARATION_ENTRY[] {
					new D3D11_SO_DECLARATION_ENTRY(0, "POSITION", 0, 0, 3, 0),
					new D3D11_SO_DECLARATION_ENTRY(0, "NORMAL", 0, 0, 3, 0),
					new D3D11_SO_DECLARATION_ENTRY(0, "TIMER", 0, 0, 1, 0),
					new D3D11_SO_DECLARATION_ENTRY(0, "TYPE", 0, 0, 1, 0)				
			};
			gsAdvanceParticlesMain =
					device.CreateGeometryShaderWithStreamOutput(compiledCode, 
																soDeclaration, 
																new int[] { (int)sizeOf(PARTICLE_VERTEX.class) }, 
																D3D11_SO_NO_RASTERIZED_STREAM, 
																null);
			compiledCode.Release();
			
			// Creating render particles shaders
			compiledCode = D3DCompile(shaderSource.toString(), "VSScenemain", "vs_4_0", 0, 0);
			vsSceneMain = device.CreateVertexShader(compiledCode, null);
			compiledCode.Release();
			
			compiledCode = D3DCompile(shaderSource.toString(), "GSScenemain", "gs_4_0", 0, 0);
			gsSceneMain = device.CreateGeometryShader(compiledCode, null);
			compiledCode.Release();
			
			compiledCode = D3DCompile(shaderSource.toString(), "PSScenemain", "ps_4_0", 0, 0);
			psSceneMain = device.CreatePixelShader(compiledCode, null);
			compiledCode.Release();
		}
		
		// Create shader constant buffer (shall be multiple of 16 bytes)
		{
			int cbSize = (int)sizeOf(CB.class);
			D3D11_BUFFER_DESC cbDesc = new D3D11_BUFFER_DESC(D3D11_BIND_CONSTANT_BUFFER, 
															 D3D11_USAGE_DYNAMIC, 
															 D3D11_CPU_ACCESS_WRITE, 
															 D3D11_RESOURCE_MISC_NONE, 
															 256);
			constBuffer = device.CreateBuffer(cbDesc, null);
		}
		
		// Creating particle buffers
		{
			D3D11_BUFFER_DESC vbDesc = new D3D11_BUFFER_DESC(D3D11_BIND_VERTEX_BUFFER, 
															 D3D11_USAGE_DEFAULT, 
															 D3D11_CPU_ACCESS_NONE, 
															 D3D11_RESOURCE_MISC_NONE, 
															 (int)sizeOf(PARTICLE_VERTEX.class));
			
			PARTICLE_VERTEX vertStart = new PARTICLE_VERTEX();
			vertStart.pos().x(0).y(0).z(0);
			vertStart.vel().x(0).y(40).z(0);
			vertStart.timer(0).type(0);
			
			D3D11_SUBRESOURCE_DATA vbInitData = new D3D11_SUBRESOURCE_DATA()
														.pSysMem(pointerTo(vertStart))
														.SysMemPitch((int)sizeOf(PARTICLE_VERTEX.class))
														.SysMemSlicePitch(0);
			
			particleStartBuffer = device.CreateBuffer(vbDesc, vbInitData);
			
			vbDesc.ByteWidth((int)sizeOf(PARTICLE_VERTEX.class) * MAX_PARTICLES);
			vbDesc.BindFlags(D3D11_BIND_FLAG.fromValue(D3D11_BIND_VERTEX_BUFFER.value | D3D11_BIND_STREAM_OUTPUT.value));
			
			particleDrawFrom = device.CreateBuffer(vbDesc, null);
			particleStreamTo = device.CreateBuffer(vbDesc, null);
		}
		
		// Create textures
		{
			// Particle texture
			Pointer<Pointer<ID3D11ShaderResourceView>> ppSRV = allocatePointer(ID3D11ShaderResourceView.class);
			int result = D3DX11CreateShaderResourceViewFromFileA(pointerTo(device), pointerToCString("resources/textures/particle.dds"), null, null, ppSRV, null);
			particleTexSRV = ppSRV.get().getNativeObject(ID3D11ShaderResourceView.class);
			
			// Random texture
			D3D11_SUBRESOURCE_DATA initData = new D3D11_SUBRESOURCE_DATA();
			initData.pSysMem(allocateFloats(1024 * 4)); 
			initData.SysMemPitch(1024 * 4 * (int)sizeOf(Float.class));
			initData.SysMemSlicePitch(1024 * 4 * (int)sizeOf(Float.class));
			
			for (int i = 0; i < 1024 * 4; i++) {
				initData.pSysMem().setFloatAtOffset(i, (float) ((Math.random() % 10000) - 5000));
			}
			
			D3D11_TEXTURE1D_DESC texDesc = new D3D11_TEXTURE1D_DESC();
			texDesc.Width(1024)
				   .MipLevels(1)
				   .Format(DXGI_FORMAT_R32G32B32A32_FLOAT)
				   .Usage(D3D11_USAGE_DEFAULT)
				   .BindFlags(D3D11_BIND_SHADER_RESOURCE)
				   .CPUAccessFlags(0)
				   .MiscFlags(D3D11_RESOURCE_MISC_NONE)
				   .ArraySize(1);
			
			ID3D11Texture1D randomTex = device.CreateTexture1D(texDesc, initData);
			
			D3D11_SHADER_RESOURCE_VIEW_DESC srvDesc = new D3D11_SHADER_RESOURCE_VIEW_DESC();
			srvDesc.Format(DXGI_FORMAT_R32G32B32A32_FLOAT)
				   .ViewDimension(D3D_SRV_DIMENSION_TEXTURE1D);
			srvDesc.Texture2D().MipLevels(texDesc.MipLevels())
							   .MostDetailedMip(0);
			
			Pointer<Pointer<ID3D11ShaderResourceView>> pp = allocatePointer(ID3D11ShaderResourceView.class);
			result = device.CreateShaderResourceView(pointerTo(randomTex), pointerTo(srvDesc), pp);
			randomTexSRV = pp.get().getNativeObject(ID3D11ShaderResourceView.class);
			
			// Cleanup temporary storage
			randomTex.Release();
			initData.pSysMem().release();
			delete(initData);
		}
		
		// Create pipeline states
		{
			D3D11_SAMPLER_DESC sampDesc = new D3D11_SAMPLER_DESC();
			sampDesc.Filter(D3D11_FILTER_COMPARISON_MIN_MAG_MIP_LINEAR)
					.AddressU(D3D11_TEXTURE_ADDRESS_CLAMP)
					.AddressV(D3D11_TEXTURE_ADDRESS_CLAMP);
			sampLinear = device.CreateSamplerState(sampDesc);
			
			sampDesc.Filter(D3D11_FILTER_COMPARISON_MIN_MAG_MIP_POINT)
					.AddressU(D3D11_TEXTURE_ADDRESS_WRAP);
			sampPoint = device.CreateSamplerState(sampDesc);
			
			D3D11_BLEND_DESC blendDesc = new D3D11_BLEND_DESC()
												.AlphaToCoverageEnable(1)
												.IndependentBlendEnable(0);
			blendDesc.RenderTargets().get(0).BlendEnable(1)
											.SrcBlend(D3D11_BLEND_SRC_ALPHA)
											.DestBlend(D3D11_BLEND_ONE)
											.BlendOp(D3D11_BLEND_OP_ADD)
											.SrcBlendAlpha(D3D11_BLEND_ZERO)
											.DestBlendAlpha(D3D11_BLEND_ZERO)
											.BlendOpAlpha(D3D11_BLEND_OP_ADD)
											.RenderTargetWriteMask((byte)0x0F);
			additiveBlending = device.CreateBlendState(blendDesc);
			
			blendDesc.AlphaToCoverageEnable(0)
					 .RenderTargets().get(0).BlendEnable(0);
			noBlending = device.CreateBlendState(blendDesc);
			
			D3D11_DEPTH_STENCIL_DESC depthStateDesc = new D3D11_DEPTH_STENCIL_DESC()
															.DepthEnable(0)
															.DepthWriteMask(D3D11_DEPTH_WRITE_MASK_ZERO);
			disableDepth = device.CreateDepthStencilState(depthStateDesc);
		}
		
		// Configuring view matrices
		{
			viewMatrix = new D3DXMATRIX();
			D3DXMatrixIdentity(pointerTo(viewMatrix));
			D3DXMatrixLookAtLH(pointerTo(viewMatrix), 
							   pointerTo(new D3DXVECTOR3(0, 0, -170.0f)), 
							   pointerTo(new D3DXVECTOR3(0, 70.0f, 0)), 
							   pointerTo(new D3DXVECTOR3(0, 1, 0)));
			viewMatrix._11(0.99999994f)
					  ._12(0)
					  ._13(0)
					  ._14(0)
					  ._21(0)
					  ._22(0.92467797f)
					  ._23(0.38074982f)
					  ._24(0)
					  ._31(0)
					  ._32(-0.38074979f)
					  ._33(0.92467803f)
					  ._34(0f)
					  ._41(0)
					  ._42(-64.727455f)
					  ._43(143.34752f)
					  ._44(1f);			
			
			projMatrix = new D3DXMATRIX();
			D3DXMatrixIdentity(pointerTo(projMatrix));
			D3DXMatrixPerspectiveFovLH(pointerTo(projMatrix), 45.0f, 800 / 600, 0.1f, 5000.0f);
			 projMatrix._11(1.8106600f)
					   ._12(0f)
					   ._13(0f)
					   ._14(0f)
					   ._21(0f)
					   ._22(2.4142134f)
					   ._23(0f)
					   ._24(0f)
					   ._31(0f)
					   ._32(0f)
					   ._33(1.0000200f)
					   ._34(1f)
					   ._41(0f)
					   ._42(0f)
					   ._43(-0.10000201f)
					   ._44(0f);

		}
		
		
		lastTimestamp = ((float)System.currentTimeMillis()) / 1000000000f;
		JNIEnv env = JAWTUtils.getJNIEnv();
		JAWT jawt = JAWTUtils.getJAWT(env);
		
		while(frame.isEnabled()) {
			if(frame.isVisible()) {
				// Update timestamp
				long millis = System.currentTimeMillis();
				float currentTime = ((float) millis) / 1000.0f;
				float elapsedTime = currentTime - lastTimestamp;
				if (elapsedTime <= 0.01) elapsedTime = 0.01f;
				lastTimestamp = currentTime;
				
				System.out.format("Elapsed: %.4f | Last T: %.04f\n", elapsedTime, lastTimestamp);
				
				// Clear screen
				immediateContext.ClearRenderTargetView(pointerTo(rtView), pointerToFloats(0.0f, 0.125f, 0.3f, 1.0f));
				immediateContext.ClearDepthStencilView(pointerTo(depthView), D3D11_CLEAR_DEPTH, 1.0f, (byte)0);
				
				immediateContext.IASetInputLayout(inputLayout);
				
				// Simulate particles
				{
					D3DXVECTOR4 vGravity = new D3DXVECTOR4( 0,-9.8f * elapsedTime,0,0 );
					
					ID3D11Buffer tempBuffer;
					if (firstRun)
						tempBuffer = particleStartBuffer;
					else
						tempBuffer = particleDrawFrom;
					
					int stride = (int) sizeOf(PARTICLE_VERTEX.class);
					immediateContext.IASetVertexBuffers(0, 1, pointerToPointer(pointerTo(tempBuffer)), 
															  pointerToInt(stride), 
															  pointerToInt(0));
					
					// Fill shader parameters
					D3D11_MAPPED_SUBRESOURCE mappedData = immediateContext.Map(constBuffer, 0, D3D11_MAP_WRITE_DISCARD, 0);
					CB cb = mappedData.pData().as(CB.class).get();
					cb.globalTime(lastTimestamp)
					  .elapsedTime(elapsedTime)
					  .secondsPerFirework(0.4f)
					  .numEmber1s(100)
					  .numEmber2s(15.0f)
					  .frameGravity(vGravity);
					immediateContext.Unmap(constBuffer, 0);
					
					// Configure shader state
					Pointer<Pointer<ID3D11Buffer>> ppConstBuffer = pointerToPointer(pointerTo(constBuffer));
					immediateContext.VSSetShader(pointerTo(vsPassThroughmain), null, 0);
					immediateContext.VSSetConstantBuffers(0, 1, ppConstBuffer);
					
					immediateContext.GSSetShader(pointerTo(gsAdvanceParticlesMain), null, 0);
					immediateContext.GSSetConstantBuffers(0, 1, ppConstBuffer);
					immediateContext.GSSetShaderResources(0, 1, pointerToPointer(pointerTo(randomTexSRV)));
					
					immediateContext.SOSetTargets(1, pointerToPointer(pointerTo(particleStreamTo)), pointerToInt(0));
					
					immediateContext.PSSetShader(null, null, 0);
					
					immediateContext.OMSetDepthStencilState(pointerTo(disableDepth), 0);
					immediateContext.OMSetBlendState(null, pointerToFloats(0.0f, 0.0f, 0.0f, 0.0f), 0xFFFFFFFF);
					
					// Finally, draw
					immediateContext.IASetPrimitiveTopology(D3D_PRIMITIVE_TOPOLOGY_POINTLIST);
					if (firstRun)
						immediateContext.Draw(1, 0);
					else
						immediateContext.DrawAuto();
					
					// Undo some states
					immediateContext.SOSetTargets(1, pointerToPointer(Pointer.NULL), pointerToInt(0));
					
					// Swap particle buffers
					tempBuffer = particleDrawFrom;
					particleDrawFrom = particleStreamTo;
					particleStreamTo = tempBuffer;
					
					firstRun = false;
				}
				
				// Render particles
				{
					D3DXMATRIX worldViewProj = new D3DXMATRIX();
					D3DXMatrixIdentity(pointerTo(worldViewProj));
					D3DXMatrixMultiply(pointerTo(worldViewProj), pointerTo(viewMatrix), pointerTo(projMatrix));
					
					D3DXMATRIX invView = new D3DXMATRIX();
					D3DXMatrixIdentity(pointerTo(invView));
					D3DXMatrixInverse(pointerTo(invView), null, pointerTo(viewMatrix));
					
					int stride = (int) sizeOf(PARTICLE_VERTEX.class);
					immediateContext.IASetVertexBuffers(0, 1, pointerToPointer(pointerTo(particleDrawFrom)), pointerToInt(stride), pointerToInt(0));
					
					// Fill shader parameters
					D3D11_MAPPED_SUBRESOURCE mappedData = immediateContext.Map(constBuffer, 0, D3D11_MAP_WRITE_DISCARD, 0);
					CB cb = mappedData.pData().as(CB.class).get();
					cb.worldViewProj(worldViewProj)
					  .inverseViewMatrix(invView);
					immediateContext.Unmap(constBuffer, 0);
					
					// Configure shader state
					Pointer<Pointer<ID3D11Buffer>> ppConstBuffer = pointerToPointer(pointerTo(constBuffer));
					immediateContext.VSSetShader(pointerTo(vsSceneMain), null, 0);
					immediateContext.VSSetConstantBuffers(0, 1, ppConstBuffer);
					
					immediateContext.GSSetShader(pointerTo(gsSceneMain), null, 0);
					immediateContext.GSSetConstantBuffers(0, 1, ppConstBuffer);
					
					immediateContext.PSSetShader(pointerTo(psSceneMain), null, 0);
					immediateContext.PSSetShaderResources(0, 1, pointerToPointer(pointerTo(particleTexSRV)));
					
					immediateContext.OMSetBlendState(pointerTo(additiveBlending), pointerToFloats(0, 0, 0, 0), 0xFFFFFFFF);
					immediateContext.OMSetDepthStencilState(pointerTo(disableDepth), 0);
					
					// Finally, draw
					immediateContext.IASetPrimitiveTopology(D3D_PRIMITIVE_TOPOLOGY_POINTLIST);
					immediateContext.DrawAuto();
				}
				
				
				final IDXGISwapChain tSwapChain = swapChain;
				JAWTUtils.withLockedSurface(env, jawt, frame, new LockedComponentRunnable() {
					public void run(Component comp, long peer) {
						// Present to screen
						tSwapChain.Present(0, 0);
					}
				});
				
				immediateContext.ClearState();
				
				try { Thread.sleep(5); } catch(Exception e) {}
			}
		}
		
		
		// Clean up
		constBuffer.Release();
		particleStartBuffer.Release();
		particleDrawFrom.Release();
		particleStreamTo.Release();
		
		vsPassThroughmain.Release();
		gsAdvanceParticlesMain.Release();
		
		vsSceneMain.Release();
		gsSceneMain.Release();
		psSceneMain.Release();
		
		inputLayout.Release();
		depthView.Release();
		swapChain.Release();
		immediateContext.Release();
		device.Release();
		
		frame.dispose();
	}
}
