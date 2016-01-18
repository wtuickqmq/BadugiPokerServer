package com.badugi.game.logic.model.vo.fb.newpay;

import java.io.Serializable;

public class PayDisputeVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HubVo hub;
	private String payment_id;
	private PayUpateEntry entry[];
	private String object;

	public HubVo getHub() {
		return hub;
	}

	public void setHub(HubVo hub) {
		this.hub = hub;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String paymentId) {
		payment_id = paymentId;
	}

	public PayUpateEntry[] getEntry() {
		return entry;
	}

	public void setEntry(PayUpateEntry[] entry) {
		this.entry = entry;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}
	
	
	
}
