package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoldExchangeLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gold_exchange_log")
public class GoldExchangeLog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbId;
	private Integer itemId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public GoldExchangeLog() {
	}

	/** full constructor */
	public GoldExchangeLog(Long fbId, Integer itemId, Timestamp createTime) {
		this.fbId = fbId;
		this.itemId = itemId;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "ItemId", nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}