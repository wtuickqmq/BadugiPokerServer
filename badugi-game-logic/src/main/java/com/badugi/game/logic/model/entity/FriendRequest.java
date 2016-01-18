package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FriendRequest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "friend_request")
public class FriendRequest extends BaseEntity implements java.io.Serializable {

	/**
	 * 未处理
	 */
	public static final Short ACCPET_DEF = -1;
	
	/**
	 * 同意
	 */
	public static final Short ACCPET_TRUE = 1;
	
	/**
	 * 不同意
	 */
	public static final Short ACCPET_FALSE = 0;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Long invitedFbId;
	private Short isAccept;
	private Timestamp createTime;
	private Integer msgId;

	// Constructors

	/** default constructor */
	public FriendRequest() {
	}

	/** minimal constructor */
	public FriendRequest(Long fbId, Long invitedFbId, Short isAccept,
			Timestamp createTime) {
		this.fbId = fbId;
		this.invitedFbId = invitedFbId;
		this.isAccept = isAccept;
		this.createTime = createTime;
	}

	/** full constructor */
	public FriendRequest(Long fbId, Long invitedFbId, Short isAccept,
			Timestamp createTime, Integer msgId) {
		this.fbId = fbId;
		this.invitedFbId = invitedFbId;
		this.isAccept = isAccept;
		this.createTime = createTime;
		this.msgId = msgId;
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

	@Column(name = "InvitedFbId", nullable = false)
	public Long getInvitedFbId() {
		return this.invitedFbId;
	}

	public void setInvitedFbId(Long invitedFbId) {
		this.invitedFbId = invitedFbId;
	}

	@Column(name = "IsAccept", nullable = false)
	public Short getIsAccept() {
		return this.isAccept;
	}

	public void setIsAccept(Short isAccept) {
		this.isAccept = isAccept;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "MsgId")
	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

}