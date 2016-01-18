package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class GenBackVO extends OrderInfoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7549213398636557173L;
	private String method;
	
	private String status;
	private String order_id;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String orderId) {
		order_id = orderId;
	}
	
	
}
