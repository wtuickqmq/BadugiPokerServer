package io.nadron.common.http;

/**
 * Constants for built-in RestExpress parameters on routes.
 */
public abstract class Parameters {
	
	public static final class Cache {
		public static final String MAX_AGE = "max.age";
	}

	public static final class Query {
		public static final String METHOD_TUNNEL = "_method";
		public static final String FORMAT = "format";
	}

	private Parameters() {
		// prevents instantiation.
	}
}
