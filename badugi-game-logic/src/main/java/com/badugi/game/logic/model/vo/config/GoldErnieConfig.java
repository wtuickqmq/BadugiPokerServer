package com.badugi.game.logic.model.vo.config;

/**
 * 金块摇奖配置
 * 
 * @author amin
 */
public class GoldErnieConfig {

	private int gold;// 摇奖需要的金块
	private int count;// 每日摇奖次数

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
