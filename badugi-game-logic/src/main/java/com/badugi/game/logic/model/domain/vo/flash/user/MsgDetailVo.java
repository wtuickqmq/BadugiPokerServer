package com.badugi.game.logic.model.domain.vo.flash.user;

public class MsgDetailVo {

	private String mn;
	private Integer mc;

	public MsgDetailVo() {
		super();
	}

	public MsgDetailVo(String mn, Integer mc) {
		super();
		this.mn = mn;
		this.mc = mc;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public Integer getMc() {
		return mc;
	}

	public void setMc(Integer mc) {
		this.mc = mc;
	}

}
