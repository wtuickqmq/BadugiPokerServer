package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * Ordershistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ordershistory")
public class Ordershistory extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long id;
	private Long orderId;
	private Long fbOrderId;
	private Integer status;
	private Timestamp inputTime;
	private String requestid;

	// Constructors

	/** default constructor */
	public Ordershistory() {
	}

	/** full constructor */
	public Ordershistory(Long orderId, Long fbOrderId, Integer status,
			Timestamp inputTime) {
		this.orderId = orderId;
		this.fbOrderId = fbOrderId;
		this.status = status;
		this.inputTime = inputTime;
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

	@Column(name = "orderId")
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "fbOrderId")
	public Long getFbOrderId() {
		return this.fbOrderId;
	}

	public void setFbOrderId(Long fbOrderId) {
		this.fbOrderId = fbOrderId;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "inputTime", length = 19)
	public Timestamp getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}
	
	@Column(name = "requestid", nullable = false, scale = 50)
	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}
	
	@PrePersist
	public void prePersist(){
		this.inputTime = (this.inputTime == null ? new Timestamp(System.currentTimeMillis()) : this.inputTime);
	}

}