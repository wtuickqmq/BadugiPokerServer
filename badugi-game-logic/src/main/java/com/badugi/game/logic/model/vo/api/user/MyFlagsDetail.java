package com.badugi.game.logic.model.vo.api.user;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * @author amin
 */
public class MyFlagsDetail extends ResultVo {

	private Long fbid;
	private int isfish;
	private int iseme;

	public MyFlagsDetail() {
		super();
	}

	public MyFlagsDetail(Long fbid, int isfish, int iseme) {
		super();
		this.fbid = fbid;
		this.isfish = isfish;
		this.iseme = iseme;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public int getIsfish() {
		return isfish;
	}

	public void setIsfish(int isfish) {
		this.isfish = isfish;
	}

	public int getIseme() {
		return iseme;
	}

	public void setIseme(int iseme) {
		this.iseme = iseme;
	}

}
