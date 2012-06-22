package com.fourthskyinteractive.dx4j.dxgi;

public class DXGIException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1137607257985787559L;
	private long code;
	
	public DXGIException(String message, long code) {
		super(message);
		this.code = code;
	}
	
	public long getCode() {
		return code;
	}
}
