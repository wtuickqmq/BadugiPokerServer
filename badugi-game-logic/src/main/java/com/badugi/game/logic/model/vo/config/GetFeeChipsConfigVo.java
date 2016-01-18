package com.badugi.game.logic.model.vo.config;

/**
 * 获得免费筹码配置
 * 
 * @author amin
 */
public class GetFeeChipsConfigVo {

	private int type;// 签到需要的次数
	private double chips;// 获得筹码

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getChips() {
		return chips;
	}

	public void setChips(double chips) {
		this.chips = chips;
	}

}
