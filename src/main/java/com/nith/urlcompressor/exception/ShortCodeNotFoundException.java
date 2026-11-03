package com.nith.urlcompressor.exception;

public class ShortCodeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ShortCodeNotFoundException(String shortCode) {
		super("Short code not found: " + shortCode);
	}

}
