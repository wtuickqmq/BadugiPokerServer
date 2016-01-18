package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;


/**
 * 
* 项目名称：qq1.0   
* 类名称：Order   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Nov 12, 2012 1:51:21 PM    
* @version 1.0
 */
@Entity
@Table(name = "orders")
public class OrderInfo extends BaseEntity implements Serializable{

	
	public OrderInfo(){
		
	}
	public Integer id;
	public Long orderId;
	public Long fbOrderId;
	public Integer item_id;
	public Long buyer;
	public Long receiver;
	public Long app;
	public String currency;
	public Integer count;
	public Double amount;
	public Timestamp time_placed;
	public Timestamp update_time;
	public String properties;
	public String data;
	public Integer status;
	public String test_mode;
	public String source;
	public Timestamp inputTime;
	public Double chips;
	public Timestamp confirmTime;
	private Double extrachips;
	private String requestid;
	private Double useramount;
	private Short isfirst;

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "orderId")
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	@Column(name = "fbOrderId")
	public Long getFbOrderId() {
		return fbOrderId;
	}
	public void setFbOrderId(Long fbOrderId) {
		this.fbOrderId = fbOrderId;
	}
	
	@Column(name = "itemId")
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer itemId) {
		item_id = itemId;
	}
	
	@Column(name = "buyer")
	public Long getBuyer() {
		return buyer;
	}
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}
	
	@Column(name = "receiver")
	public Long getReceiver() {
		return receiver;
	}
	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}
	
	@Column(name = "app")
	public Long getApp() {
		return app;
	}
	public void setApp(Long app) {
		this.app = app;
	}
	
	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Column(name = "count")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@Column(name = "amount")
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Column(name = "timePlaced")
	public Timestamp getTime_placed() {
		return time_placed;
	}
	public void setTime_placed(Timestamp timePlaced) {
		time_placed = timePlaced;
	}
	
	@Column(name = "updateTime")
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp updateTime) {
		update_time = updateTime;
	}
	
	@Column(name = "properties")
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	
	@Column(name = "data")
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(name = "testMode")
	public String getTest_mode() {
		return test_mode;
	}
	public void setTest_mode(String testMode) {
		test_mode = testMode;
	}
	
	@Column(name = "source")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(name = "inputTime")
	public Timestamp getInputTime() {
		return inputTime;
	}
	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}
	
	@Column(name = "chips")
	public Double getChips() {
		return chips;
	}
	public void setChips(Double chips) {
		this.chips = chips;
	}
	
	@Column(name = "confirmTime")
	public Timestamp getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Timestamp confirmTime) {
		this.confirmTime = confirmTime;
	}
	@Column(name = "extrachips")
	public Double getExtrachips() {
		return extrachips;
	}
	public void setExtrachips(Double extrachips) {
		this.extrachips = extrachips;
	}
	@Column(name = "requestid", nullable = false, scale = 50)
	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}
	
	@Column(name = "useramount")
	public Double getUseramount() {
		return useramount;
	}
	public void setUseramount(Double useramount) {
		this.useramount = useramount;
	}
	
	@Column(name = "isfirst")
	public Short getIsfirst() {
		return isfirst;
	}

	public void setIsfirst(Short isfirst) {
		this.isfirst = isfirst;
	}
	
	@PrePersist
	public void prePersist(){
		this.inputTime = (this.inputTime == null ? new Timestamp(System.currentTimeMillis()) : this.inputTime);
	}
}
