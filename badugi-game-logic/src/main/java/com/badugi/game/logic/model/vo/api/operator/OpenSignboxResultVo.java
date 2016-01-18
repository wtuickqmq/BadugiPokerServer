package com.badugi.game.logic.model.vo.api.operator;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 打开签到宝箱结果返回值
 * 
 * @author amin
 */
public class OpenSignboxResultVo extends ResultVo {

	private Long code;
	private String desc;
	private String prize;// 奖品名称

	public OpenSignboxResultVo() {
		super();
	}

	public OpenSignboxResultVo(Long code, String desc, String prize) {
		super();
		this.code = code;
		this.desc = desc;
		this.prize = prize;
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

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}
