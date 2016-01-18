package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysError entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_error")
public class SysError extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbId;
	private Double chips;
	private String ip;
	private String browserInfo;
	private Short connSt;
	private String gameInfo;
	private String matchInfo;
	private String picName;
	private String content;
	private Short isRepeatConn;
	private Integer pingTimes;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public SysError() {
	}

	/** minimal constructor */
	public SysError(Long fbId, Double chips, Short connSt, Short isRepeatConn,
			Integer pingTimes, Timestamp createTime) {
		this.fbId = fbId;
		this.chips = chips;
		this.connSt = connSt;
		this.isRepeatConn = isRepeatConn;
		this.pingTimes = pingTimes;
		this.createTime = createTime;
	}

	/** full constructor */
	public SysError(Long fbId, Double chips, String ip, String browserInfo,
			Short connSt, String gameInfo, String matchInfo, String picName,
			String content, Short isRepeatConn, Integer pingTimes,
			Timestamp createTime) {
		this.fbId = fbId;
		this.chips = chips;
		this.ip = ip;
		this.browserInfo = browserInfo;
		this.connSt = connSt;
		this.gameInfo = gameInfo;
		this.matchInfo = matchInfo;
		this.picName = picName;
		this.content = content;
		this.isRepeatConn = isRepeatConn;
		this.pingTimes = pingTimes;
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

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "Chips", nullable = false, scale = 4)
	public Double getChips() {
		return this.chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	@Column(name = "IP", length = 500)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "BrowserInfo", length = 200)
	public String getBrowserInfo() {
		return this.browserInfo;
	}

	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}

	@Column(name = "ConnSt", nullable = false)
	public Short getConnSt() {
		return this.connSt;
	}

	public void setConnSt(Short connSt) {
		this.connSt = connSt;
	}

	@Column(name = "GameInfo", length = 1000)
	public String getGameInfo() {
		return this.gameInfo;
	}

	public void setGameInfo(String gameInfo) {
		this.gameInfo = gameInfo;
	}

	@Column(name = "MatchInfo", length = 1000)
	public String getMatchInfo() {
		return this.matchInfo;
	}

	public void setMatchInfo(String matchInfo) {
		this.matchInfo = matchInfo;
	}

	@Column(name = "PicName", length = 50)
	public String getPicName() {
		return this.picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	@Column(name = "Content", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "IsRepeatConn", nullable = false)
	public Short getIsRepeatConn() {
		return this.isRepeatConn;
	}

	public void setIsRepeatConn(Short isRepeatConn) {
		this.isRepeatConn = isRepeatConn;
	}

	@Column(name = "PingTimes", nullable = false)
	public Integer getPingTimes() {
		return this.pingTimes;
	}

	public void setPingTimes(Integer pingTimes) {
		this.pingTimes = pingTimes;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}