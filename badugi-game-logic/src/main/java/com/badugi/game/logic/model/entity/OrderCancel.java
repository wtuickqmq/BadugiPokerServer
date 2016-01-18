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
 * StatRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ordercancel")
public class OrderCancel extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public OrderCancel() {
	}

	

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@PrePersist
	public void prePersist(){
		this.createTime = (this.createTime == null ? new Timestamp(System.currentTimeMillis()) : this.createTime);
	}
}