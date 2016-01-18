package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 用户新任务任务获得奖品返回值
 * 
 * @author amin
 */
public class GetNewTaskPrizeVo extends ResultVo {

	private Long code;
	private String desc;
	private double chips;
	private double phonecard;

	public GetNewTaskPrizeVo() {
		super();
	}

	public GetNewTaskPrizeVo(Long code, String desc, double chips,
			double phonecard) {
		super();
		this.code = code;
		this.desc = desc;
		this.chips = chips;
		this.phonecard = phonecard;
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

	public double getChips() {
		return chips;
	}

	public void setChips(double chips) {
		this.chips = chips;
	}

	public double getPhonecard() {
		return phonecard;
	}

	public void setPhonecard(double phonecard) {
		this.phonecard = phonecard;
	}

}
