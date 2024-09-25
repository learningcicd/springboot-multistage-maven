package com.service.app.exception;

public class InputValidationException extends RuntimeException {

	public InputValidationException() {
		super();
	}

	/**
	 * @param arg0
	 *            message
	 */
	public InputValidationException(String arg0) {
		super(arg0);
	}

}
