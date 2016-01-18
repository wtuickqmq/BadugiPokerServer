package com.badugi.game.logic.model.vo.record;

import java.math.BigInteger;
import java.sql.Timestamp;

public class LoginDetailRecordVo {
	
	public Timestamp loginTime;
	public Long fbId;
	public String userName;
	
	
	public LoginDetailRecordVo(Timestamp loginTime, Long fbId, String userName) {
		super();
		this.loginTime =loginTime;
		this.fbId = fbId;
		this.userName = userName;
	}
	
	public LoginDetailRecordVo(BigInteger fbId, String userName) {
		super();
		this.fbId = fbId.longValue();
		this.userName = userName;
	}
	


	public LoginDetailRecordVo() {
		super();
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
