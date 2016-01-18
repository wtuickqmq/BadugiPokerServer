package com.badugi.game.logic.model.vo.flash.task;

import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 下一个单任务信息vo
 * 
 * @author amin
 */
public class NextSigleTaskVo {
	/**
	 * 需要完成的局数
	 */
	private int c;
	/**
	 * 需要赢的局数
	 */
	private int wc;
	/**
	 * 奖品名称
	 */
	private TaskRewardVo prize;

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getWc() {
		return wc;
	}

	public void setWc(int wc) {
		this.wc = wc;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

}
