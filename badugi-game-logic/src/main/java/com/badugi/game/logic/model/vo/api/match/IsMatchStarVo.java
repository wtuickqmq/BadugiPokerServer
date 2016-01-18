package com.badugi.game.logic.model.vo.api.match;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api筹码排行返回值
 * 
 * @author amin
 */
public class IsMatchStarVo extends ResultVo {

	private Long code;
	private String desc;
	private int isstar;// 是否为明星

	public IsMatchStarVo() {
		super();
	}

	public IsMatchStarVo(Long code, String desc, int isstar) {
		super();
		this.code = code;
		this.desc = desc;
		this.isstar = isstar;
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

	public int getIsstar() {
		return isstar;
	}

	public void setIsstar(int isstar) {
		this.isstar = isstar;
	}

}
