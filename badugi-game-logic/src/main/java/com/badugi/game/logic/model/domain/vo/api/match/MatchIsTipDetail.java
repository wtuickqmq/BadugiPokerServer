package com.badugi.game.logic.model.domain.vo.api.match;

public class MatchIsTipDetail {

	private int type;
	private boolean istip;

	public MatchIsTipDetail() {
		super();
	}

	public MatchIsTipDetail(int type, boolean istip) {
		super();
		this.type = type;
		this.istip = istip;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean getIstip() {
		return istip;
	}

	public void setIstip(boolean istip) {
		this.istip = istip;
	}

}
