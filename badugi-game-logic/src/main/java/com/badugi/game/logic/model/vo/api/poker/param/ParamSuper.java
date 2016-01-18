package com.badugi.game.logic.model.vo.api.poker.param;

import java.io.Serializable;

public class ParamSuper implements Serializable{
	
	private static final long serialVersionUID = 11111115648656L;
	// 签名
	private String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
