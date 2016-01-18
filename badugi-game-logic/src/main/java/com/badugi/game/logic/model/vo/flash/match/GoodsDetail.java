package com.badugi.game.logic.model.vo.flash.match;

public class GoodsDetail {

	private String gn;
	private int gc;
	private int gtp;

	public GoodsDetail() {
		super();
	}

	public GoodsDetail(String gn, int gc) {
		super();
		this.gn = gn;
		this.gc = gc;
	}

	public GoodsDetail(String gn, int gc, int gtp) {
		super();
		this.gn = gn;
		this.gc = gc;
		this.gtp = gtp;
	}

	public String getGn() {
		return gn;
	}

	public void setGn(String gn) {
		this.gn = gn;
	}

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}

	public int getGtp() {
		return gtp;
	}

	public void setGtp(int gtp) {
		this.gtp = gtp;
	}

}
