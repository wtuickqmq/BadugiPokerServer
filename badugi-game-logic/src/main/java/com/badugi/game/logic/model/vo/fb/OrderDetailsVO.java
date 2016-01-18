package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class OrderDetailsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4958285093526586642L;

	private String order_id;
	private String buyer;
	private String app;
	private String receiver;
	private String currency;
	private String amount;
	private String time_placed;
	private String properties;
	private String update_time;
	private String data;
	private String ref_order_id;
	private OrderInfoVO[] items;
	private String status;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String orderId) {
		order_id = orderId;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTime_placed() {
		return time_placed;
	}
	public void setTime_placed(String timePlaced) {
		time_placed = timePlaced;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String updateTime) {
		update_time = updateTime;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getRef_order_id() {
		return ref_order_id;
	}
	public void setRef_order_id(String refOrderId) {
		ref_order_id = refOrderId;
	}
	public OrderInfoVO[] getItems() {
		return items;
	}
	public void setItems(OrderInfoVO[] items) {
		this.items = items;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
