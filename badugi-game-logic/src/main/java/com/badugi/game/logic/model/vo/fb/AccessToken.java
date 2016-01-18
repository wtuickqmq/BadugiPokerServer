package com.badugi.game.logic.model.vo.fb;

public class AccessToken {
	private String access_token;
	private Integer expires;
	public AccessToken(String accessToken, Integer expires) {
		super();
		access_token = accessToken;
		this.expires = expires;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String accessToken) {
		access_token = accessToken;
	}
	public Integer getExpires() {
		return expires;
	}
	public void setExpires(Integer expires) {
		this.expires = expires;
	}
	public AccessToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
