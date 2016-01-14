package io.nadron.common.http.route;

import io.nadron.common.http.Request;
import io.nadron.common.http.Response;
import io.nadron.common.http.url.UrlMatch;

import java.util.Collection;
import java.util.Map.Entry;

public class Action {
	
	private Route route;
	private UrlMatch match;

	public Action(Route route, UrlMatch match) {
		super();
		this.route = route;
		this.match = match;
	}

	public Route getRoute() {
		return route;
	}

	/**
	 * Returns whether the underlying Route should serialize the response.
	 * 
	 * @return
	 */
	public boolean shouldSerializeResponse() {
		return getRoute().shouldSerializeResponse();
	}

	/**
	 * Invokes the underlying Route, returning the result of the call, if any.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public Object invoke(Request request, Response response) {
		return getRoute().invoke(request, response);
	}

	/**
	 * Retrieves the parameters from the URL match. These are used as Request
	 * headers before invocation of the route.
	 * 
	 * @return a Collection of Map Entry name/value pairs to be used for
	 *         headers.
	 */
	public Collection<Entry<String, String>> getParameters() {
		return match.parameterSet();
	}

	public String getParameter(String key) {
		return match.get(key);
	}
}
