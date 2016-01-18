package com.badugi.game.logic.model.vo.config;

/**
 * 新手礼包奖励配置
 * 
 * @author amin
 */
public class NewUserRewardConfig {

	private int st;
	private TaskRewardVo reward;

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public TaskRewardVo getReward() {
		return reward;
	}

	public void setReward(TaskRewardVo reward) {
		this.reward = reward;
	}

}
