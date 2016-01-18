package com.badugi.game.logic.model.vo.flash.operators;

import java.util.List;

public class SpreaduserVo {

	private String cmd;
	/**
	 * 返回码 
	 */
	private Long code;
	
	private List<SpreadChips> mlist;
	
	private List<RpomoteUser> ulist;
	
	

	public SpreaduserVo(String cmd, Long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}

	public SpreaduserVo(String cmd, Long code, List<SpreadChips> mlist,
			List<RpomoteUser> ulist) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.mlist = mlist;
		this.ulist = ulist;
	}

	public SpreaduserVo() {
		super();
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

	public List<SpreadChips> getMlist() {
		return mlist;
	}

	public void setMlist(List<SpreadChips> mlist) {
		this.mlist = mlist;
	}

	public List<RpomoteUser> getUlist() {
		return ulist;
	}

	public void setUlist(List<RpomoteUser> ulist) {
		this.ulist = ulist;
	}
	
	
}
