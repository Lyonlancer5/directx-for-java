package com.fourthskyinteractive.dx4j.d2d1;

public class D2D1Exception extends RuntimeException {
	
	private int code;
	
	public D2D1Exception(String message, int code) {
		super(message);
		this.code = code;
	}
}
