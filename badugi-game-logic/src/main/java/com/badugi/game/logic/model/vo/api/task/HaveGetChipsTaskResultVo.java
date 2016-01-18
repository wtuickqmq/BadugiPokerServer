package com.badugi.game.logic.model.vo.api.task;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 获取任务奖励返回Vo
 * 
 * @author amin
 */
public class HaveGetChipsTaskResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int ic;

	public HaveGetChipsTaskResultVo() {
		super();
	}

	public HaveGetChipsTaskResultVo(Long code, String desc, int ic) {
		super();
		this.code = code;
		this.desc = desc;
		this.ic = ic;
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

	public int getIc() {
		return ic;
	}

	public void setIc(int ic) {
		this.ic = ic;
	}

}
