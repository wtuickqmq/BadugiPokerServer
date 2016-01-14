package io.nadron.common.exception;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements a user-defined mapping from Throwables to ServiceExceptions so
 * clients can utilize Libraries that throw checked exceptions and map those
 * into a ServiceException that will return an HTTP status code.
 */
public class ExceptionMapping {
	private Map<Class<? extends Throwable>, Class<? extends ServiceException>> exceptions = new HashMap<Class<? extends Throwable>, Class<? extends ServiceException>>();

	public <T extends Throwable, U extends ServiceException> void map(
			Class<T> inExceptionClass, Class<U> outExceptionClass) {
		exceptions.put(inExceptionClass, outExceptionClass);
	}

	public ServiceException getExceptionFor(Throwable throwable) {
		Class<?> mapped = exceptions.get(throwable.getClass());

		if (mapped != null) {
			try {
				Constructor<?> constructor = mapped.getConstructor(
						String.class, Throwable.class);
				return (ServiceException) constructor.newInstance(
						throwable.getMessage(), throwable);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
