package com.badugi.game.logic.model.vo.api.table;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class MysboxResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int boxid;// 宝箱编号
	private int ac;// 需要完成的局数
	private int fc;// 已经完成的局数

	public MysboxResultVo() {
		super();
	}

	public MysboxResultVo(Long code, String desc, int boxid, int ac, int fc) {
		super();
		this.code = code;
		this.desc = desc;
		this.boxid = boxid;
		this.ac = ac;
		this.fc = fc;
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

	public int getBoxid() {
		return boxid;
	}

	public void setBoxid(int boxid) {
		this.boxid = boxid;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getFc() {
		return fc;
	}

	public void setFc(int fc) {
		this.fc = fc;
	}

}
