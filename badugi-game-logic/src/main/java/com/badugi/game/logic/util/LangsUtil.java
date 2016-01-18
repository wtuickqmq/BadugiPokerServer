package com.badugi.game.logic.util;

import java.util.Locale;

public final class LangsUtil {

	public static final String getMessage(String code, Object[] args) {
		Locale locale = Locale.getDefault();
		return getMessage(code, args, locale);
	}

	public static final String getMessage(String code) {
		Locale locale = Locale.getDefault();
		return getMessage(code, null, locale);
	}

	public static final String getMessage(String code, String defaultMessage, Object[] args) {
		Locale locale = Locale.getDefault();
		return getMessage(code, args, defaultMessage, locale);
	}

	public static final String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		return AppContext.getMessage(code, args, defaultMessage, locale);
	}

	public static final String getMessage(String code, Object[] args, Locale locale) {
		return AppContext.getMessage(code, args, locale);
	}

}
