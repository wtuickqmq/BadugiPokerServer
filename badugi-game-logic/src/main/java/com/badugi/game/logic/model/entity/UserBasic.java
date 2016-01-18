package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "user_basic")
public class UserBasic extends BaseEntity implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8610535695784465336L;
	private Integer id;
	private Long userId;
	private String openid;
	private String nickname;
	private String gender;
	private String country;
	private String province;
	private String city;
	private String figureurl;
	private Integer is_yellow_vip;
	private Integer is_yellow_year_vip;
	private Integer yellow_vip_level;
	private Integer is_yellow_high_vip;
	private Timestamp createTime;
	
	private String qq_level;
	private String qq_vip_level;
	private String qplus_level;
	private Integer is_blue_vip;
	private Integer is_blue_year_vip;
	private String blue_vip_level;
	private Integer is_super_blue_vip;
	private String pf;
	private String weiboname;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "userId")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name = "openid")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Column(name = "nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name = "province")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "figureurl")
	public String getFigureurl() {
		return figureurl;
	}
	public void setFigureurl(String figureurl) {
		this.figureurl = figureurl;
	}
	@Column(name = "is_yellow_vip")
	public Integer getIs_yellow_vip() {
		return is_yellow_vip;
	}
	public void setIs_yellow_vip(Integer isYellowVip) {
		is_yellow_vip = isYellowVip;
	}
	@Column(name = "is_yellow_year_vip")
	public Integer getIs_yellow_year_vip() {
		return is_yellow_year_vip;
	}
	public void setIs_yellow_year_vip(Integer isYellowYearVip) {
		is_yellow_year_vip = isYellowYearVip;
	}
	@Column(name = "yellow_vip_level")
	public Integer getYellow_vip_level() {
		return yellow_vip_level;
	}
	public void setYellow_vip_level(Integer yellowVipLevel) {
		yellow_vip_level = yellowVipLevel;
	}
	@Column(name = "is_yellow_high_vip")
	public Integer getIs_yellow_high_vip() {
		return is_yellow_high_vip;
	}
	public void setIs_yellow_high_vip(Integer isYellowHighVip) {
		is_yellow_high_vip = isYellowHighVip;
	}
	@Column(name = "createTime")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Column(name = "qq_level")
	public String getQq_level() {
		return qq_level;
	}
	public void setQq_level(String qqLevel) {
		qq_level = qqLevel;
	}
	@Column(name = "qq_vip_level")
	public String getQq_vip_level() {
		return qq_vip_level;
	}
	public void setQq_vip_level(String qqVipLevel) {
		qq_vip_level = qqVipLevel;
	}
	@Column(name = "qplus_level")
	public String getQplus_level() {
		return qplus_level;
	}
	public void setQplus_level(String qplusLevel) {
		qplus_level = qplusLevel;
	}
	@Column(name = "is_blue_vip")
	public Integer getIs_blue_vip() {
		return is_blue_vip;
	}
	public void setIs_blue_vip(Integer isBlueVip) {
		is_blue_vip = isBlueVip;
	}
	@Column(name = "is_blue_year_vip")
	public Integer getIs_blue_year_vip() {
		return is_blue_year_vip;
	}
	public void setIs_blue_year_vip(Integer isBlueYearVip) {
		is_blue_year_vip = isBlueYearVip;
	}
	@Column(name = "blue_vip_level")
	public String getBlue_vip_level() {
		return blue_vip_level;
	}
	public void setBlue_vip_level(String blueVipLevel) {
		blue_vip_level = blueVipLevel;
	}
	@Column(name = "is_super_blue_vip")
	public Integer getIs_super_blue_vip() {
		return is_super_blue_vip;
	}
	public void setIs_super_blue_vip(Integer isSuperBlueVip) {
		is_super_blue_vip = isSuperBlueVip;
	}
	@Column(name = "pf")
	public String getPf() {
		return pf;
	}
	public void setPf(String pf) {
		this.pf = pf;
	}
	
	@Column(name = "weiboname")
	public String getWeiboname() {
		return weiboname;
	}
	public void setWeiboname(String weiboname) {
		this.weiboname = weiboname;
	}
 
	
}
