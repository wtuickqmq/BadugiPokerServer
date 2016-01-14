package io.nadron.common.exception;

import io.netty.handler.codec.http.HttpResponseStatus;

public class NotFoundException extends ServiceException {
	private static final long serialVersionUID = -8484662487466021563L;
	private static final HttpResponseStatus STATUS = HttpResponseStatus.NOT_FOUND;

	public NotFoundException() {
		super(STATUS);
	}

	/**
	 * @param message
	 */
	public NotFoundException(String message) {
		super(STATUS, message);
	}

	/**
	 * @param cause
	 */
	public NotFoundException(Throwable cause) {
		super(STATUS, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotFoundException(String message, Throwable cause) {
		super(STATUS, message, cause);
	}
}
