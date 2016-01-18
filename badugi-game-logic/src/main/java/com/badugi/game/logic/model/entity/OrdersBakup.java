package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders_bakup")
public class OrdersBakup extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long id;
	private Long orderId;
	private Long fbOrderId;
	private Integer itemId;
	private Long buyer;
	private Long receiver;
	private Long app;
	private String currency;
	private Integer count;
	private Double amount;
	private Timestamp timePlaced;
	private String properties;
	private Timestamp updateTime;
	private String data;
	private Short status;
	private String testMode;
	private String source;
	private Timestamp inputTime;
	private Double chips;
	private Timestamp confirmTime;
	private Double extrachips;
	private String requestid;
	private Double useramount;
	private Short isfirst;

	// Constructors

	/** default constructor */
	public OrdersBakup() {
	}

	/** minimal constructor */
	public OrdersBakup(Long orderId, Long fbOrderId, Integer itemId, Long buyer,
			Long receiver, Short status) {
		this.orderId = orderId;
		this.fbOrderId = fbOrderId;
		this.itemId = itemId;
		this.buyer = buyer;
		this.receiver = receiver;
		this.status = status;
	}

	/** full constructor */
	public OrdersBakup(Long orderId, Long fbOrderId, Integer itemId, Long buyer,
			Long receiver, Long app, String currency, Integer count,
			Double amount, Timestamp timePlaced, String properties,
			Timestamp updateTime, String data, Short status, String testMode,
			String source, Timestamp inputTime, Double chips) {
		this.orderId = orderId;
		this.fbOrderId = fbOrderId;
		this.itemId = itemId;
		this.buyer = buyer;
		this.receiver = receiver;
		this.app = app;
		this.currency = currency;
		this.count = count;
		this.amount = amount;
		this.timePlaced = timePlaced;
		this.properties = properties;
		this.updateTime = updateTime;
		this.data = data;
		this.status = status;
		this.testMode = testMode;
		this.source = source;
		this.inputTime = inputTime;
		this.chips = chips;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "orderId", nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "fbOrderId", nullable = false)
	public Long getFbOrderId() {
		return this.fbOrderId;
	}

	public void setFbOrderId(Long fbOrderId) {
		this.fbOrderId = fbOrderId;
	}

	@Column(name = "itemId", nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "buyer", nullable = false)
	public Long getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

	@Column(name = "receiver", nullable = false)
	public Long getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	@Column(name = "app")
	public Long getApp() {
		return this.app;
	}

	public void setApp(Long app) {
		this.app = app;
	}

	@Column(name = "currency", length = 50)
	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "amount")
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "timePlaced", length = 19)
	public Timestamp getTimePlaced() {
		return this.timePlaced;
	}

	public void setTimePlaced(Timestamp timePlaced) {
		this.timePlaced = timePlaced;
	}

	@Column(name = "properties", length = 50)
	public String getProperties() {
		return this.properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	@Column(name = "updateTime", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "data", length = 100)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "testMode", length = 20)
	public String getTestMode() {
		return this.testMode;
	}

	public void setTestMode(String testMode) {
		this.testMode = testMode;
	}

	@Column(name = "source", length = 100)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "inputTime", length = 19)
	public Timestamp getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	@Column(name = "chips")
	public Double getChips() {
		return this.chips;
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
	
	
}