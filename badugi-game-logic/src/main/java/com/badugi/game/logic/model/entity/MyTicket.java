package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MyTicket entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "my_ticket")
public class MyTicket extends BaseEntity implements java.io.Serializable {

	/**
	 * 比赛获得:0
	 */
	public static final Short GETTYPE_MATCH = 0;
	/**
	 * 系统赠送:1
	 */
	public static final Short GETTYPE_SYS = 1;
	
	/**
	 * 失联好友:2
	 */
	public static final Short GETTYPE_SFRIENDS = 2;
	/**
	 * 宝箱:3
	 */
	public static final Short GETTYPE_BOX = 3;
	/**
	 * 签到:4
	 */
	public static final Short GETTYPE_SIGN = 4;
	/**
	 * 任务:5
	 */
	public static final Short GETTYPE_TASK = 5;
	
	/**
	 * 猜大小:6
	 */
	public static final Short GETTYPE_GUESS = 6;
	
	/**
	 * 额外惊喜:7
	 */
	public static final Short GETTYPE_EXTRA = 7;
	
	/**
	 * 用户赠送:8
	 */
	public static final Short GETTYPE_PRESENT = 8;
	
	/**
	 * 金块兑换:9
	 */
	public static final Short GETTYPE_GOLDEXCHANGE = 9;
	
	/**
	 * 是否使用:0否
	 */
	public static final Short ISUSED_FALSE = 0;
	/**
	 * 是否使用:1是
	 */
	public static final Short ISUSED_TRUE = 1;
	
	public static final Short GETJEWEL_BOX=100;
	// Fields

	private Integer id;
	private Long fbId;
	private Short getType;
	private Integer matchId;
	private Integer ticketId;
	private Short isUsed;
	private Timestamp validFrom;
	private Timestamp validTo;
	private Timestamp createTime;
	private String sysRemark;

	// Constructors

	/** default constructor */
	public MyTicket() {
	}

	/** minimal constructor */
	public MyTicket(Long fbId, Short getType, Integer ticketId,
			Timestamp createTime) {
		this.fbId = fbId;
		this.getType = getType;
		this.ticketId = ticketId;
		this.createTime = createTime;
	}
	
	/**
	 * 查询比赛使用
	 */
	public MyTicket(Integer id, Long fbId, Short getType, Integer matchId,
			Integer ticketId, Short isUsed, Object createTime) {
		this.id = id;
		this.fbId = fbId;
		this.getType = getType;
		this.matchId = matchId;
		this.ticketId = ticketId;
		this.isUsed = isUsed;
		this.createTime = string2Timestamp(createTime.toString());
	}

	/** full constructor */
	public MyTicket(Long fbId, Short getType, Integer matchId,
			Integer ticketId, Timestamp validFrom, Timestamp validTo,
			Short isUsed, Timestamp createTime) {
		super();
		this.fbId = fbId;
		this.getType = getType;
		this.matchId = matchId;
		this.ticketId = ticketId;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.isUsed = isUsed;
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

	@Column(name = "GetType", nullable = false)
	public Short getGetType() {
		return this.getType;
	}

	public void setGetType(Short getType) {
		this.getType = getType;
	}

	@Column(name = "MatchId")
	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	@Column(name = "TicketId", nullable = false)
	public Integer getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@Column(name = "IsUsed")
	public Short getIsUsed() {
		return this.isUsed;
	}

	public void setIsUsed(Short isUsed) {
		this.isUsed = isUsed;
	}
	
	@Column(name = "ValidFrom", nullable = false, length = 19)
	public Timestamp getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	@Column(name = "ValidTo", nullable = false, length = 19)
	public Timestamp getValidTo() {
		return this.validTo;
	}
	
	public void setValidTo(Timestamp validTo) {
		this.validTo = validTo;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "SysRemark", length = 1000)
	public String getSysRemark() {
		return sysRemark;
	}
	
	public void setSysRemark(String sysRemark) {
		this.sysRemark = sysRemark;
	}

}