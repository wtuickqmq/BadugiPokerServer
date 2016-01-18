package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class RqPaymentsGetItemsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5754647159106563668L;
	private String algorithm;
	private PaymentsGetItemsVO credits;
	private String expires;
	private String issued_at;
	private String oauth_token;
	private FbUserVO user;
	private String user_id;
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public PaymentsGetItemsVO getCredits() {
		return credits;
	}
	public void setCredits(PaymentsGetItemsVO credits) {
		this.credits = credits;
	}
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	public String getIssued_at() {
		return issued_at;
	}
	public void setIssued_at(String issuedAt) {
		issued_at = issuedAt;
	}
	public String getOauth_token() {
		return oauth_token;
	}
	public void setOauth_token(String oauthToken) {
		oauth_token = oauthToken;
	}
	public FbUserVO getUser() {
		return user;
	}
	public void setUser(FbUserVO user) {
		this.user = user;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	
	

}
