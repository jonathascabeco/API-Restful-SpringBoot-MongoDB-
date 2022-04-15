package com.jonathascabeco.stswebservicesproject.services.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExceptions(String msg) {
		super(msg);
	}
}
