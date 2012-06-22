package d3d11.other;

import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_TEXTURE_ADDRESS_MODE;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_SAMPLER_DESC;


public class TestEqualsAndHashCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		D3D11_SAMPLER_DESC desc = new D3D11_SAMPLER_DESC();
		desc.AddressU(D3D11_TEXTURE_ADDRESS_MODE.D3D11_TEXTURE_ADDRESS_MIRROR);
		desc.MaxLOD(654.0f);
		desc.MaxAnisotropy(16);
		
		long start = System.currentTimeMillis();
		int hash = desc.hashCode();
		System.out.println(System.currentTimeMillis() - start);
		
		System.out.println(hash);
	}

}
