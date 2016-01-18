package com.badugi.game.logic.model.vo.api.task;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 每日任务完成情况
 * 
 * @author amin
 */
public class DayTasksDetail extends ResultVo {

	private int tid;
	private int c;
	private int fc;
	private int wc;
	private int fwc;
	private int p;
	private int pc;
	private List<PrizeRewardDetailVo> prize;
	private int isf;
	private int isg;

	public DayTasksDetail() {
		super();
	}

	public DayTasksDetail(int tid, int c, int fc,
			List<PrizeRewardDetailVo> prize, int isf, int isg) {
		super();
		this.tid = tid;
		this.c = c;
		this.fc = fc;
		this.prize = prize;
		this.isf = isf;
		this.isg = isg;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
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

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public List<PrizeRewardDetailVo> getPrize() {
		return prize;
	}

	public void setPrize(List<PrizeRewardDetailVo> prize) {
		this.prize = prize;
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

}
