package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SyncDealConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sync_deal_config")
public class SyncDealConfig extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer matchConfigId;
	private Integer startUserCount;
	private Integer stopUserCount;

	// Constructors

	/** default constructor */
	public SyncDealConfig() {
	}

	/** full constructor */
	public SyncDealConfig(Integer matchConfigId, Integer startUserCount,
			Integer stopUserCount) {
		this.matchConfigId = matchConfigId;
		this.startUserCount = startUserCount;
		this.stopUserCount = stopUserCount;
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

	@Column(name = "MatchConfigId", nullable = false)
	public Integer getMatchConfigId() {
		return this.matchConfigId;
	}

	public void setMatchConfigId(Integer matchConfigId) {
		this.matchConfigId = matchConfigId;
	}

	@Column(name = "StartUserCount", nullable = false)
	public Integer getStartUserCount() {
		return this.startUserCount;
	}

	public void setStartUserCount(Integer startUserCount) {
		this.startUserCount = startUserCount;
	}

	@Column(name = "StopUserCount", nullable = false)
	public Integer getStopUserCount() {
		return this.stopUserCount;
	}

	public void setStopUserCount(Integer stopUserCount) {
		this.stopUserCount = stopUserCount;
	}

}