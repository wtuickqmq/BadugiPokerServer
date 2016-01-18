package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.api.ResultVo;
import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 免费筹码任务完成详细
 * 
 * @author amin
 */
public class FreeChipsTasksDetail extends ResultVo {

	private int tid;
	private int isf;
	private int isg;
	private TaskRewardVo prize;

	public FreeChipsTasksDetail() {
		super();
	}

	public FreeChipsTasksDetail(int tid, int isf, int isg, TaskRewardVo prize) {
		super();
		this.tid = tid;
		this.isf = isf;
		this.isg = isg;
		this.prize = prize;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getIsf() {
		return isf;
	}

	public void setIsf(int isf) {
		this.isf = isf;
	}

	public int getIsg() {
		return isg;
	}

	public void setIsg(int isg) {
		this.isg = isg;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

}
