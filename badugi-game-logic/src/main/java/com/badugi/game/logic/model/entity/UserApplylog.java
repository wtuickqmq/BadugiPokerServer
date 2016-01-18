package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserApplylog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_applylog")
public class UserApplylog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer applyId;
	private Long fbId;
	private Double oldAmount;
	private Double amount;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public UserApplylog() {
	}

	/** full constructor */
	public UserApplylog(Integer applyId, Long fbId, Double oldAmount,
			Double amount, Timestamp createTime) {
		this.applyId = applyId;
		this.fbId = fbId;
		this.oldAmount = oldAmount;
		this.amount = amount;
		this.createTime = createTime;
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

	@Column(name = "ApplyID", nullable = false)
	public Integer getApplyId() {
		return this.applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "OldAmount", nullable = false, scale = 4)
	public Double getOldAmount() {
		return this.oldAmount;
	}

	public void setOldAmount(Double oldAmount) {
		this.oldAmount = oldAmount;
	}

	@Column(name = "Amount", nullable = false, scale = 4)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}