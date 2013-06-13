package sapi;
import org.bridj.Pointer;
import org.bridj.cpp.com.COMRuntime;

import com.fourthskyinteractive.dx4j.sapi.ISpAudio;
import com.fourthskyinteractive.dx4j.sapi.ISpRecoContext;
import com.fourthskyinteractive.dx4j.sapi.ISpRecognizer;
import com.fourthskyinteractive.dx4j.sapi.SAPI;


public class TestsSAPI {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		int hr = COMRuntime.S_OK;
		ISpRecognizer recognizer = null;
		ISpRecoContext context = null;
		ISpAudio audioObject = null;
		
		// Create recognizer
		recognizer = COMRuntime.newInstance(ISpRecognizer.class);

		// Create context
		Pointer<Pointer<ISpRecoContext>> ppContext = Pointer.allocatePointer(ISpRecoContext.class);
		hr = recognizer.CreateRecoContext(ppContext);
		if (hr != COMRuntime.S_OK) {
			System.exit(1);
		}
		context = ppContext.get().getNativeObject(ISpRecoContext.class);
		
		// Configure context
		hr = context.SetNotifyWin32Event();
		
		// Get audio object
		audioObject = SAPI.GetAudioObject(SAPI.SPCAT_AUDIOIN);
		
		
		// Release COM objects
		audioObject.Release();
		context.Release();
		recognizer.Release();
	}

}
