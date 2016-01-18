package com.badugi.game.logic.model.vo.api.table;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 打开彩蛋返回值
 * 
 * @author amin
 */
public class OpenPeggResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int c;

	public OpenPeggResultVo() {
		super();
	}

	public OpenPeggResultVo(Long code, String desc, int c) {
		super();
		this.code = code;
		this.desc = desc;
		this.c = c;
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

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

}
