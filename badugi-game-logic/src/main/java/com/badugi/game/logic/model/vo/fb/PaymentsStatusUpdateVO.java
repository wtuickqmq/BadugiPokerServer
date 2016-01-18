package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class PaymentsStatusUpdateVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3247636944279753269L;

	private String order_details;
	private String source;
	private String status;
	private String order_id;
	private String test_mode;
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
	public String getTest_mode() {
		return test_mode;
	}
	public void setTest_mode(String testMode) {
		test_mode = testMode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	

}
