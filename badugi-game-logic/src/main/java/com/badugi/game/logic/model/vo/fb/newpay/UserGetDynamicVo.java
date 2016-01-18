package com.badugi.game.logic.model.vo.fb.newpay;

public class UserGetDynamicVo {

	private String algorithm;
	private Long expires;
	private Long issued_at;
	private String oauth_token;
	private UserGetDynamicPaymentVo payment;
	private UserGetDynamicUVo user;
	private String user_id;
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public Long getExpires() {
		return expires;
	}
	public void setExpires(Long expires) {
		this.expires = expires;
	}
	public Long getIssued_at() {
		return issued_at;
	}
	public void setIssued_at(Long issuedAt) {
		issued_at = issuedAt;
	}
	public String getOauth_token() {
		return oauth_token;
	}
	public void setOauth_token(String oauthToken) {
		oauth_token = oauthToken;
	}
	public UserGetDynamicPaymentVo getPayment() {
		return payment;
	}
	public void setPayment(UserGetDynamicPaymentVo payment) {
		this.payment = payment;
	}
	public UserGetDynamicUVo getUser() {
		return user;
	}
	public void setUser(UserGetDynamicUVo user) {
		this.user = user;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	
	
}
