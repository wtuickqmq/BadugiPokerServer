package com.badugi.game.logic.model.vo.flash.operators;

public class SuccessBuyChipsVo {

	/**
	 * 返回码
	 */
	private String cmd;
	private Long code;

	private Long fbid;
	private Double chips;
	private String cur;
	private String locprice;

	public SuccessBuyChipsVo(String cmd, Long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}

	
	public SuccessBuyChipsVo(String cmd, Long code, Long fbid, Double chips,
			String cur, String locprice) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.fbid = fbid;
		this.chips = chips;
		this.cur = cur;
		this.locprice = locprice;
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

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public Double getChips() {
		return chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	public String getCur() {
		return cur;
	}

	public void setCur(String cur) {
		this.cur = cur;
	}

	public String getLocprice() {
		return locprice;
	}

	public void setLocprice(String locprice) {
		this.locprice = locprice;
	}

	

}
