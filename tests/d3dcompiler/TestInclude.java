package d3dcompiler;

import static com.fourthskyinteractive.dx4j.d3d11.D3D11.*;
import static com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_DRIVER_TYPE.*;
import static org.bridj.Pointer.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import org.bridj.Pointer;
import org.bridj.ValuedEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_INCLUDE_TYPE;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D10Blob;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11Device;
import com.fourthskyinteractive.dx4j.d3d11.core.ID3D11DeviceContext;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11VertexShader;
import com.fourthskyinteractive.dx4j.d3dcompiler.D3DCompiler.ID3DInclude;
import static com.fourthskyinteractive.dx4j.d3dcompiler.D3DCompiler.*;

public class TestInclude {

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

	public static class IncludeHandler extends ID3DInclude {

		private FileChannel fileChannel;
		private ByteBuffer mappedData;
		
		@Override
		public int Open(ValuedEnum<D3D_INCLUDE_TYPE> IncludeType, Pointer<Byte> pFileName, 
				Pointer<?> pParentData, Pointer<Pointer<?>> ppData, Pointer<Integer> pBytes) {
			
			String fileName = pFileName.getCString();
			try {
				// Map file to memory, avoiding copy
				fileChannel = new FileInputStream(fileName).getChannel();
				long fileSize = fileChannel.size();
				mappedData = fileChannel.map(MapMode.READ_ONLY, 0, fileSize);

				// Set data and size
				ppData.setPointer(pointerToBytes(mappedData));
				pBytes.setInt((int) fileSize);

				return 0;

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -2;
			}							
		}

		@Override
		public int Close(Pointer<?> pData) {
			try {
				// Force unmap of file
				if (mappedData instanceof sun.nio.ch.DirectBuffer) {
					sun.misc.Cleaner cleaner = ((sun.nio.ch.DirectBuffer) mappedData).cleaner();
					cleaner.clean();
				}
				
				// Close file
				fileChannel.close();
			} catch (IOException e) {}

			return 0;
		}
	}
	
	public static class TestIncludeHandler extends ID3DInclude {
		@Override
		public int Open(ValuedEnum<D3D_INCLUDE_TYPE> IncludeType, Pointer<Byte> pFileName, 
				Pointer<?> pParentData, Pointer<Pointer<?>> ppData, Pointer<Integer> pBytes) {
			
			String fileName = pFileName.getCString();
			
			// Set data and size
			String code = "";
			ppData.setPointer(pointerToCString(code));
			pBytes.setInt(code.length());

			return 0;				
		}

		@Override
		public int Close(Pointer<?> pData) {
			pData.release();
			return 0;
		}
	}

	@Test
	public void compileShaders() {
		// Create include callbacks
		TestIncludeHandler handler = new TestIncludeHandler();	

		String vertexShader = 
		"#include \"test.h\" 								\n" +
		"													\n" +
		"float4 VS( float4 Pos : POSITION ) : SV_POSITION 	\n" +
		"{ 													\n" +
		"		return Pos;									\n" +
		"}													\n";
		//String pixelShader = "float4 PS( float4 Pos : SV_POSITION ) : SV_Target { return float4( 1.0f, 1.0f, 0.0f, 1.0f );    // Yellow, with Alpha = 1}";	

		ID3D10Blob vsCode = D3DCompile(vertexShader,
										null,
										null,
										handler,
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
