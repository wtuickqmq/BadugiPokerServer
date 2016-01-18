package com.badugi.game.logic.model.vo.fb.newpay;

public class UserGetDynamicPaymentVo {

	private String product;
	private Integer quantity;
	private String user_currency;
	private String request_id;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	
	
}
