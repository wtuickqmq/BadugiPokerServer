package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MatchCategory3 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_category3")
public class MatchCategory3 extends BaseEntity implements java.io.Serializable {

	// Fields

	private Short cateId3;
	private Short cateId2;
	private String typeName3;
	private String remark;
	private Short status;
	private String managerName;
	private Timestamp operatedTime;
	private Short language;

	// Constructors

	/** default constructor */
	public MatchCategory3() {
	}

	/** minimal constructor */
	public MatchCategory3(Short cateId2) {
		this.cateId2 = cateId2;
	}

	/** full constructor */
	public MatchCategory3(Short cateId2, String typeName3, String remark,
			String managerName, Timestamp operatedTime, Short language) {
		this.cateId2 = cateId2;
		this.typeName3 = typeName3;
		this.remark = remark;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
		this.language = language;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CateId3", unique = true, nullable = false)
	public Short getCateId3() {
		return this.cateId3;
	}

	public void setCateId3(Short cateId3) {
		this.cateId3 = cateId3;
	}

	@Column(name = "CateId2", nullable = false)
	public Short getCateId2() {
		return this.cateId2;
	}

	public void setCateId2(Short cateId2) {
		this.cateId2 = cateId2;
	}

	@Column(name = "TypeName3", length = 50)
	public String getTypeName3() {
		return this.typeName3;
	}

	public void setTypeName3(String typeName3) {
		this.typeName3 = typeName3;
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

}