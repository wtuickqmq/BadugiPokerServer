package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 牌桌奖励信息返回Vo
 * 
 * @author amin
 */
public class GameTasksBoxInfoResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int isfnt;
	private int fc;
	private int ac;

	public GameTasksBoxInfoResultVo() {
		super();
	}

	public GameTasksBoxInfoResultVo(Long code, String desc, int isfnt, int fc,
			int ac) {
		super();
		this.code = code;
		this.desc = desc;
		this.isfnt = isfnt;
		this.fc = fc;
		this.ac = ac;
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

	public int getIsfnt() {
		return isfnt;
	}

	public void setIsfnt(int isfnt) {
		this.isfnt = isfnt;
	}

	public int getFc() {
		return fc;
	}

	public void setFc(int fc) {
		this.fc = fc;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

}
