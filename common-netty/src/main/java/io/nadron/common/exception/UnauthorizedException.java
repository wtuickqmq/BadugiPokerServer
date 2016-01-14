package io.nadron.common.exception;

import io.netty.handler.codec.http.HttpResponseStatus;

public class UnauthorizedException extends ServiceException {
	private static final long serialVersionUID = -4052865315153249126L;
	private static final HttpResponseStatus STATUS = HttpResponseStatus.UNAUTHORIZED;

	public UnauthorizedException() {
		super(STATUS);
	}

	/**
	 * @param message
	 */
	public UnauthorizedException(String message) {
		super(STATUS, message);
	}

	/**
	 * @param cause
	 */
	public UnauthorizedException(Throwable cause) {
		super(STATUS, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnauthorizedException(String message, Throwable cause) {
		super(STATUS, message, cause);
	}
}
