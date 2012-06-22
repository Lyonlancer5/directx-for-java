package com.fourthskyinteractive.dx4j.d3dcompiler;

public class D3DCompilerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8365845589527592021L;
	private long code;
	
	public D3DCompilerException(String message, long code) {
		super(message);
		this.code = code;
	}
	
	public long getCode() {
		return code;
	}
}
