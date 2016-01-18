package com.badugi.game.logic.model.vo.api.operator;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 签到结果返回值
 * 
 * @author amin
 */
public class IsSignResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int issign;// 是否签到(1:是0:否)

	public IsSignResultVo() {
		super();
	}

	public IsSignResultVo(Long code, String desc, int issign) {
		super();
		this.code = code;
		this.desc = desc;
		this.issign = issign;
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

	public int getIssign() {
		return issign;
	}

	public void setIssign(int issign) {
		this.issign = issign;
	}

}
