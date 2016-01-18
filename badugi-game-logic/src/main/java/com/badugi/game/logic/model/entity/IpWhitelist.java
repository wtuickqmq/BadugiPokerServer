package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IpWhitelist entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ip_whitelist")
public class IpWhitelist extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ip;
	private String remark;
	private Short status;
	private String manager;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public IpWhitelist() {
	}

	/** minimal constructor */
	public IpWhitelist(String ip, Short status, String manager,
			Timestamp createTime) {
		this.ip = ip;
		this.status = status;
		this.manager = manager;
		this.createTime = createTime;
	}

	/** full constructor */
	public IpWhitelist(String ip, String remark, Short status, String manager,
			Timestamp createTime) {
		this.ip = ip;
		this.remark = remark;
		this.status = status;
		this.manager = manager;
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

	@Column(name = "IP", nullable = false, length = 40)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "Manager", nullable = false, length = 50)
	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}