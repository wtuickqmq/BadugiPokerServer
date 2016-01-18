package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class Users extends BaseEntity implements java.io.Serializable {

	/**
	 * 是否为机器人(1:是，0 不是)
	 */
	public static final Short ROBOT_TRUE = 1;

	/**
	 * 是否为机器人(1:是，0 不是)
	 */
	public static final Short ROBOT_NO = 0;

	// Fields

	private Long fbId;
	private String fbName;
	private String email;
	private Short sex;
	private Timestamp regTime;
	private Timestamp lastLoginTime;
	private String lastLoginIp;
	private Integer loginDays;
	private Short isRobot = ROBOT_NO;
	private Short isGetFriends;
	private String openid;
	private String imgurl;
	private String city;
	private String phone;
	
	// add by fengpeijie 20150528 begin
	/*地址*/
	private String address;
	/*真实姓名*/
	private String realName;
	// add by fengpeijie 20150528 end

	// Constructors

	/** default constructor */
	public Users() {}

	/** minimal constructor */
	public Users(Long fbId, String fbName, String email, Timestamp regTime) {
		this.fbId = fbId;
		this.fbName = fbName;
		this.email = email;
		this.regTime = regTime;
	}

	/** full constructor */
	public Users(Long fbId, String fbName, String email, Short sex,
			Timestamp regTime, Timestamp lastLoginTime, String lastLoginIp,
			Integer loginDays) {
		this.fbId = fbId;
		this.fbName = fbName;
		this.email = email;
		this.sex = sex;
		this.regTime = regTime;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.loginDays = loginDays;
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

	@Column(name = "FbName", nullable = false, length = 100)
	public String getFbName() {
		return this.fbName;
	}

	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

	@Column(name = "Email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Sex")
	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	@Column(name = "RegTime", nullable = false, length = 19)
	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	@Column(name = "LastLoginTime", length = 19)
	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "LastLoginIp", length = 45)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "LoginDays")
	public Integer getLoginDays() {
		return this.loginDays;
	}

	public void setLoginDays(Integer loginDays) {
		this.loginDays = loginDays;
	}

	@Column(name = "IsRobot", nullable = false)
	public Short getIsRobot() {
		return isRobot;
	}

	public void setIsRobot(Short isRobot) {
		this.isRobot = isRobot;
	}

	@Column(name = "openid", nullable = false)
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "is_get_friends", nullable = false)
	public Short getIsGetFriends() {
		return isGetFriends;
	}

	public void setIsGetFriends(Short isGetFriends) {
		this.isGetFriends = isGetFriends;
	}

	@Transient
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}