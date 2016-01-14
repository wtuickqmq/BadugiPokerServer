package io.nadron.common.exception;

import io.netty.handler.codec.http.HttpResponseStatus;

public class ForbiddenException extends ServiceException {
	private static final long serialVersionUID = -8484662487466021563L;
	private static final HttpResponseStatus STATUS = HttpResponseStatus.FORBIDDEN;

	public ForbiddenException() {
		super(STATUS);
	}

	/**
	 * @param message
	 */
	public ForbiddenException(String message) {
		super(STATUS, message);
	}

	/**
	 * @param cause
	 */
	public ForbiddenException(Throwable cause) {
		super(STATUS, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ForbiddenException(String message, Throwable cause) {
		super(STATUS, message, cause);
	}
}
