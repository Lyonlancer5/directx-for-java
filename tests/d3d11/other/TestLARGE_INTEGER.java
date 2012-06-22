package d3d11.other;

import com.fourthskyinteractive.dx4j.windows.kernel32.LARGE_INTEGER;

public class TestLARGE_INTEGER {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LARGE_INTEGER l = new LARGE_INTEGER();
		l.HighPart(32);
		l.LowPart(32);
		
		
		long ret = (long)(l.HighPart()) << 32 | l.LowPart();
		System.out.println((long)(l.HighPart()) << 32);
		System.out.println(l.LowPart());
		System.out.println(ret);
	}

}
