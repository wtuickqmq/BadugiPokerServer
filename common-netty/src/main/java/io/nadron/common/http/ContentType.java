package io.nadron.common.http;

import java.nio.charset.Charset;

public abstract class ContentType {
	
	public static final String ENCODING = "UTF-8";
	public static final Charset CHARSET = Charset.forName(ENCODING);

	public static final String CSS = "text/css; charset=" + ENCODING;
	public static final String HTML = "text/html; charset=" + ENCODING;
	public static final String JAVASCRIPT = "application/javascript; charset="
			+ ENCODING;
	public static final String JSON = "application/json; charset=" + ENCODING;
	public static final String TEXT_PLAIN = "text/plain; charset=" + ENCODING;
	public static final String XML = "application/xml; charset=" + ENCODING;

	private ContentType() {
		// prevents instantiation.
	}
}