package d3dx10;

import org.junit.Test;

import com.fourthskyinteractive.dx4j.d3dx10.D3DXMATRIX;

import static com.fourthskyinteractive.dx4j.d3dx10.D3DX10.*;
import static org.bridj.Pointer.*;

public class TestMath {

	@Test
	public void testMatrix() {
		D3DXMATRIX m = new D3DXMATRIX();
		System.out.println("Matrix criada:\n" + m.toString());
		D3DXMatrixIdentity(pointerTo(m));
		System.out.println("Matrix identidade:\n" + m.toString());
		
		D3DXMatrixRotationYawPitchRoll(pointerTo(m), 1, 1, 1);
		System.out.println("Matrix girada:\n" + m.toString());
	}
}
