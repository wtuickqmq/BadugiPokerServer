package com.badugi.game.logic.model.domain.vo.poker.param;

public class GetAppFriendsVo extends ParamSuper {

	private static final long serialVersionUID = 148515648456431L;

	private String openid;
	
	private String openkey;
	
	private String pf;
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenkey() {
		return openkey;
	}

	public void setOpenkey(String openkey) {
		this.openkey = openkey;
	}

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
