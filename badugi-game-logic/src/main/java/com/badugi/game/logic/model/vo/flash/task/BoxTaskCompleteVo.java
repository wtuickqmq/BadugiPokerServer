package com.badugi.game.logic.model.vo.flash.task;

import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 神秘宝箱任务完成flash信息vo
 * 
 * @author amin
 */
public class BoxTaskCompleteVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * 神秘宝箱编号(1彩蛋)
	 */
	private int id;
	/**
	 * 奖品
	 */
	private TaskRewardVo prize;

	public BoxTaskCompleteVo() {
		super();
	}

	public BoxTaskCompleteVo(Long code, String cmd, int id, TaskRewardVo prize) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

}
