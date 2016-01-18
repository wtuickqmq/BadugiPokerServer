package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GameAction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "forhelp_click")
public class ForhelpClick extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long id;
	private Long sendFbId;
	private Long clickFbId;
	private Long timestampsend;
	private Timestamp clickTime;
	private String sign;

	// Constructors

	/** default constructor */
	public ForhelpClick() {
	}

	
	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "sendFbId")
	public Long getSendFbId() {
		return sendFbId;
	}


	public void setSendFbId(Long sendFbId) {
		this.sendFbId = sendFbId;
	}
	

	@Column(name = "clickFbId")
	public Long getClickFbId() {
		return clickFbId;
	}


	public void setClickFbId(Long clickFbId) {
		this.clickFbId = clickFbId;
	}

	@Column(name = "timestampsend")
	public Long getTimestampsend() {
		return timestampsend;
	}


	public void setTimestampsend(Long timestampsend) {
		this.timestampsend = timestampsend;
	}

	@Column(name = "clickTime")
	public Timestamp getClickTime() {
		return clickTime;
	}


	public void setClickTime(Timestamp clickTime) {
		this.clickTime = clickTime;
	}

	@Column(name = "sign")
	public String getSign() {
		return sign;
	}


	public void setSign(String sign) {
		this.sign = sign;
	}

	

}