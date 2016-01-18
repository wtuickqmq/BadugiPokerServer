package com.badugi.game.logic.model.callback;

public class RPCCall {

	private String method;

	private Object object;

	public RPCCall(){}
	
	public RPCCall(String method,Object object){
		this.method = method;
		this.object = object;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
