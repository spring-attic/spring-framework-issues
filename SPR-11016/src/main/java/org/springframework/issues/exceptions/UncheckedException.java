package org.springframework.issues.exceptions;

public class UncheckedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UncheckedException() {
	}

	public UncheckedException(String arg0) {
		super(arg0);
	}

	public UncheckedException(Throwable arg0) {
		super(arg0);
	}

	public UncheckedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}