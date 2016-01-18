package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class PayCallBackVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6201454230048706669L;
	private String signed_request;
	private String order_details;
	private String status ;
	private String order_id;
	private String method;
	private String buyer;
	private String receiver;
	private String order_info;
	public String getSigned_request() {
		return signed_request;
	}
	public void setSigned_request(String signedRequest) {
		signed_request = signedRequest;
	}
	public String getOrder_details() {
		return order_details;
	}
	public void setOrder_details(String orderDetails) {
		order_details = orderDetails;
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
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getOrder_info() {
		return order_info;
	}
	public void setOrder_info(String orderInfo) {
		order_info = orderInfo;
	}
	
	
}
