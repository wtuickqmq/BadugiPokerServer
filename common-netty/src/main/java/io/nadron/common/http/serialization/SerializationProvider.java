package io.nadron.common.http.serialization;

import io.nadron.common.http.Request;
import io.nadron.common.http.Response;
import io.nadron.common.http.response.ResponseWrapper;

public interface SerializationProvider extends Aliasable {
	
	public void add(SerializationProcessor processor, ResponseWrapper wrapper);

	public void add(SerializationProcessor processor, ResponseWrapper wrapper,
			boolean isDefault);

	public void setDefaultFormat(String format);

	public SerializationSettings resolveRequest(Request request);

	public SerializationSettings resolveResponse(Request request,
			Response response, boolean shouldForce);
}
