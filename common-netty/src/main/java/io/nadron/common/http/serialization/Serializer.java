package io.nadron.common.http.serialization;

import io.nadron.common.http.contenttype.MediaRange;

import java.util.List;

public interface Serializer {
	public String serialize(Object object);

	public List<MediaRange> getSupportedMediaRanges();

	public List<String> getSupportedFormats();
}
