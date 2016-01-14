package io.nadron.common.exception;

import io.nadron.common.http.Response;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.util.Collections;
import java.util.List;

import com.joker.common.util.StringUtil;

public class MethodNotAllowedException extends ServiceException {
	private static final long serialVersionUID = 4116758162425337982L;
	private static final HttpResponseStatus STATUS = HttpResponseStatus.METHOD_NOT_ALLOWED;

	private List<HttpMethod> allowedMethods;

	public MethodNotAllowedException(List<HttpMethod> allowed) {
		super(STATUS);
		setAllowedMethods(allowed);
	}

	/**
	 * @param message
	 */
	public MethodNotAllowedException(String message, List<HttpMethod> allowed) {
		super(STATUS, message);
		setAllowedMethods(allowed);
	}

	/**
	 * @param cause
	 */
	public MethodNotAllowedException(Throwable cause, List<HttpMethod> allowed) {
		super(STATUS, cause);
		setAllowedMethods(allowed);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MethodNotAllowedException(String message, Throwable cause,
			List<HttpMethod> allowed) {
		super(STATUS, message, cause);
		setAllowedMethods(allowed);
	}

	public void setAllowedMethods(List<HttpMethod> allowed) {
		this.allowedMethods = Collections.unmodifiableList(allowed);
	}

	public List<HttpMethod> getAllowedMethods() {
		return allowedMethods;
	}

	/**
	 * Adds Allow HTTP header to the response with a list of the appropriate
	 * HTTP methods for the route.
	 */
	@Override
	public void augmentResponse(Response response) {
		response.addHeader(HttpHeaders.Names.ALLOW,
				StringUtil.join(",", getAllowedMethods()));
	}
}
