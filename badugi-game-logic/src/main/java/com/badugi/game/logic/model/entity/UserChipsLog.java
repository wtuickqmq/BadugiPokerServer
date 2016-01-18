package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserChipsLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_chips_log")
public class UserChipsLog extends BaseEntity implements java.io.Serializable {

	/*
	 * 0 首次进入赠送 1 用完即送 2 充值 3 发送求帮助 4 回应点一下 5 推广动作 6 回应推广 7用户间相互赠送,8兑奖,
	 * 9新手指引,10单任务,11连续登陆,12聊天引导,13赞引导,14荣誉公告,15帅,16经验升级,17每日任务,18系列任务
	 * 19倒计时宝箱,20猜大小,21签到,22彩蛋,23免费筹码任务,24场任务,25比赛,26金块兑换,27赠送筹码至补助,28系统 31分享
	 */
	public static final Short USER_CHIP_FIRST = 0;
	public static final Short USER_CHIP_OVER = 1;
	public static final Short USER_CHIP_TOPUP = 2;
	public static final Short USER_CHIP_HELP = 3;
	public static final Short USER_CHIP_HELPCLICK = 4;
	public static final Short USER_CHIP_PROMOTE = 5;
	public static final Short USER_CHIP_PROMOTECLICK = 6;
	public static final Short USER_CHIP_GIFT = 7;
	public static final Short USER_CHIP_REWEAR = 8;
	public static final Short USER_CHIP_GUIDES = 9;
	public static final Short USER_CHIP_SIGLE_TASK = 10;
	public static final Short USER_CHIP_CONTIN_LOGIN = 11;
	public static final Short USER_CHIP_CHAT = 12;
	public static final Short USER_CHIP_LIKEU = 13;
	public static final Short USER_CHIP_GLORY = 14;
	public static final Short USER_CHIP_SMART = 15;
	public static final Short USER_CHIP_LEVEL_ADD = 16;
	public static final Short USER_CHIP_TASK_TODAY = 17;
	public static final Short USER_CHIP_TASK_CATEGORY = 18;
	public static final Short USER_CHIP_TIMEBOX = 19;
	public static final Short USER_CHIP_GUESSS = 20;
	public static final Short USER_CHIP_SIGNIN = 21;
	public static final Short USER_CHIP_PEGG = 22;
	public static final Short USER_CHIP_TASK_FREECHIPS = 23;
	public static final Short USER_CHIP_TASK_ROOMS = 24;
	public static final Short USER_CHIP_MATCH = 25;
	public static final Short USER_CHIP_GOLD = 26;
	public static final Short USER_CHIP_PRC = 27;
	public static final Short USER_CHIP_SYSPAY = 28;
	public static final Short USER_CHIP_BACKINVITED = 98;
	public static final Short USER_CHIP_BACKINVITE = 99;
	public static final Short USER_CHIP_QQGROUP = 30;
	public static final Short USER_CHIP_SAHRE = 31;

	// Fields

	private Integer id;
	private Long fbId;
	private Double chips;
	private Short getType;
	private Long objectId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public UserChipsLog() {}

	/** minimal constructor */
	public UserChipsLog(Long fbId, Double chips, Short getType,
			Timestamp createTime) {
		this.fbId = fbId;
		this.chips = chips;
		this.getType = getType;
		this.createTime = createTime;
	}

	/** full constructor */
	public UserChipsLog(Long fbId, Double chips, Short getType,
			Long objectId, Timestamp createTime) {
		this.fbId = fbId;
		this.chips = chips;
		this.getType = getType;
		this.objectId = objectId;
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

	@Column(name = "Chips", nullable = false, scale = 4)
	public Double getChips() {
		return this.chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	@Column(name = "GetType", nullable = false)
	public Short getGetType() {
		return this.getType;
	}

	public void setGetType(Short getType) {
		this.getType = getType;
	}

	@Column(name = "ObjectId")
	public Long getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}