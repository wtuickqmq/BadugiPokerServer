package com.badugi.game.logic.model.vo.common;

import java.io.Serializable;

public class UserLoginVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7082187758519180954L;
	
	private Long id;
	private String name;
	private String email;
	private Short sex;
	private String token;//登录凭证
	private Integer origin;//来源 1为facebook,2为新浪.................(举例而以)
	private String sharecoming;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getOrigin() {
		return origin;
	}
	public void setOrigin(Integer origin) {
		this.origin = origin;
	}
	public String getSharecoming() {
		return sharecoming;
	}
	public void setSharecoming(String sharecoming) {
		this.sharecoming = sharecoming;
	}
	
}
