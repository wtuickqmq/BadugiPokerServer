package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * MatchCategory1 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_category1")
public class MatchCategory1 extends BaseEntity implements java.io.Serializable {

	// Fields

	public Short cateId1;
	public String cateName1;
	public String remark;
	public Short status;
	public String managerName;
	public Timestamp operatedTime;
	public Short language;
	public Integer rtype;

	// Constructors

	/** default constructor */
	public MatchCategory1() {
	}

	/** full constructor */
	public MatchCategory1(String cateName1, String remark, String managerName,
			Timestamp operatedTime, Short language) {
		this.cateName1 = cateName1;
		this.remark = remark;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
		this.language = language;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CateId1", unique = true, nullable = false)
	public Short getCateId1() {
		return this.cateId1;
	}

	public void setCateId1(Short cateId1) {
		this.cateId1 = cateId1;
	}

	@Column(name = "CateName1", length = 50)
	public String getCateName1() {
		return this.cateName1;
	}

	public void setCateName1(String cateName1) {
		this.cateName1 = cateName1;
	}

	@Column(name = "Remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "Status", nullable = false)
	public Short getStatus() {
		return status;
	}
	
	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "ManagerName", length = 50)
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "OperatedTime", length = 19)
	public Timestamp getOperatedTime() {
		return this.operatedTime;
	}

	public void setOperatedTime(Timestamp operatedTime) {
		this.operatedTime = operatedTime;
	}

	@Column(name = "Language")
	public Short getLanguage() {
		return this.language;
	}

	public void setLanguage(Short language) {
		this.language = language;
	}
	
	@Transient
	public Integer getRtype() {
		return rtype;
	}

	public void setRtype(Integer rtype) {
		this.rtype = rtype;
	}

}