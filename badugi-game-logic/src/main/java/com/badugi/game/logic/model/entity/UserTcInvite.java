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
@Table(name = "user_tcinvite")
public class UserTcInvite extends BaseEntity implements java.io.Serializable {

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
	 * 召回好友
	 */
	public static final Short TYPE_BACKINVITE = 99;
	
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
	private String openid;
	private String bopenid;
	private String content;
	private Short isAccept;
	private Timestamp createTime;
	private Timestamp acceptTime;
	private Timestamp updateTime;
	private Short sourceType;

	// Constructors

	/** default constructor */
	public UserTcInvite() {
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


	@Column(name = "openid", nullable = false, length = 100)
	public String getOpenid() {
		return openid;
	}



	public void setOpenid(String openid) {
		this.openid = openid;
	}


	@Column(name = "bopenid", nullable = false, length = 100)
	public String getBopenid() {
		return bopenid;
	}



	public void setBopenid(String bopenid) {
		this.bopenid = bopenid;
	}



	@Column(name = "Content", length = 100)
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
