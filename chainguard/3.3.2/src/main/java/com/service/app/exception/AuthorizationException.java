package com.service.app.exception;

public class AuthorizationException extends RuntimeException {

	public String errorCode;

	public String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public AuthorizationException(String errorCode, String message) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}
}