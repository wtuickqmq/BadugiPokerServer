package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserMsg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_msg")
public class UserMsg extends BaseEntity implements java.io.Serializable {

	/**
	 * 所有
	 */
	public static final Short TYPE_ALL = -1;
	
	/**
	 * 互动
	 */
	public static final Short TYPE_INT = 1;
	
	/**
	 * 系统
	 */
	public static final Short TYPE_SYS = 2;
	
	/**
	 * 活动
	 */
	public static final Short TYPE_EXE = 3;
	
	/**
	 * 获奖
	 */
	public static final Short TYPE_PRIZE = 4;
	
	/**
	 * 子类型>加牌友
	 */
	public static final Short SUBTYPE_FRIEND = 1;
	
	/**
	 * 子类型>赠送筹码留言
	 */
	public static final Short SUBTYPE_CHIPS = 2;
	
	/**
	 * 子类型>单纯留言
	 */
	public static final Short SUBTYPE_LIUYUAN = 3;
	
	/**
	 * 系统单发信息
	 */
	public static final Short SUBTYPE_ONE = 20;
	
	/**
	 * 系统群发信息
	 */
	public static final Short SUBTYPE_MORE = 21;
	
	/**
	 * 系统群发信息
	 */
	public static final Short SUBTYPE_ALL = 22;
	
	/**
	 * 为因断线时记录比赛返还信息
	 */
	public static final Short SUBTYPE_MATCH = 30;
	
	/**
	 * 比赛返还信息已经提示用户
	 */
	public static final Short SUBTYPE_MATCH_PROMPTED = 31;
	
	/**
	 * 已读
	 */
	public static final Short READ_TRUE = 1;
	
	/**
	 * 未读
	 */
	public static final Short READ_NO = 0;
	
	/**
	 * 赞 与取消赞子类型
	 */
	public static final Short PRAISE = 40;
	
	
	// Fields

	private Integer msgId;
	private Long fromId;
	private Long fbId;
	private Short msgType;
	private Short subType;
	private String content;
	private Timestamp createTime;
	private Short isRead;
	private Integer sortNo;
	private Short sendLive;

	// Constructors

	/** default constructor */
	public UserMsg() {
	}

	/** minimal constructor */
	public UserMsg(Long fbId, Short msgType, Timestamp createTime, Short isRead) {
		this.fbId = fbId;
		this.msgType = msgType;
		this.createTime = createTime;
		this.isRead = isRead;
	}

	/** full constructor */
	public UserMsg(Long fromId, Long fbId, Short msgType, Short subType,
			String content, Timestamp createTime, Short isRead, Integer sortNo) {
		this.fromId = fromId;
		this.fbId = fbId;
		this.msgType = msgType;
		this.subType = subType;
		this.content = content;
		this.createTime = createTime;
		this.isRead = isRead;
		this.sortNo = sortNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MsgId", unique = true, nullable = false)
	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	@Column(name = "FromId")
	public Long getFromId() {
		return this.fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "MsgType", nullable = false)
	public Short getMsgType() {
		return this.msgType;
	}

	public void setMsgType(Short msgType) {
		this.msgType = msgType;
	}

	@Column(name = "SubType")
	public Short getSubType() {
		return this.subType;
	}

	public void setSubType(Short subType) {
		this.subType = subType;
	}

	@Column(name = "Content", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "IsRead", nullable = false)
	public Short getIsRead() {
		return this.isRead;
	}

	public void setIsRead(Short isRead) {
		this.isRead = isRead;
	}
	
	@Column(name = "SortNo")
	public Integer getSortNo() {
		return sortNo;
	}
	
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	
	@Column(name = "SendLive")
	public Short getSendLive() {
		return sendLive;
	}

	public void setSendLive(Short sendLive) {
		this.sendLive = sendLive;
	}

}