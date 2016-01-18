package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * UserTip entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_tip")
public class UserTip extends BaseEntity implements java.io.Serializable {

	/**
	 * 大厅登记比赛 
	 */
	public static final Short TYPE_JOINMATCH_LOBBY = 1;
	/**
	 * 房间登记比赛 
	 */
	public static final Short TYPE_JOINMATCH_ROOM = 2;
	/**
	 * 签到提示
	 */
	public static final Short TYPE_SIGN_IN = 3;
	/**
	 * ABC类赢牌分享
	 */
	public static final Short TYPE_WIN_SHARE = 4;
	/**
	 * 大厅引导
	 */
	public static final Short TYPE_LOBBY = 5;
	/**
	 * 房间引导
	 */
	public static final Short TYPE_ROOM = 6;
	/**
	 * 聊天引导
	 */
	public static final Short TYPE_CHAT = 7;
	/**
	 * 新手引导
	 */
	public static final Short TYPE_GUIDE = 8;
	/**
	 * 赞引导
	 */
	public static final Short TYPE_LIKEU = 9;
	
	/**
	 * 标示fish/敌人
	 */
	public static final Short TYPE_FE = 10;
	/**
	 * 获胜分享
	 */
	public static final Short TYPE_WIN = 11;
	/**
	 * 第一次进入牌桌
	 */
	public static final Short TYPE_TABLE_FIRST = 12;
	/**
	 * 第一次坐下玩游戏
	 */
	public static final Short TYPE_TABLE_SITDOWN = 13;
	/**
	 * 第一次赢牌分享
	 */
	public static final Short TYPE_FIRST_WIN = 14;
	
	// Fields

	private Integer id;
	private Long fbId;
	private Short type;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public UserTip() {
	}

	/** full constructor */
	public UserTip(Long fbId, Short type, Timestamp createTime) {
		this.fbId = fbId;
		this.type = type;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
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

	@Column(name = "Type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}
	
	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	@PrePersist
	public void prePersist(){
		this.createTime = (this.createTime == null ? new Timestamp(System.currentTimeMillis()) : this.createTime);
	}

}