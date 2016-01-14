package io.nadron.common.http.serialization;

import io.nadron.common.http.Request;
import io.nadron.common.http.Response;
import io.nadron.common.http.response.ResponseProcessor;
import io.netty.handler.codec.http.HttpHeaders;

public class SerializationSettings {
	private String mediaType;
	private ResponseProcessor processor;

	public SerializationSettings(String mediaType, ResponseProcessor processor) {
		super();
		this.mediaType = mediaType;
		this.processor = processor;
	}

	public String getMediaType() {
		return mediaType;
	}

	public ResponseProcessor getResponseProcessor() {
		return processor;
	}

	public <T> T deserialize(Request request, Class<T> type) {
		return processor.deserialize(request, type);
	}

	public String serialize(Response response) {
		if (!response.hasHeader(HttpHeaders.Names.CONTENT_TYPE)) {
			response.setContentType(mediaType);
		}

		return processor.serialize(response);
	}
}
