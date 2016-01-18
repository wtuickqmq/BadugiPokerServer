package com.badugi.game.logic.model.vo.config;

import java.util.List;

/**
 * 
* 项目名称：qq1.0   
* 类名称：ChestTicketConfigVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Apr 2, 2013 4:24:26 PM    
* @version 1.0
 */
public class ChestTicketConfigVo {

	private int count;
	private int duration;
	private List<TaskRewardVo> reward;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<TaskRewardVo> getReward() {
		return reward;
	}
	
	public void setReward(List<TaskRewardVo> reward) {
		this.reward = reward;
	}

	
}
