package com.badugi.game.logic.model.vo.config;

import java.util.List;

/**
 * 猜大小获奖详细配置
 * 
 * @author amin
 */
public class GuessTicketDetail {

	private int gc;// 猜对的次数
	private List<TaskRewardVo> reward;

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}

	public List<TaskRewardVo> getReward() {
		return reward;
	}
	
	public void setReward(List<TaskRewardVo> reward) {
		this.reward = reward;
	}

}
