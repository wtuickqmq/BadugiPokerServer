package com.badugi.game.logic.model.vo.fb.newpay;

import java.io.Serializable;

public class PayCallBackNewVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String payment_id;
	private String amount;
	private String currency ;
	private String quantity;
	private String status;
	private String signed_request;
	private Long error_code;
	private String error_message;
	//下面是动态获取金额
	private String method;
	private String product;
	private String user_currency;
	private String request_id;
	public String getSigned_request() {
		return signed_request;
	}
	public void setSigned_request(String signedRequest) {
		signed_request = signedRequest;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String paymentId) {
		payment_id = paymentId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getUser_currency() {
		return user_currency;
	}
	public void setUser_currency(String userCurrency) {
		user_currency = userCurrency;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String requestId) {
		request_id = requestId;
	}
	public Long getError_code() {
		return error_code;
	}
	public void setError_code(Long errorCode) {
		error_code = errorCode;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String errorMessage) {
		error_message = errorMessage;
	}
	
	
}
