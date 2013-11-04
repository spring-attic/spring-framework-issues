package org.springframework.issues.exceptions;

public class CheckedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CheckedException() {
	}

	public CheckedException(String arg0) {
		super(arg0);
	}

	public CheckedException(Throwable arg0) {
		super(arg0);
	}

	public CheckedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}