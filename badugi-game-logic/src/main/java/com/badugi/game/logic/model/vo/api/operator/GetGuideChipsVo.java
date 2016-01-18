package com.badugi.game.logic.model.vo.api.operator;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 新手指引完成获得筹码返回值
 * 
 * @author amin
 */
public class GetGuideChipsVo extends ResultVo {

	private Long code;
	private String desc;
	private int chips;

	public GetGuideChipsVo() {
		super();
	}

	public GetGuideChipsVo(Long code, String desc, int chips) {
		super();
		this.code = code;
		this.desc = desc;
		this.chips = chips;
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

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

}
