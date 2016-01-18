package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * InstantPowerLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "instant_power_log")
public class InstantPowerLog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbid;
	private Integer powerId;
	private Integer canCount;
	private Integer useCount;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public InstantPowerLog() {
	}

	/** minimal constructor */
	public InstantPowerLog(Long fbid, Integer powerId, Integer canCount,
			Integer useCount) {
		this.fbid = fbid;
		this.powerId = powerId;
		this.canCount = canCount;
		this.useCount = useCount;
	}

	/** full constructor */
	public InstantPowerLog(Long fbid, Integer powerId, Integer canCount,
			Integer useCount, Timestamp createTime) {
		this.fbid = fbid;
		this.powerId = powerId;
		this.canCount = canCount;
		this.useCount = useCount;
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

	@Column(name = "Fbid", nullable = false)
	public Long getFbid() {
		return this.fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	@Column(name = "PowerId", nullable = false)
	public Integer getPowerId() {
		return this.powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	@Column(name = "CanCount", nullable = false)
	public Integer getCanCount() {
		return this.canCount;
	}

	public void setCanCount(Integer canCount) {
		this.canCount = canCount;
	}

	@Column(name = "UseCount", nullable = false)
	public Integer getUseCount() {
		return this.useCount;
	}

	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}