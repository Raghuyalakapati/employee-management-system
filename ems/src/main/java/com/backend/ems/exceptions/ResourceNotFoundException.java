package com.backend.ems.exceptions;


public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String s) {
		super(s);
	}

}
