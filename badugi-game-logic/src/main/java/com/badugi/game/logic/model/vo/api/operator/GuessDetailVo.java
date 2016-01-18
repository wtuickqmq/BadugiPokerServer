package com.badugi.game.logic.model.vo.api.operator;

public class GuessDetailVo {

	private String hp;// 牌型

	public GuessDetailVo() {
		super();
	}

	public GuessDetailVo(String hp) {
		super();
		this.hp = hp;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

}
