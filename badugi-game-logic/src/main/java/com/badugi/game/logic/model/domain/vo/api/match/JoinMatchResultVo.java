package com.badugi.game.logic.model.domain.vo.api.match;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api登记比赛返回值
 * 
 * @author amin
 */
public class JoinMatchResultVo extends ResultVo {

	private Long code;
	private String desc;
	private String mst;

	public JoinMatchResultVo() {
		super();
	}

	public JoinMatchResultVo(Long code, String desc, String mst) {
		super();
		this.code = code;
		this.desc = desc;
		this.mst = mst;
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

	public String getMst() {
		return mst;
	}

	public void setMst(String mst) {
		this.mst = mst;
	}

}
