package io.nadron.extension.exception;

public class SFSRuntimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SFSRuntimeException() {
	}

	public SFSRuntimeException(String message) {
		super(message);
	}

	public SFSRuntimeException(Throwable t) {
		super(t);
	}
}