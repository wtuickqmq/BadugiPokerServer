package io.nadron.common.exception;

import io.netty.handler.codec.http.HttpResponseStatus;

public class ConflictException extends ServiceException {
	private static final long serialVersionUID = -8484662487466021563L;
	private static final HttpResponseStatus STATUS = HttpResponseStatus.CONFLICT;

	public ConflictException() {
		super(STATUS);
	}

	/**
	 * @param message
	 */
	public ConflictException(String message) {
		super(STATUS, message);
	}

	/**
	 * @param cause
	 */
	public ConflictException(Throwable cause) {
		super(STATUS, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConflictException(String message, Throwable cause) {
		super(STATUS, message, cause);
	}
}
