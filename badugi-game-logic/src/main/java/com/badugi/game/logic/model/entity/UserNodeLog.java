package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserNodeLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_node_log")
public class UserNodeLog extends BaseEntity implements java.io.Serializable {

	/*
	 * 0 loading页(登陆) 1 引导页 2引导页快速开始 3新手指引页 4新手指引页快速开始 5获取筹码帮助页 6充值 7求帮助 8推广9进入大厅
	 * 100新手教程跳过 101 免费领取 102 大厅购买筹码点击 103 充值面板购买点击 104大厅快速开始 105大厅查看牌桌
	 * 106初级场 107中级场 108高级场 109进入牌桌 110大厅查看比赛 111登记参赛 112比赛规则 113查看大学生赛
	 * 114联系客服 115消息中心 116我的头像 117游戏记录 118邀请好友 119奖品 120门票 121商城 122帮助
	 * 123新手步骤 124观看新手教程 125大厅快速开始2 126兑奖说明 127新手教程内快速开始 128新手教程内第二次快速开始
	 */

	public static final Short USER_NODE_LOADING = 0;
	public static final Short USER_NODE_GUIDE = 1;
	public static final Short USER_NODE_GUIDE_BEGIN = 2;
	public static final Short USER_NODE_GUIDE_NEW = 3;
	public static final Short USER_NODE_GUIDE_NEW_BEGIN = 4;
	public static final Short USER_NODE_GETCHIPS = 5;
	public static final Short USER_NODE_RECHARGE = 6;
	public static final Short USER_NODE_FORHELP = 7;
	public static final Short USER_NODE_PROMOTE = 8;
	public static final Short USER_NODE_ENTER_LOBBY = 9;
	public static final Short USER_NODE_LOADING_END = 10;
	/*
	 * 50 选择新手人数、51 选择老手人数、52关闭人数
                    53 进入人数、54 完成人数
	 */
	public static final Short USER_NODE_TUTORIAL_NEW = 50;
	public static final Short USER_NODE_TUTORIAL_OLD = 51;
	public static final Short USER_NODE_TUTORIAL_CLOSE = 52;
	public static final Short USER_NODE_TUTORIAL_GO = 53;
	public static final Short USER_NODE_TUTORIAL_OVER = 54;
	
	
	public static final Short USER_NODE_GUED = 100;
	public static final Short USER_NODE_FREECHIPS = 101;
	public static final Short USER_NODE_GOBUY = 102;
	public static final Short USER_NODE_TOBUY = 103;
	public static final Short USER_NODE_LBFPLAY = 104;
	public static final Short USER_NODE_LBLTABLE = 105;
	public static final Short USER_NODE_TALBE_LOW = 106;
	public static final Short USER_NODE_TALBE_MID = 107;
	public static final Short USER_NODE_TALBE_HIG = 108;
	public static final Short USER_NODE_GOTALBE = 109;
	public static final Short USER_NODE_LBLMATCH = 110;
	public static final Short USER_NODE_JOMATCH = 111;
	public static final Short USER_NODE_MRULE = 112;
	public static final Short USER_NODE_LUNMATCH = 113;
	public static final Short USER_NODE_CONSERVER = 114;
	public static final Short USER_NODE_LBSYS = 115;
	public static final Short USER_NODE_LBMHEAD = 116;
	public static final Short USER_NODE_LBPLOG = 117;
	public static final Short USER_NODE_LBINVITE = 118;
	public static final Short USER_NODE_LBGOODS = 119;
	public static final Short USER_NODE_LBTICKET = 120;
	public static final Short USER_NODE_LBSHOP = 121;
	public static final Short USER_NODE_LBHELP = 122;
	public static final Short USER_NODE_LBNUSER = 123;
	public static final Short USER_NODE_LKNUSU = 124;
	public static final Short USER_NODE_LBFPLAY2 = 125;
	public static final Short USER_NODE_NGFPLAY1 = 127;
	public static final Short USER_NODE_NGFPLAY2 = 128;

	// 1001我的奖品
	public static final Short USER_NODE_MYPRIZE = 1001;

	// Fields

	private Integer id;
	private Long fbId;
	private Short node;
	private Long sessionId;
	private Integer objectId;
	private Short isNewUser;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public UserNodeLog() {}

	/** full constructor */
	public UserNodeLog(Long fbId, Short node, Long sessionId, Integer objectId,
			Short isNewUser, Timestamp createTime) {
		this.fbId = fbId;
		this.node = node;
		this.sessionId = sessionId;
		this.objectId = objectId;
		this.isNewUser = isNewUser;
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

	@Column(name = "Node", nullable = false)
	public Short getNode() {
		return this.node;
	}

	public void setNode(Short node) {
		this.node = node;
	}

	@Column(name = "SessionId")
	public Long getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "ObjectId")
	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	@Column(name = "IsNewUser", nullable = false)
	public Short getIsNewUser() {
		return this.isNewUser;
	}

	public void setIsNewUser(Short isNewUser) {
		this.isNewUser = isNewUser;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}