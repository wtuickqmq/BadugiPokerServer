package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * UserFund entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_fund1")
public class UserFund1 extends BaseEntity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2613888651468035693L;
	
	private Long fbId;
	private Double chips = 0.0;
	private Double expValue = 0.0;
	private Double totalVipValue = 0.0;
	private Integer vipLevel = 0;
	private Timestamp vipStartDate;
	private Double currVipValue = 0.0;
	private Double vipPoints = 0.0;
	private Integer masterValue = 0;
	private Integer goldValue = 0;
	private String bestHands;
	private Double maxChips = 0.0;
	private Double roundMaxChips = 0.0;
	private Integer praiseNum = 0;

	private Integer expLevel;// 普通等级
	private String fbName;// fb名称
	private int isRobot;// 是否为机器人
	private int loginDays;// 连续登陆天数
	private Timestamp createTime;// 注册时间
	private String city;
	private Short sex;
	private String imgurl;

	// Constructors

	/** default constructor */
	public UserFund1() {}

	/** minimal constructor */
	public UserFund1(Long fbId, Double chips, Double expValue,
			Double totalVipValue, Integer vipLevel, Double currVipValue,
			Double vipPoints, Double maxChips, Double roundMaxChips) {
		this.fbId = fbId;
		this.chips = chips;
		this.expValue = expValue;
		this.totalVipValue = totalVipValue;
		this.vipLevel = vipLevel;
		this.currVipValue = currVipValue;
		this.vipPoints = vipPoints;
		this.maxChips = maxChips;
		this.roundMaxChips = roundMaxChips;
	}

	/** full constructor */
	public UserFund1(Long fbId, Double chips, Double expValue,
			Double totalVipValue, Integer vipLevel, Timestamp vipStartDate,
			Double currVipValue, Double vipPoints, String bestHands,
			Double maxChips, Double roundMaxChips) {
		this.fbId = fbId;
		this.chips = chips;
		this.expValue = expValue;
		this.totalVipValue = totalVipValue;
		this.vipLevel = vipLevel;
		this.vipStartDate = vipStartDate;
		this.currVipValue = currVipValue;
		this.vipPoints = vipPoints;
		this.bestHands = bestHands;
		this.maxChips = maxChips;
		this.roundMaxChips = roundMaxChips;
	}

	// Property accessors
	@Id
	@Column(name = "FbId", unique = true, nullable = false)
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

	@Column(name = "ExpValue", nullable = false, scale = 4)
	public Double getExpValue() {
		return this.expValue;
	}

	public void setExpValue(Double expValue) {
		this.expValue = expValue;
	}

	@Column(name = "TotalVipValue", nullable = false, scale = 4)
	public Double getTotalVipValue() {
		return this.totalVipValue;
	}

	public void setTotalVipValue(Double totalVipValue) {
		this.totalVipValue = totalVipValue;
	}

	@Column(name = "VipLevel", nullable = false)
	public Integer getVipLevel() {
		return this.vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	@Column(name = "VipStartDate", length = 19)
	public Timestamp getVipStartDate() {
		return this.vipStartDate;
	}

	public void setVipStartDate(Timestamp vipStartDate) {
		this.vipStartDate = vipStartDate;
	}

	@Column(name = "CurrVipValue", nullable = false, scale = 4)
	public Double getCurrVipValue() {
		return this.currVipValue;
	}

	public void setCurrVipValue(Double currVipValue) {
		this.currVipValue = currVipValue;
	}

	@Column(name = "VipPoints", nullable = false, scale = 4)
	public Double getVipPoints() {
		return this.vipPoints;
	}

	public void setVipPoints(Double vipPoints) {
		this.vipPoints = vipPoints;
	}

	@Column(name = "MasterValue", nullable = false)
	public Integer getMasterValue() {
		return masterValue;
	}

	public void setMasterValue(Integer masterValue) {
		this.masterValue = masterValue;
	}

	@Column(name = "GoldValue", nullable = false)
	public Integer getGoldValue() {
		return goldValue;
	}

	public void setGoldValue(Integer goldValue) {
		this.goldValue = goldValue;
	}

	@Column(name = "BestHands", length = 100)
	public String getBestHands() {
		return this.bestHands;
	}

	public void setBestHands(String bestHands) {
		this.bestHands = bestHands;
	}

	@Column(name = "MaxChips", nullable = false, scale = 4)
	public Double getMaxChips() {
		return this.maxChips;
	}

	public void setMaxChips(Double maxChips) {
		this.maxChips = maxChips;
	}

	@Column(name = "RoundMaxChips", nullable = false, scale = 4)
	public Double getRoundMaxChips() {
		return this.roundMaxChips;
	}

	public void setRoundMaxChips(Double roundMaxChips) {
		this.roundMaxChips = roundMaxChips;
	}

	@Column(name = "praiseNum")
	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	@Transient
	public Integer getExpLevel() {
		return expLevel;
	}

	public void setExpLevel(Integer expLevel) {
		this.expLevel = expLevel;
	}

	@Transient
	public String getFbName() {
		return fbName;
	}

	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

	@Transient
	public int getIsRobot() {
		return isRobot;
	}

	public void setIsRobot(int isRobot) {
		this.isRobot = isRobot;
	}

	@Transient
	public int getLoginDays() {
		return loginDays;
	}

	public void setLoginDays(int loginDays) {
		this.loginDays = loginDays;
	}

	@Transient
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Transient
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Transient
	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	@Transient
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

}