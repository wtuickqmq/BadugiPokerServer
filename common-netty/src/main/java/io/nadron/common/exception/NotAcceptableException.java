package io.nadron.common.exception;

import io.netty.handler.codec.http.HttpResponseStatus;

public class NotAcceptableException extends ServiceException {
	private static final long serialVersionUID = -5426407637827504114L;
	private static final HttpResponseStatus STATUS = HttpResponseStatus.NOT_ACCEPTABLE;

	public NotAcceptableException() {
		super(STATUS);
	}

	public NotAcceptableException(String message, Throwable cause) {
		super(STATUS, message, cause);
	}

	public NotAcceptableException(String message) {
		super(STATUS, message);
	}

	public NotAcceptableException(Throwable cause) {
		super(STATUS, cause);
	}
}
