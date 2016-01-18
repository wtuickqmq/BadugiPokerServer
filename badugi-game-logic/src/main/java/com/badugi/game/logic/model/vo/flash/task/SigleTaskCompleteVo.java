package com.badugi.game.logic.model.vo.flash.task;

import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 新手任务(单任务)完成通知flash信息vo
 * 
 * @author amin
 */
public class SigleTaskCompleteVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * 任务名称
	 */
	private int tid;
	/**
	 * 当前任务需要完成的局数
	 */
	private int c;
	/**
	 * 当前任务需要赢的局数
	 */
	private int wc;
	/**
	 * 奖品名称
	 */
	private TaskRewardVo prize;
	/**
	 * 下一个任务信息
	 */
	private NextSigleTaskVo nexttask;

	public SigleTaskCompleteVo() {
		super();
	}

	public SigleTaskCompleteVo(Long code, String cmd, int tid, int c, int wc,
			TaskRewardVo prize, NextSigleTaskVo nexttask) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.tid = tid;
		this.c = c;
		this.wc = wc;
		this.prize = prize;
		this.nexttask = nexttask;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
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

	public NextSigleTaskVo getNexttask() {
		return nexttask;
	}

	public void setNexttask(NextSigleTaskVo nexttask) {
		this.nexttask = nexttask;
	}

}
