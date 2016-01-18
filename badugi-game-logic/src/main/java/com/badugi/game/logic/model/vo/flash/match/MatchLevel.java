package com.badugi.game.logic.model.vo.flash.match;

public class MatchLevel {
	
	private int ml;
	
	private int mt;
	
	private String ln;

	public MatchLevel(int ml, int mt, String ln) {
		super();
		this.ml = ml;
		this.mt = mt;
		this.ln = ln;
	}

	
	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
	}

	public int getMt() {
		return mt;
	}

	public void setMt(int mt) {
		this.mt = mt;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}
	

	
}
