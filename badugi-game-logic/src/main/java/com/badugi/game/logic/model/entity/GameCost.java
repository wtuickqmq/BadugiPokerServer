package com.badugi.game.logic.model.entity;

// Generated 2015-12-2 10:38:48 by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GameCost generated by hbm2java
 */
@Entity
@Table(name = "game_cost")
public class GameCost extends BaseEntity {

	private int id;
	private Long UId;
	private Integer type;
	private Long billBefore;
	private Integer bill;
	private Date createTime;
	private String remark;

	public GameCost() {
	}

	public GameCost(int id) {
		this.id = id;
	}

	public GameCost(int id, Long UId, Integer type, Long billBefore,
			Integer bill, Date createTime, String remark) {
		this.id = id;
		this.UId = UId;
		this.type = type;
		this.billBefore = billBefore;
		this.bill = bill;
		this.createTime = createTime;
		this.remark = remark;
	}
	

	public GameCost(Long uId, Integer type, Long billBefore, Integer bill, String remark) {
		super();
		UId = uId;
		this.type = type;
		this.billBefore = billBefore;
		this.bill = bill;
		this.createTime = createTime;
		this.remark = remark;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "u_id")
	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "bill_before")
	public Long getBillBefore() {
		return this.billBefore;
	}

	public void setBillBefore(Long billBefore) {
		this.billBefore = billBefore;
	}

	@Column(name = "bill")
	public Integer getBill() {
		return this.bill;
	}

	public void setBill(Integer bill) {
		this.bill = bill;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}