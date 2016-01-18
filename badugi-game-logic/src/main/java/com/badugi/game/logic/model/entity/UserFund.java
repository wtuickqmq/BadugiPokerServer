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

public class UserFund extends BaseEntity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long fbid;
	private Double chips = 0.0;
	private Double exp = 0.0;
	private Integer viplv = 0;
	private Timestamp vip_valid_time;
	private Integer points = 0;
	private Integer bill = 0;
	private String bestHands;
	private Double max_chips = 0.0;
	private Double round_max_chips = 0.0;
	private Integer praise_count = 0;
	private Integer expLevel;// 普通等级
	private String fbname;// fb名称
	private int isRobot;// 是否为机器人
	private int LoginDays;// 连续登陆天数
	private Timestamp regTime;// 注册时间
	private String city;
	private Short Sex;
	
	private String imgurl;

	// Constructors

	/** default constructor */
	public UserFund() {}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public Double getChips() {
		return chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	public Double getExp() {
		return exp;
	}

	public void setExp(Double exp) {
		this.exp = exp;
	}

	public Integer getViplv() {
		return viplv;
	}

	public void setViplv(Integer viplv) {
		this.viplv = viplv;
	}

	public Timestamp getVip_valid_time() {
		return vip_valid_time;
	}

	public void setVip_valid_time(Timestamp vip_valid_time) {
		this.vip_valid_time = vip_valid_time;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getBill() {
		return bill;
	}

	public void setBill(Integer bill) {
		this.bill = bill;
	}

	public String getBestHands() {
		return bestHands;
	}

	public void setBestHands(String bestHands) {
		this.bestHands = bestHands;
	}

	public Double getMax_chips() {
		return max_chips;
	}

	public void setMax_chips(Double max_chips) {
		this.max_chips = max_chips;
	}

	public Double getRound_max_chips() {
		return round_max_chips;
	}

	public void setRound_max_chips(Double round_max_chips) {
		this.round_max_chips = round_max_chips;
	}

	public Integer getPraise_count() {
		return praise_count;
	}

	public void setPraise_count(Integer praise_count) {
		this.praise_count = praise_count;
	}

	

	public Integer getExpLevel() {
		return expLevel;
	}

	public void setExpLevel(Integer expLevel) {
		this.expLevel = expLevel;
	}

	public String getFbname() {
		return fbname;
	}

	public void setFbname(String fbname) {
		this.fbname = fbname;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getIsRobot() {
		return isRobot;
	}

	public void setIsRobot(int isRobot) {
		this.isRobot = isRobot;
	}

	public int getLoginDays() {
		return LoginDays;
	}

	public void setLoginDays(int loginDays) {
		LoginDays = loginDays;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Short getSex() {
		return Sex;
	}

	public void setSex(Short sex) {
		Sex = sex;
	}

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserFund [fbid=" + fbid + ", chips=" + chips + ", exp=" + exp
				+ ", viplv=" + viplv + ", vip_valid_time=" + vip_valid_time
				+ ", points=" + points + ", bill=" + bill + ", bestHands="
				+ bestHands + ", max_chips=" + max_chips + ", round_max_chips="
				+ round_max_chips + ", praise_count=" + praise_count
				+ ", expLevel=" + expLevel + ", fbname=" + fbname
				+ ", isRobot=" + isRobot + ", LoginDays=" + LoginDays
				+ ", regTime=" + regTime + ", city=" + city + ", Sex=" + Sex
				+ ", imgurl=" + imgurl + "]";
	}

	
	

}