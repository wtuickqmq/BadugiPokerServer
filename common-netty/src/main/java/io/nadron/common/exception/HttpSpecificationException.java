package io.nadron.common.exception;

public class HttpSpecificationException extends ServiceException {
	private static final long serialVersionUID = 5138963744346247235L;

	public HttpSpecificationException() {
		super();
	}

	/**
	 * @param message
	 */
	public HttpSpecificationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public HttpSpecificationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public HttpSpecificationException(String message, Throwable cause) {
		super(message, cause);
	}
}
