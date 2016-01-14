package io.nadron.common.http.response;

import io.nadron.common.http.Request;
import io.nadron.common.http.Response;
import io.nadron.common.http.contenttype.MediaRange;
import io.nadron.common.http.serialization.SerializationProcessor;

import java.util.List;

public class ResponseProcessor {
	
	private SerializationProcessor serializer;
	private ResponseWrapper wrapper;

	public ResponseProcessor(SerializationProcessor serializer,
			ResponseWrapper wrapper) {
		super();
		this.serializer = serializer;
		this.wrapper = wrapper;
	}

	public SerializationProcessor getSerializer() {
		return serializer;
	}

	public ResponseWrapper getWrapper() {
		return wrapper;
	}

	public List<MediaRange> getSupportedMediaRanges() {
		return serializer.getSupportedMediaRanges();
	}

	public <T> T deserialize(Request request, Class<T> type) {
		return serializer.deserialize(request.getBody(), type);
	}

	public String serialize(Response response) {
		Object wrapped = wrapper.wrap(response);

		if (wrapped != null) {
			return serializer.serialize(wrapped);
		}

		return null;
	}
}
