package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * MatchUsers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_users")
public class MatchUsers extends BaseEntity implements java.io.Serializable {

	/**
	 * 已报名
	 */
	public static final Short STATUS_REG = 0;
	
	/**
	 * 游戏中
	 */
	public static final Short STATUS_PLAY = 1;
	
	/**
	 * 游戏结束
	 */
	public static final Short STATUS_END = 2;
	
	/**
	 * 已取消
	 */
	public static final Short STATUS_CANCEL = 9;
	
	/**
	 * 报名方式筹码
	 */
	public static final Short PAYTYPE_CHIPS = 0;
	
	/**
	 * 报名方式积分
	 */
	public static final Short PAYTYPE_JF = 1;
	
	/**
	 * 报名方式门票
	 */
	public static final Short PAYTYPE_MP = 2;
	
	/**
	 * 报名方式推广代理
	 */
	public static final Short PAYTYPE_TGDL = 3;
	
	/**
	 * 报名方式密码
	 */
	public static final Short PAYTYPE_MM = 4;
	
	
	// Fields

	private Integer id;
	private Integer matchId;
	private Long fbId;
	private Short payType;
	private Double payAmount;
	private Timestamp registTime;
	private Short status;
	private Timestamp bustTime;
	private Integer rank;
	private Double bonus;
	private Integer ticketId;
	private Integer roomId;
	private String cuid;
	private Integer roomSort;
	
	private String fbName;

	// Constructors

	/** default constructor */
	public MatchUsers() {
	}

	/** minimal constructor */
	public MatchUsers(Integer matchId, Long fbId, Short payType,
			Double payAmount, Timestamp registTime, Short status) {
		this.matchId = matchId;
		this.fbId = fbId;
		this.payType = payType;
		this.payAmount = payAmount;
		this.registTime = registTime;
		this.status = status;
	}

	/** full constructor */
	public MatchUsers(Integer matchId, Long fbId, Short payType,
			Double payAmount, Timestamp registTime, Short status,
			Timestamp bustTime, Integer rank, Double bonus, Integer roomId,
			String cuid, Integer roomSort) {
		this.matchId = matchId;
		this.fbId = fbId;
		this.payType = payType;
		this.payAmount = payAmount;
		this.registTime = registTime;
		this.status = status;
		this.bustTime = bustTime;
		this.rank = rank;
		this.bonus = bonus;
		this.roomId = roomId;
		this.cuid = cuid;
		this.roomSort = roomSort;
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

	@Column(name = "MatchId", nullable = false)
	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "PayType", nullable = false)
	public Short getPayType() {
		return this.payType;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	@Column(name = "PayAmount", nullable = false, scale = 4)
	public Double getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	@Column(name = "RegistTime", nullable = false, length = 19)
	public Timestamp getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	@Column(name = "Status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "BustTime", length = 19)
	public Timestamp getBustTime() {
		return this.bustTime;
	}

	public void setBustTime(Timestamp bustTime) {
		this.bustTime = bustTime;
	}

	@Column(name = "Rank")
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Column(name = "Bonus", scale = 4)
	public Double getBonus() {
		return this.bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	
	@Column(name = "TicketId")
	public Integer getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@Column(name = "RoomID")
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Column(name = "CUID", length = 50)
	public String getCuid() {
		return this.cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}

	@Column(name = "RoomSort")
	public Integer getRoomSort() {
		return this.roomSort;
	}

	public void setRoomSort(Integer roomSort) {
		this.roomSort = roomSort;
	}
	
	@Transient
	public String getFbName() {
		return fbName;
	}
	
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

}