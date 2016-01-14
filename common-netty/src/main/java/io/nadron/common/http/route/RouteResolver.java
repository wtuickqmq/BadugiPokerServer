package io.nadron.common.http.route;

import io.nadron.common.exception.MethodNotAllowedException;
import io.nadron.common.exception.NotFoundException;
import io.nadron.common.http.Request;
import io.nadron.common.util.Resolver;
import io.netty.handler.codec.http.HttpMethod;

import java.util.List;


public class RouteResolver implements Resolver<Action> {
	private RouteMapping routeMapping;

	public RouteResolver(RouteMapping routes) {
		super();
		this.routeMapping = routes;
	}

	public Route getNamedRoute(String name, HttpMethod method) {
		return routeMapping.getNamedRoute(name, method);
	}

	@Override
	public Action resolve(Request request) {
		Action action = routeMapping.getActionFor(
				request.getEffectiveHttpMethod(), request.getPath());

		if (action != null)
			return action;

		List<HttpMethod> allowedMethods = routeMapping
				.getAllowedMethods(request.getPath());

		if (allowedMethods != null && !allowedMethods.isEmpty()) {
			throw new MethodNotAllowedException(request.getUrl(),
					allowedMethods);
		}

		throw new NotFoundException("Unresolvable URL: " + request.getUrl());
	}
}
