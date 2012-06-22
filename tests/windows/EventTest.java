package windows;

import static com.fourthskyinteractive.dx4j.windows.kernel32.Kernel32.*;

import org.junit.Test;

import com.fourthskyinteractive.dx4j.windows.HANDLE;


public class EventTest {

	@Test
	public void testEvent() {
		HANDLE handle = CreateEvent(null, 0, 0, null);
		SetEvent(handle);
		CloseHandle(handle);
	}
}
