package com.badugi.game.logic.model.domain.vo.flash.user;

/**
 * @copyright：Copyright 2011  xxoo.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-11-9
 * @description：掉线用户信息
 */
public class LoseUserInfo {
	/***
	 * fbid
	 */
	private Long fbId;
	/****
	 * 断线时间
	 */
	private Long loseTime;
	

	public LoseUserInfo(Long fbId, Long loseTime) {
		super();
		this.fbId = fbId;
		this.loseTime = loseTime;
	}
	
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public Long getLoseTime() {
		return loseTime;
	}
	public void setLoseTime(Long loseTime) {
		this.loseTime = loseTime;
	}
	
	
	
}
