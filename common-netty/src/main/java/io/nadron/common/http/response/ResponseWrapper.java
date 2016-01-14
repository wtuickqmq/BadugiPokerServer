package io.nadron.common.http.response;

import io.nadron.common.http.Response;

public interface ResponseWrapper {
	
	public Object wrap(Response response);
	
	public boolean addsBodyContent();
	
}
