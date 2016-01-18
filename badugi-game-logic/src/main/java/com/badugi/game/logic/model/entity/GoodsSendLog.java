package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsSendLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_send_log")
public class GoodsSendLog extends BaseEntity implements java.io.Serializable {

	/**
	 * 已邮寄
	 */
	public static final Short STATUS_0 = 0;
	/**
	 * 已到账
	 */
	public static final Short STATUS_1 = 1;
	
	
	// Fields

	private Integer id;
	private Integer myTicketId;
	private Long fbid;
	private String goodsName;
	private Double value;
	private Short status;
	private String remark;
	private String operatedName;
	private Timestamp operatedTime;
	private Short sendLive = 0;
	
	private String fbname;

	// Constructors

	/** default constructor */
	public GoodsSendLog() {
	}

	/** minimal constructor */
	public GoodsSendLog(Integer myTicketId, Long fbid, Double value,
			Short status, String operatedName, Timestamp operatedTime) {
		this.myTicketId = myTicketId;
		this.fbid = fbid;
		this.value = value;
		this.status = status;
		this.operatedName = operatedName;
		this.operatedTime = operatedTime;
	}

	/** full constructor */
	public GoodsSendLog(Integer myTicketId, Long fbid, String goodsName,
			Double value, Short status, String remark, 
			String operatedName, Timestamp operatedTime) {
		this.myTicketId = myTicketId;
		this.fbid = fbid;
		this.value = value;
		this.status = status;
		this.remark = remark;
		this.operatedName = operatedName;
		this.operatedTime = operatedTime;
	}
	
	public GoodsSendLog(GoodsSendLog log, String goodsName, String fbname){
		this.id = log.getId();
		this.myTicketId = log.getMyTicketId();
		this.fbid = log.getFbid();
		this.value = log.getValue();
		this.status = log.getStatus();
		this.remark = log.getRemark();
		this.operatedName = log.getOperatedName();
		this.operatedTime = log.getOperatedTime();
		this.goodsName = goodsName;
		this.fbname = fbname;		
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

	@Column(name = "MyTicketId")
	public Integer getMyTicketId() {
		return this.myTicketId;
	}

	public void setMyTicketId(Integer myTicketId) {
		this.myTicketId = myTicketId;
	}

	@Column(name = "Fbid", nullable = false)
	public Long getFbid() {
		return this.fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	
	@Column(name = "GoodsName")
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "Value", nullable = false, scale = 4)
	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Column(name = "Status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "Remark", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "OperatedName", nullable = false, length = 50)
	public String getOperatedName() {
		return this.operatedName;
	}

	public void setOperatedName(String operatedName) {
		this.operatedName = operatedName;
	}

	@Column(name = "OperatedTime", nullable = false, length = 19)
	public Timestamp getOperatedTime() {
		return this.operatedTime;
	}

	public void setOperatedTime(Timestamp operatedTime) {
		this.operatedTime = operatedTime;
	}

	@Column(name = "SendLive")
	public Short getSendLive() {
		return this.sendLive;
	}

	public void setSendLive(Short sendLive) {
		this.sendLive = sendLive;
	}
	
	@Transient
	public String getFbname() {
		return fbname;
	}
	
	public void setFbname(String fbname) {
		this.fbname = fbname;
	}

}