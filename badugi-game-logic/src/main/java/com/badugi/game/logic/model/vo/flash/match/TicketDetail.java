package com.badugi.game.logic.model.vo.flash.match;

public class TicketDetail {

	private String tn;
	private int tc;

	public TicketDetail() {
		super();
	}

	public TicketDetail(String tn, int tc) {
		super();
		this.tn = tn;
		this.tc = tc;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	public int getTc() {
		return tc;
	}

	public void setTc(int tc) {
		this.tc = tc;
	}

}
