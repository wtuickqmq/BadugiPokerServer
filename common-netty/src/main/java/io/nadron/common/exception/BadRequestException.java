package io.nadron.common.exception;

import io.netty.handler.codec.http.HttpResponseStatus;

public class BadRequestException extends ServiceException {
	private static final long serialVersionUID = 1322585725650252682L;

	public BadRequestException() {
		super(HttpResponseStatus.BAD_REQUEST);
	}

	/**
	 * @param message
	 */
	public BadRequestException(String message) {
		super(HttpResponseStatus.BAD_REQUEST, message);
	}

	/**
	 * @param cause
	 */
	public BadRequestException(Throwable cause) {
		super(HttpResponseStatus.BAD_REQUEST, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BadRequestException(String message, Throwable cause) {
		super(HttpResponseStatus.BAD_REQUEST, message, cause);
	}
}
