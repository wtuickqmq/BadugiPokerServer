package com.badugi.game.logic.model.vo.qq;

public class UserBasicVo extends TReturnVo{
	
	
	private String nickname;
	private String gender;
	private String country;
	private String province;
	private String city;
	private String figureurl;
	private String openid;
	private String qq_level;
	private String qq_vip_level;
	private String qplus_level;
	private Integer is_yellow_vip;
	private Integer is_yellow_year_vip;
	private Integer yellow_vip_level;
	private Integer is_yellow_high_vip;
	private Integer is_blue_vip;
	private Integer is_blue_year_vip;
	private String blue_vip_level;
	private Integer is_super_blue_vip;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFigureurl() {
		return figureurl;
	}
	public void setFigureurl(String figureurl) {
		this.figureurl = figureurl;
	}
	public Integer getIs_yellow_vip() {
		return is_yellow_vip;
	}
	public void setIs_yellow_vip(Integer isYellowVip) {
		is_yellow_vip = isYellowVip;
	}
	public Integer getIs_yellow_year_vip() {
		return is_yellow_year_vip;
	}
	public void setIs_yellow_year_vip(Integer isYellowYearVip) {
		is_yellow_year_vip = isYellowYearVip;
	}
	public Integer getYellow_vip_level() {
		return yellow_vip_level;
	}
	public void setYellow_vip_level(Integer yellowVipLevel) {
		yellow_vip_level = yellowVipLevel;
	}
	public Integer getIs_yellow_high_vip() {
		return is_yellow_high_vip;
	}
	public void setIs_yellow_high_vip(Integer isYellowHighVip) {
		is_yellow_high_vip = isYellowHighVip;
	}
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getQq_level() {
		return qq_level;
	}
	public void setQq_level(String qqLevel) {
		qq_level = qqLevel;
	}
	public String getQq_vip_level() {
		return qq_vip_level;
	}
	public void setQq_vip_level(String qqVipLevel) {
		qq_vip_level = qqVipLevel;
	}
	public String getQplus_level() {
		return qplus_level;
	}
	public void setQplus_level(String qplusLevel) {
		qplus_level = qplusLevel;
	}
	public Integer getIs_blue_vip() {
		return is_blue_vip;
	}
	public void setIs_blue_vip(Integer isBlueVip) {
		is_blue_vip = isBlueVip;
	}
	public Integer getIs_blue_year_vip() {
		return is_blue_year_vip;
	}
	public void setIs_blue_year_vip(Integer isBlueYearVip) {
		is_blue_year_vip = isBlueYearVip;
	}
	public String getBlue_vip_level() {
		return blue_vip_level;
	}
	public void setBlue_vip_level(String blueVipLevel) {
		blue_vip_level = blueVipLevel;
	}
	public Integer getIs_super_blue_vip() {
		return is_super_blue_vip;
	}
	public void setIs_super_blue_vip(Integer isSuperBlueVip) {
		is_super_blue_vip = isSuperBlueVip;
	}
	@Override
	public String toString() {
		return "UserBasicVo [blue_vip_level=" + blue_vip_level + ", city="
				+ city + ", country=" + country + ", figureurl=" + figureurl
				+ ", gender=" + gender + ", is_blue_vip=" + is_blue_vip
				+ ", is_blue_year_vip=" + is_blue_year_vip
				+ ", is_super_blue_vip=" + is_super_blue_vip
				+ ", is_yellow_high_vip=" + is_yellow_high_vip
				+ ", is_yellow_vip=" + is_yellow_vip + ", is_yellow_year_vip="
				+ is_yellow_year_vip + ", nickname=" + nickname + ", openid="
				+ openid + ", province=" + province + ", qplus_level="
				+ qplus_level + ", qq_level=" + qq_level + ", qq_vip_level="
				+ qq_vip_level + ", yellow_vip_level=" + yellow_vip_level + "]";
	}
	

	
	
}
