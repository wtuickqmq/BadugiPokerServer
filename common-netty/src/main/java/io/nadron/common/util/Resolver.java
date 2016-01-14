package io.nadron.common.util;

import io.nadron.common.http.Request;

/**
 * A Resolver is responsible for determining which object is appropriate for a given request.
 */
public interface Resolver<T> {
	
	public T resolve(Request request);
	
}
