package com.badugi.game.logic.model.vo.fb.newpay;

import java.io.Serializable;

public class RqPaymentsGetItemsNewVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5754647159106563668L;
	private String algorithm;
	private String amount;
	private String currency;
	private String issued_at;
	private String quantity;
	private String payment_id;
	private String status;
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
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
	public String getIssued_at() {
		return issued_at;
	}
	public void setIssued_at(String issuedAt) {
		issued_at = issuedAt;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String paymentId) {
		payment_id = paymentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
