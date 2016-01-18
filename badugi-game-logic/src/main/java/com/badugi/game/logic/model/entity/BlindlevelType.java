package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BlindlevelType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "blindlevel_type")
public class BlindlevelType extends BaseEntity implements java.io.Serializable {

	// Fields

	private Short blindTypeId;
	private String blindTypeName;
	private String remark;
	private String managerName;
	private Timestamp operatedTime;

	// Constructors

	/** default constructor */
	public BlindlevelType() {
	}

	/** full constructor */
	public BlindlevelType(String blindTypeName, String remark,
			String managerName, Timestamp operatedTime) {
		this.blindTypeName = blindTypeName;
		this.remark = remark;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BlindTypeId", unique = true, nullable = false)
	public Short getBlindTypeId() {
		return this.blindTypeId;
	}

	public void setBlindTypeId(Short blindTypeId) {
		this.blindTypeId = blindTypeId;
	}

	@Column(name = "BlindTypeName", length = 50)
	public String getBlindTypeName() {
		return this.blindTypeName;
	}

	public void setBlindTypeName(String blindTypeName) {
		this.blindTypeName = blindTypeName;
	}

	@Column(name = "Remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

}