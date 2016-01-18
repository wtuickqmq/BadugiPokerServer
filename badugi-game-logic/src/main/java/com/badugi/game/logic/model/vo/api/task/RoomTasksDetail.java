package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.api.ResultVo;
import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 场任务完成详细
 * 
 * @author amin
 */
public class RoomTasksDetail extends ResultVo {

	private int tid;
	private int isf;
	private int isg;
	private int c;
	private int fc;
	private int wc;
	private int fwc;
	private TaskRewardVo prize;

	public RoomTasksDetail() {
		super();
	}

	public RoomTasksDetail(int tid, int isf, int isg, int c, int fc, int wc,
			int fwc, TaskRewardVo prize) {
		super();
		this.tid = tid;
		this.isf = isf;
		this.isg = isg;
		this.c = c;
		this.fc = fc;
		this.wc = wc;
		this.fwc = fwc;
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
