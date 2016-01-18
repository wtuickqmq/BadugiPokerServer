package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class PaymentsGetItemsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5754647159106563668L;
	private String buyer;
	private String receiver;
	private String order_id;
	private String order_info;
	private String test_mode;
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
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String orderId) {
		order_id = orderId;
	}
	public String getOrder_info() {
		return order_info;
	}
	public void setOrder_info(String orderInfo) {
		order_info = orderInfo;
	}
	public String getTest_mode() {
		return test_mode;
	}
	public void setTest_mode(String testMode) {
		test_mode = testMode;
	}
	
	
}
