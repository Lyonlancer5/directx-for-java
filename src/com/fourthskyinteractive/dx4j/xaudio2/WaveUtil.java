package com.fourthskyinteractive.dx4j.xaudio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bridj.Pointer;

import com.fourthskyinteractive.dx4j.coreaudio.WAVEFORMATEX;

public class WaveUtil {

	private WAVEFORMATEX m_wf;
	XAUDIO2_BUFFER m_xa;
	Pointer<Byte> m_waveData;
	
	public WaveUtil(String fileName) {
		load(fileName);
	}
	
	private static final int FFIR = 'F' << 24 | 'F' << 16 | 'I' << 8 | 'R';
	private static final int EVAW = 'E' << 24 | 'V' << 16 | 'A' << 8 | 'W';
	private static final int tmf = ' ' << 24 | 't' << 16 | 'm' << 8 | 'f';
	public boolean load(String filename) {
		if (filename == null || "".equals(filename))
			return false;
		
		try {
			FileInputStream inFile = new FileInputStream(filename);
			int dwChunkId = 0, dwFileSize = 0, dwChunkSize = 0, dwExtra = 0;
		
			//look for 'RIFF' chunk identifier
			dwChunkId = inFile.read();
			if (dwChunkId != FFIR) {
				inFile.close();
				return false;
			}
			
			//get file size
			dwFileSize = inFile.read();
			if (dwFileSize <= 16) {
				inFile.close();
				return false;
			}
			
			//get file format
			dwExtra = inFile.read();
			if (dwExtra != EVAW) {
				inFile.close();
				return false;
			}
			
			//look for 'fmt ' chunk id
			boolean bFilledFormat = false;
			
		
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	public WAVEFORMATEX wf() { return m_wf; }
	public XAUDIO2_BUFFER xaBuffer() { return m_xa; }
}
