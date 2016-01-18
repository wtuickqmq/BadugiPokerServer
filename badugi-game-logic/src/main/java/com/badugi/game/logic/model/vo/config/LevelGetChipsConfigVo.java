package com.badugi.game.logic.model.vo.config;

/**
 * 
 * @author amin
 */
public class LevelGetChipsConfigVo {

	private int level;
	private TaskRewardVo reward;

	public LevelGetChipsConfigVo() {
	}

	public LevelGetChipsConfigVo(int level, TaskRewardVo reward) {
		super();
		this.level = level;
		this.reward = reward;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public TaskRewardVo getReward() {
		return reward;
	}
	
	public void setReward(TaskRewardVo reward) {
		this.reward = reward;
	}

}
