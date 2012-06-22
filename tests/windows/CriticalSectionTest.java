package windows;

import org.junit.Test;

import com.fourthskyinteractive.dx4j.windows.kernel32.CRITICAL_SECTION;
import static com.fourthskyinteractive.dx4j.windows.kernel32.Kernel32.*;
import static org.bridj.Pointer.*;

public class CriticalSectionTest {

	@Test
	public void testCS() {
		try {
			CRITICAL_SECTION cs = new CRITICAL_SECTION();
			InitializeCriticalSection(pointerTo(cs));
			EnterCriticalSection(pointerTo(cs));
			System.out.println(cs.OwningThread().getPeer());
			
			LeaveCriticalSection(pointerTo(cs));
			DeleteCriticalSection(pointerTo(cs));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
