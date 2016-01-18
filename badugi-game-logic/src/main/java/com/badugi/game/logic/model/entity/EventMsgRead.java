package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EventMsgRead entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "event_msg_read")
public class EventMsgRead extends BaseEntity implements java.io.Serializable {

	/**
	 * 是否删除(是)
	 */
	public static final Short DELETE_TRUE = 1;
	/**
	 * 是否删除(否)
	 */
	public static final Short DELETE_NO = 0;
	
	
	// Fields

	private Integer pid;
	private Integer msgId;
	private Long fbId;
	private Short isDelete;

	// Constructors

	/** default constructor */
	public EventMsgRead() {
	}

	/** minimal constructor */
	public EventMsgRead(Integer msgId, Long fbId) {
		this.msgId = msgId;
		this.fbId = fbId;
	}

	/** full constructor */
	public EventMsgRead(Integer msgId, Long fbId, Short isDelete) {
		this.msgId = msgId;
		this.fbId = fbId;
		this.isDelete = isDelete;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PID", unique = true, nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "MsgId", nullable = false)
	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "IsDelete")
	public Short getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Short isDelete) {
		this.isDelete = isDelete;
	}

}