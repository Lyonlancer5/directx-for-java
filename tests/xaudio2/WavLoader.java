package xaudio2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
//import java.nio.file.Paths;

import org.bridj.Pointer;

import com.fourthskyinteractive.dx4j.util.WAVEFORMATEX;
import com.fourthskyinteractive.dx4j.xaudio2.XAUDIO2_BUFFER;

//import static java.nio.file.StandardOpenOption.*;
import static com.fourthskyinteractive.dx4j.xaudio2.XAudio2.*;

public class WavLoader {

	private WAVEFORMATEX waveFormat = new WAVEFORMATEX();
	private XAUDIO2_BUFFER xaBuffer = new XAUDIO2_BUFFER();
	private Pointer<Byte> waveData;
	
	public WavLoader() {
		
	}
	
	public WavLoader(String fileName) {
		load(fileName);
	}
	
	public boolean load(String fileName) {
		if (fileName == null || "".equals(fileName)) {
			return false;
		}
		
		FileChannel file = null;
		try {
			//file = FileChannel.open(Paths.get(fileName), READ);
			file = new FileInputStream(fileName).getChannel();
			ByteBuffer value = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder());
		
			int dwChunkId = 0, dwFileSize = 0, dwChunkSize = 0, dwExtra = 0;
			
			//look for 'RIFF' chunk identifier
			file.read(value);
			dwChunkId = ((ByteBuffer) value.rewind()).getInt();
			if (dwChunkId != fourCCRIFF) {
				file.close();
				return false;
			}
			
			// Get file size
			file.read((ByteBuffer) value.rewind());
			dwFileSize = ((ByteBuffer) value.rewind()).getInt();
			if (dwFileSize <= 16) {
				file.close();
				return false;
			}
			
			// Get file format
			file.read((ByteBuffer) value.rewind());
			dwExtra = ((ByteBuffer) value.rewind()).getInt();
			if (dwExtra != fourCCWAVE) {
				file.close();
				return false;
			}
			
			// Look for 'fmt ' chunk id
			boolean bFilledFormat = false;
			int bytesRead = 0;
			while(bytesRead != -1) {
				bytesRead = file.read((ByteBuffer) value.rewind());
				dwChunkId = ((ByteBuffer) value.rewind()).getInt();
				bytesRead = file.read((ByteBuffer) value.rewind());
				dwChunkSize = ((ByteBuffer) value.rewind()).getInt();
				if (dwChunkId == fourCCFMT) {
					ByteBuffer wfBuffer = Pointer.pointerTo(waveFormat)
												 .getByteBuffer();
					wfBuffer.limit(wfBuffer.capacity() - 4);
					bytesRead = file.read(wfBuffer);
					waveFormat.cbSize((short) 0);
					
					bFilledFormat = true;
					break;
				}
			}
			if(!bFilledFormat)
			{
				file.close();
				return false;
			}
			
			// Look for 'data' chunk id
			boolean bFilledData = false;
			while(bytesRead != -1) {
				bytesRead = file.read((ByteBuffer) value.rewind());
				dwChunkId = ((ByteBuffer) value.rewind()).getInt();
				bytesRead = file.read((ByteBuffer) value.rewind());
				dwChunkSize = ((ByteBuffer) value.rewind()).getInt();
				if (dwChunkId == fourCCDATA) {
					waveData = Pointer.allocateBytes(dwChunkSize);
					bytesRead = file.read(waveData.getByteBuffer());
					
					xaBuffer.AudioBytes(dwChunkSize)
							.pAudioData(waveData)
							.PlayBegin(0)
							.PlayLength(0);
					
					bFilledData = true;
					break;
				}
			}
			
			if (!bFilledData) {
				file.close();
				return false;
			}
			
			file.close();
			return true;
		} catch (IOException ex) {
			try {
				file.close();
			} catch (IOException e) {
				
			}
			
			return false;
		}
	}
	
	public WAVEFORMATEX getWaveFormat() {
		return waveFormat;
	}
	
	public XAUDIO2_BUFFER getXaBuffer() {
		return xaBuffer;
	}
}

