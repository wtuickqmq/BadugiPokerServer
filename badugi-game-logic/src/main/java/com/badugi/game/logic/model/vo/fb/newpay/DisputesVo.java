package com.badugi.game.logic.model.vo.fb.newpay;

import java.io.Serializable;

public class DisputesVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_comment;
	private String time_created;
	private String user_email;
	public String getUser_comment() {
		return user_comment;
	}
	public void setUser_comment(String userComment) {
		user_comment = userComment;
	}
	public String getTime_created() {
		return time_created;
	}
	public void setTime_created(String timeCreated) {
		time_created = timeCreated;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String userEmail) {
		user_email = userEmail;
	}
	
	
}
