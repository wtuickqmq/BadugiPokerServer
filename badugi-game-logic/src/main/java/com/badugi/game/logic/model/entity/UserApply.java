package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserApply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_apply")
public class UserApply extends BaseEntity implements java.io.Serializable {

	/**
	 * 是否返还(1 是)
	 */
	public static final Short RETURN_TRUE = 1;
	
	/**
	 * 是否返还(0 否)
	 */
	public static final Short RETURN_FALSE = 0;
	// Fields

	private Integer applyId;
	private Long fbId;
	private Double initAmount;
	private Timestamp createTime;
	private Short isReturn;
	private Double resultAmount;
	private Timestamp returnTime;
	private Double maxWin;
	private Double maxLose;

	// Constructors

	/** default constructor */
	public UserApply() {
	}

	/** minimal constructor */
	public UserApply(Long fbId, Double initAmount, Timestamp createTime,
			Short isReturn) {
		this.fbId = fbId;
		this.initAmount = initAmount;
		this.createTime = createTime;
		this.isReturn = isReturn;
	}

	/** full constructor */
	public UserApply(Long fbId, Double initAmount, Timestamp createTime,
			Short isReturn, Double resultAmount, Timestamp returnTime,
			Double maxWin, Double maxLose) {
		this.fbId = fbId;
		this.initAmount = initAmount;
		this.createTime = createTime;
		this.isReturn = isReturn;
		this.resultAmount = resultAmount;
		this.returnTime = returnTime;
		this.maxWin = maxWin;
		this.maxLose = maxLose;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ApplyID", unique = true, nullable = false)
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

	@Column(name = "InitAmount", nullable = false, scale = 4)
	public Double getInitAmount() {
		return this.initAmount;
	}

	public void setInitAmount(Double initAmount) {
		this.initAmount = initAmount;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "IsReturn", nullable = false)
	public Short getIsReturn() {
		return this.isReturn;
	}

	public void setIsReturn(Short isReturn) {
		this.isReturn = isReturn;
	}

	@Column(name = "ResultAmount", scale = 4)
	public Double getResultAmount() {
		return this.resultAmount;
	}

	public void setResultAmount(Double resultAmount) {
		this.resultAmount = resultAmount;
	}

	@Column(name = "ReturnTime", length = 19)
	public Timestamp getReturnTime() {
		return this.returnTime;
	}

	public void setReturnTime(Timestamp returnTime) {
		this.returnTime = returnTime;
	}

	@Column(name = "MaxWin", scale = 4)
	public Double getMaxWin() {
		return this.maxWin;
	}

	public void setMaxWin(Double maxWin) {
		this.maxWin = maxWin;
	}

	@Column(name = "MaxLose", scale = 4)
	public Double getMaxLose() {
		return this.maxLose;
	}

	public void setMaxLose(Double maxLose) {
		this.maxLose = maxLose;
	}

}