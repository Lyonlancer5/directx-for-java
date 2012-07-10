package com.fourthskyinteractive.dx4j.d3d11;

public class D3D11Exception extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3315835539551010666L;
	private long code;
	
	public D3D11Exception(String message, long code) {
		super(message);
		this.code = code;
	}
	
	public long getCode() {
		return code;
	}
}
