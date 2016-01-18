package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TimeBox entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "time_box")
public class TimeBox extends BaseEntity implements java.io.Serializable {

	/**
	 * 是否打开1是
	 */
	public static final Short OPEN_TRUE = 1;
	/**
	 * 是否打开 0否
	 */
	public static final Short OPEN_FLASE = 0;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Integer boxTime;
	private Integer ticketId;
	private Short isOpen;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public TimeBox() {
	}

	/** minimal constructor */
	public TimeBox(Long fbId, Integer boxTime, Short isOpen,
			Timestamp createTime) {
		this.fbId = fbId;
		this.boxTime = boxTime;
		this.isOpen = isOpen;
		this.createTime = createTime;
	}

	/** full constructor */
	public TimeBox(Long fbId, Integer boxTime, Integer ticketId, Short isOpen,
			Timestamp createTime) {
		this.fbId = fbId;
		this.boxTime = boxTime;
		this.ticketId = ticketId;
		this.isOpen = isOpen;
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

	@Column(name = "BoxTime", nullable = false)
	public Integer getBoxTime() {
		return this.boxTime;
	}

	public void setBoxTime(Integer boxTime) {
		this.boxTime = boxTime;
	}

	@Column(name = "TicketId")
	public Integer getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@Column(name = "IsOpen", nullable = false)
	public Short getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(Short isOpen) {
		this.isOpen = isOpen;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}