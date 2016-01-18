package com.badugi.game.logic.model.vo.api.table;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class IsswinshareVo extends ResultVo {

	private Long code;
	private String desc;
	private boolean isshow;
	private boolean isshare;

	public IsswinshareVo() {
		super();
	}

	public IsswinshareVo(Long code, String desc, boolean isshow, boolean isshare) {
		super();
		this.code = code;
		this.desc = desc;
		this.isshow = isshow;
		this.isshare = isshare;
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

	public boolean getIsshow() {
		return isshow;
	}

	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}

	public boolean getIsshare() {
		return isshare;
	}

	public void setIsshare(boolean isshare) {
		this.isshare = isshare;
	}

}
