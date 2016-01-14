package io.nadron.common.util;

public class ExceptionUtil {
	// Prevents instantiation.
	private ExceptionUtil() {
	}

	/**
	 * Traverses throwable.getCause() up the chain until the root cause is
	 * found.
	 * 
	 * @param throwable
	 * @return the root cause. Never null, unless throwable is null.
	 */
	public static Throwable findRootCause(Throwable throwable) {
		Throwable cause = throwable;
		Throwable rootCause = null;

		while (cause != null) {
			rootCause = cause;
			cause = cause.getCause();
		}

		return rootCause;
	}
}
