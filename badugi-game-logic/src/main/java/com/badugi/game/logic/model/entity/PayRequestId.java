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
 * Guess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "payrequestid")
public class PayRequestId extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String requestid;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public PayRequestId() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "requestid", nullable = false, scale = 50)
	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}
	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@PrePersist
	public void prePersist(){
		this.createTime = (this.createTime == null ? new Timestamp(System.currentTimeMillis()) : this.createTime);
	}
	

	

}