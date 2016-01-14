package io.nadron.common.exception;

import io.nadron.common.http.Response;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1810995969641082808L;
	private static final HttpResponseStatus STATUS = HttpResponseStatus.INTERNAL_SERVER_ERROR;

	private HttpResponseStatus httpStatus;
	private Map<String, String> headers;

	// SECTION: CONSTRUCTORS

	public ServiceException() {
		this(STATUS);
	}

	public ServiceException(HttpResponseStatus status) {
		setHttpStatus(status);
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		this(STATUS, message);
	}

	public ServiceException(HttpResponseStatus status, String message) {
		super(message);
		setHttpStatus(status);
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		this(STATUS, cause);
	}

	public ServiceException(HttpResponseStatus status, Throwable cause) {
		super(cause);
		setHttpStatus(status);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		this(STATUS, message, cause);
	}

	/**
	 * @param internalServerError
	 * @param message
	 * @param cause
	 */
	public ServiceException(HttpResponseStatus status, String message,
			Throwable cause) {
		super(message, cause);
		setHttpStatus(status);
	}

	// SECTION: ACCESSORS - PUBLIC

	public HttpResponseStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Adds headers, etc. to the reponse, if required for the exception.
	 */
	public void augmentResponse(Response response) {
		if (hasHeaders()) {
			for (Entry<String, String> header : headers.entrySet()) {
				response.addHeader(header.getKey(), header.getValue());
			}
		}
	}

	public void setHeader(String name, String value) {
		if (headers == null) {
			headers = new HashMap<String, String>();
		}

		headers.put(name, value);
	}

	public boolean hasHeaders() {
		return (headers != null && !headers.isEmpty());
	}

	public String getHeader(String name) {
		return (headers == null ? null : headers.get(name));
	}

	// SECTION: MUTATORS - PRIVATE

	private void setHttpStatus(HttpResponseStatus status) {
		this.httpStatus = status;
	}

	// SECTION: CONVENIENCE - STATIC

	public static boolean isAssignableFrom(Throwable exception) {
		return ServiceException.class.isAssignableFrom(exception.getClass());
	}

}
