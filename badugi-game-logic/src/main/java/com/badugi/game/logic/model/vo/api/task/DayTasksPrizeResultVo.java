package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.api.ResultVo;
import com.badugi.game.logic.model.vo.config.TaskRewardVo;

/**
 * 获得每日任务奖品返回值
 * 
 * @author amin
 */
public class DayTasksPrizeResultVo extends ResultVo {

	private Long code;
	private String desc;
	private TaskRewardVo prize;
	private Integer mid;
	private String mst;
	private String tn;

	public DayTasksPrizeResultVo() {
		super();
	}

	public DayTasksPrizeResultVo(Long code, String desc, TaskRewardVo prize,
			Integer mid, String mst, String tn) {
		super();
		this.code = code;
		this.desc = desc;
		this.prize = prize;
		this.mid = mid;
		this.mst = mst;
		this.tn = tn;
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

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMst() {
		return mst;
	}

	public void setMst(String mst) {
		this.mst = mst;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

}
