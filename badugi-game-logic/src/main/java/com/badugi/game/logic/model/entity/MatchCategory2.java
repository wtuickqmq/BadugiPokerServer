package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MatchCategory2 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_category2")
public class MatchCategory2 extends BaseEntity implements java.io.Serializable {

	// Fields

	private Short cateId2;
	private Short cateId1;
	private String cateName2;
	private String displayConfig;
	private String remark;
	private Short status;
	private String managerName;
	private Timestamp operatedTime;
	private Short language;

	// Constructors

	/** default constructor */
	public MatchCategory2() {
	}

	/** minimal constructor */
	public MatchCategory2(Short cateId1) {
		this.cateId1 = cateId1;
	}

	/** full constructor */
	public MatchCategory2(Short cateId1, String cateName2,
			String displayConfig, String remark, String managerName,
			Timestamp operatedTime, Short language) {
		this.cateId1 = cateId1;
		this.cateName2 = cateName2;
		this.displayConfig = displayConfig;
		this.remark = remark;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
		this.language = language;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CateId2", unique = true, nullable = false)
	public Short getCateId2() {
		return this.cateId2;
	}

	public void setCateId2(Short cateId2) {
		this.cateId2 = cateId2;
	}

	@Column(name = "CateId1", nullable = false)
	public Short getCateId1() {
		return this.cateId1;
	}

	public void setCateId1(Short cateId1) {
		this.cateId1 = cateId1;
	}

	@Column(name = "CateName2", length = 50)
	public String getCateName2() {
		return this.cateName2;
	}

	public void setCateName2(String cateName2) {
		this.cateName2 = cateName2;
	}

	@Column(name = "DisplayConfig", length = 100)
	public String getDisplayConfig() {
		return this.displayConfig;
	}

	public void setDisplayConfig(String displayConfig) {
		this.displayConfig = displayConfig;
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