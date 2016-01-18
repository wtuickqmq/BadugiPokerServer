package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Matchs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "matchs")
public class Matchs extends BaseEntity implements java.io.Serializable {

	/**
	 * 开放登记
	 */
	public static final Short STATUS_START = 0;
	
	/**
	 * 进行中
	 */
	public static final Short STATUS_DOING = 1;
	
	/**
	 * 人数已满
	 */
	public static final Short STATUS_FULL = 2;
	
	/**
	 * 已结束
	 */
	public static final Short STATUS_END = 3;
	
	/**
	 * 开启状态:0开启
	 */
	public static final Short MATCHONOFF_ON = 0;
	
	/**
	 * 开启状态:1关闭
	 */
	public static final Short MATCHONOFF_OFF = 1;
	
	
	// Fields

	private Integer matchId;
	private Integer matchConfigId;
	private Short matchStatus;
	private Short matchOnOff;
	private Timestamp beginTime;
	private Timestamp endTime;
	private Timestamp matchStartTime;
	private Timestamp matchStopTime;

	// Constructors

	/** default constructor */
	public Matchs() {
	}

	/** minimal constructor */
	public Matchs(Integer matchConfigId, Short matchStatus, Short matchOnOff,
			Timestamp beginTime) {
		this.matchConfigId = matchConfigId;
		this.matchStatus = matchStatus;
		this.matchOnOff = matchOnOff;
		this.beginTime = beginTime;
	}

	/** full constructor */
	public Matchs(Integer matchConfigId, Short matchStatus, Short matchOnOff,
			Timestamp beginTime, Timestamp endTime, Timestamp matchStartTime,
			Timestamp matchStopTime) {
		this.matchConfigId = matchConfigId;
		this.matchStatus = matchStatus;
		this.matchOnOff = matchOnOff;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.matchStartTime = matchStartTime;
		this.matchStopTime = matchStopTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MatchId", unique = true, nullable = false)
	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	@Column(name = "MatchConfigId", nullable = false)
	public Integer getMatchConfigId() {
		return this.matchConfigId;
	}

	public void setMatchConfigId(Integer matchConfigId) {
		this.matchConfigId = matchConfigId;
	}

	@Column(name = "MatchStatus", nullable = false)
	public Short getMatchStatus() {
		return this.matchStatus;
	}

	public void setMatchStatus(Short matchStatus) {
		this.matchStatus = matchStatus;
	}

	@Column(name = "MatchOnOff", nullable = false)
	public Short getMatchOnOff() {
		return this.matchOnOff;
	}

	public void setMatchOnOff(Short matchOnOff) {
		this.matchOnOff = matchOnOff;
	}

	@Column(name = "BeginTime", nullable = false, length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "EndTime", length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "MatchStartTime", length = 19)
	public Timestamp getMatchStartTime() {
		return this.matchStartTime;
	}

	public void setMatchStartTime(Timestamp matchStartTime) {
		this.matchStartTime = matchStartTime;
	}

	@Column(name = "MatchStopTime", length = 19)
	public Timestamp getMatchStopTime() {
		return this.matchStopTime;
	}

	public void setMatchStopTime(Timestamp matchStopTime) {
		this.matchStopTime = matchStopTime;
	}

}