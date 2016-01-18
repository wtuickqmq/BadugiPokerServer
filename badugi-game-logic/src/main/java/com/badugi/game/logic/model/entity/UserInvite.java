package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserInvite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_invite")
public class UserInvite extends BaseEntity implements java.io.Serializable {

	/**
	 * 原好友邀请
	 */
	public static final Short TYPE_OLD = 0;
	
	/**
	 * 新手推广任务
	 */
	public static final Short TYPE_POPUL = 1;
	
	/**
	 * 牌桌胜利后邀请
	 */
	public static final Short TYPE_WIN = 2;
	
	/**
	 * 新邀请
	 */
	public static final Short TYPE_NEWINVITE = 4;
	
	/**
	 * 已接受
	 */
	public static final Short ACCEPT_TRUE = 1;
	
	/**
	 * 未接受
	 */
	public static final Short ACCEPT_NO = 0;
	
	
	// Fields

	private Integer id;
	private Long fbRequestId;
	private Long fbId;
	private Long inviteFbId;
	private String content;
	private Short isAccept;
	private Timestamp createTime;
	private Timestamp acceptTime;
	private Timestamp updateTime;
	private Short sourceType;

	// Constructors

	/** default constructor */
	public UserInvite() {
	}

	/** minimal constructor */
	public UserInvite(Long fbRequestId, Long fbId, Long inviteFbId,
			String content, Short isAccept, Timestamp createTime) {
		this.fbRequestId = fbRequestId;
		this.fbId = fbId;
		this.inviteFbId = inviteFbId;
		this.content = content;
		this.isAccept = isAccept;
		this.createTime = createTime;
	}

	/** full constructor */
	public UserInvite(Long fbRequestId, Long fbId, Long inviteFbId,
			String content, Short isAccept, Timestamp createTime,
			Timestamp acceptTime, Timestamp updateTime) {
		this.fbRequestId = fbRequestId;
		this.fbId = fbId;
		this.inviteFbId = inviteFbId;
		this.content = content;
		this.isAccept = isAccept;
		this.createTime = createTime;
		this.acceptTime = acceptTime;
		this.updateTime = updateTime;
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

	@Column(name = "FbRequestId", nullable = false)
	public Long getFbRequestId() {
		return this.fbRequestId;
	}

	public void setFbRequestId(Long fbRequestId) {
		this.fbRequestId = fbRequestId;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "InviteFbId", nullable = false)
	public Long getInviteFbId() {
		return this.inviteFbId;
	}

	public void setInviteFbId(Long inviteFbId) {
		this.inviteFbId = inviteFbId;
	}

	@Column(name = "Content", nullable = false, length = 100)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	@Column(name = "AcceptTime", length = 19)
	public Timestamp getAcceptTime() {
		return this.acceptTime;
	}

	public void setAcceptTime(Timestamp acceptTime) {
		this.acceptTime = acceptTime;
	}

	@Column(name = "UpdateTime", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	@Column(name = "SourceType", nullable = false)
	public Short getSourceType() {
		return sourceType;
	}
	
	public void setSourceType(Short sourceType) {
		this.sourceType = sourceType;
	}

}