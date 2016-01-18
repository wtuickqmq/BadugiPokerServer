
package com.badugi.game.logic.model.vo.api.user;

import com.badugi.game.logic.model.vo.api.ResultVo;


/**
 * api我的筹码
 * 
 * @author amin
 */
public class MyChipsResultVo extends ResultVo {

	private Long code;
	private String desc;
	private Double chips;

	public MyChipsResultVo() {
		super();
	}

	public MyChipsResultVo(Long code, String desc, Double chips) {
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

	public Double getChips() {
		return chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

}
