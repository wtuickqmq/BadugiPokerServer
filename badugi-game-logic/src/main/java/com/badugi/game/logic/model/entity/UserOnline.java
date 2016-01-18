package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * UserOnline entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_online")
public class UserOnline extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long fbId;
	private String fbKey;
	private String sign;
	private Timestamp updateTime;
	private String openkey;
	private String pf;
	private String pfkey;
	private String userip;
	private String openid;
	private Integer sex;
	private String city;
	private Integer role;
	private String name;
	private String imageurl;
	private Long chips;

	// Constructors

	/** default constructor */
	public UserOnline() {}

	/** minimal constructor */
	public UserOnline(Long fbId) {
		this.fbId = fbId;
	}

	/** full constructor */
	public UserOnline(Long fbId, String fbKey, Timestamp updateTime) {
		this.fbId = fbId;
		this.fbKey = fbKey;
		this.updateTime = updateTime;
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

	@Column(name = "FbKey", length = 250)
	public String getFbKey() {
		return this.fbKey;
	}

	public void setFbKey(String fbKey) {
		this.fbKey = fbKey;
	}

	@Column(name = "Sign", length = 36)
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Column(name = "UpdateTime", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "openkey")
	public String getOpenkey() {
		return openkey;
	}

	public void setOpenkey(String openkey) {
		this.openkey = openkey;
	}
	@Column(name = "pf")
	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}
	@Column(name = "pfkey")
	public String getPfkey() {
		return pfkey;
	}

	public void setPfkey(String pfkey) {
		this.pfkey = pfkey;
	}
	@Column(name = "userip")
	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	@Transient
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Transient
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	@Transient
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Transient
	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	@Transient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Transient
	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Transient
	public Long getChips() {
		return chips;
	}

	public void setChips(Long chips) {
		this.chips = chips;
	}

}