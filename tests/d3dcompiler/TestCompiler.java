package d3dcompiler;

import static com.fourthskyinteractive.dx4j.d3d11.D3D11.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_DRIVER_TYPE.*;
import static org.bridj.Pointer.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.bridj.Pointer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fourthskyinteractive.dx4j.d3d11.core.ID3D10Blob;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11Device;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11DeviceContext;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11VertexShader;
import static com.fourthskyinteractive.dx4j.d3dcompiler.D3DCompiler.*;

public class TestCompiler {

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
	public void compileShaders() {

		String vertexShader = "float4 VS( float4 Pos : POSITION ) : SV_POSITION " +
				"{ " +
				"		return Pos;" +
				"}";
		//String pixelShader = "float4 PS( float4 Pos : SV_POSITION ) : SV_Target { return float4( 1.0f, 1.0f, 0.0f, 1.0f );    // Yellow, with Alpha = 1}";	

		ID3D10Blob vsCode = D3DCompile(vertexShader,
										null,
										null,
										null,
										"VS",
										"vs_5_0",
										0,
										0);
		assertNotNull(vsCode);

		ID3D11VertexShader vs = device.CreateVertexShader(vsCode, null);
		assertNotNull(vs);

		vs.Release();
	}
}
