package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LostlinkTicketLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lostlink_ticket_log")
public class LostlinkTicketLog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fromFbId;
	private Long toFbId;
	private Integer ticketId;
	private Timestamp lastLoginTime;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public LostlinkTicketLog() {
	}

	/** full constructor */
	public LostlinkTicketLog(Long fromFbId, Long toFbId, Integer ticketId,
			Timestamp lastLoginTime, Timestamp createTime) {
		this.fromFbId = fromFbId;
		this.toFbId = toFbId;
		this.ticketId = ticketId;
		this.lastLoginTime = lastLoginTime;
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

	@Column(name = "FromFbId")
	public Long getFromFbId() {
		return this.fromFbId;
	}

	public void setFromFbId(Long fromFbId) {
		this.fromFbId = fromFbId;
	}

	@Column(name = "ToFbId")
	public Long getToFbId() {
		return this.toFbId;
	}

	public void setToFbId(Long toFbId) {
		this.toFbId = toFbId;
	}

	@Column(name = "TicketId")
	public Integer getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@Column(name = "LastLoginTime", length = 19)
	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "CreateTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}