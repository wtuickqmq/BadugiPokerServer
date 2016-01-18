package com.badugi.game.logic.model.vo.config;

import java.util.List;

/**
 * 签到宝箱配置
 * 
 * @author amin
 */
public class SignBoxConfigVo {

	private int count;// 签到需要的次数
	private List<TaskRewardVo> reward;//奖品分配方案

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<TaskRewardVo> getReward() {
		return reward;
	}
	
	public void setReward(List<TaskRewardVo> reward) {
		this.reward = reward;
	}

}
