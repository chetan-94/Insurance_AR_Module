package com.App.exception;

public class RegistrationAppException extends RuntimeException {
	public RegistrationAppException() {

	}
	
	public RegistrationAppException(String message) {
		super(message);
	}
}
