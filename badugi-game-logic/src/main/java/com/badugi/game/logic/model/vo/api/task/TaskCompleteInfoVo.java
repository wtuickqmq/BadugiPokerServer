package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 任务完成请求以及奖励
 * 
 * @author amin
 */
public class TaskCompleteInfoVo {

	private int c;// 需要完成的局数
	private int fc;// 已完成的局数
	private int wc;// 需要赢的局数
	private int fwc;// 已赢的局数
	private TaskRewardVo prize;// 奖励

	public TaskCompleteInfoVo() {
		super();
	}

	public TaskCompleteInfoVo(int c, int fc, int wc, int fwc, TaskRewardVo prize) {
		super();
		this.c = c;
		this.fc = fc;
		this.wc = wc;
		this.fwc = fwc;
		this.prize = prize;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getFc() {
		return fc;
	}

	public void setFc(int fc) {
		this.fc = fc;
	}

	public int getWc() {
		return wc;
	}

	public void setWc(int wc) {
		this.wc = wc;
	}

	public int getFwc() {
		return fwc;
	}

	public void setFwc(int fwc) {
		this.fwc = fwc;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

}
