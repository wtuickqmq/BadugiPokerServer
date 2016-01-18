package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.api.ResultVo;
import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 获取任务奖励返回Vo
 * 
 * @author amin
 */
public class GetTaskPrizeResultVo extends ResultVo {

	private Long code;
	private String desc;
	private TaskRewardVo prize;

	public GetTaskPrizeResultVo() {
		super();
	}

	public GetTaskPrizeResultVo(Long code, String desc, TaskRewardVo prize) {
		super();
		this.code = code;
		this.desc = desc;
		this.prize = prize;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public TaskRewardVo getPrize() {
		return prize;
	}

	public void setPrize(TaskRewardVo prize) {
		this.prize = prize;
	}

}
