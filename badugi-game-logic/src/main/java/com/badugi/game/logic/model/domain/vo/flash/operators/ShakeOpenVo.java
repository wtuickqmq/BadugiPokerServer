package com.badugi.game.logic.model.domain.vo.flash.operators;

public class ShakeOpenVo {
	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;
	
	private Long rid;
	
	private Long fbid;
	
	private String fbname;
	
	private Integer wintype;
	
	private String wincards;
	
	private Long winchips;

	public ShakeOpenVo() {
		super();
	}

	





	public ShakeOpenVo(String cmd, Long code, Long rid, Long fbid,
			String fbname, Integer wintype, String wincards, Long winchips) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.rid = rid;
		this.fbid = fbid;
		this.fbname = fbname;
		this.wintype = wintype;
		this.wincards = wincards;
		this.winchips = winchips;
	}







	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}


	public String getFbname() {
		return fbname;
	}

	public void setFbname(String fbname) {
		this.fbname = fbname;
	}



	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Integer getWintype() {
		return wintype;
	}

	public void setWintype(Integer wintype) {
		this.wintype = wintype;
	}

	public String getWincards() {
		return wincards;
	}

	public void setWincards(String wincards) {
		this.wincards = wincards;
	}

	public Long getWinchips() {
		return winchips;
	}

	public void setWinchips(Long winchips) {
		this.winchips = winchips;
	}
	
	
	

}
