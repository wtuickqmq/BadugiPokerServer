package com.badugi.game.logic.model.vo.flash.task;

import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 任务完成通知flash信息vo
 * 
 * @author amin
 */
public class TaskCompleteVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * 阶段任务
	 */
	private int type;
	/**
	 * 任务名称
	 */
	private int tid;
	/**
	 * 是否显示
	 */
	private int ish = 0;
	/**
	 * 奖品
	 */
	private TaskRewardVo prize;

	public TaskCompleteVo() {
		super();
	}

	public TaskCompleteVo(Long code, String cmd, int type, int tid, TaskRewardVo prize) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.type = type;
		this.tid = tid;
		this.prize = prize;
	}
	
	public TaskCompleteVo(Long code, String cmd, int tid, TaskRewardVo prize) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.tid = tid;
		this.prize = prize;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public int getIsh() {
		return ish;
	}
	
	public void setIsh(int ish) {
		this.ish = ish;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

}
