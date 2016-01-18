package com.badugi.game.logic.model.vo.api.operator;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class DayPrizesReturnVo extends ResultVo {

	/**
	 * 返回码
	 */
	private Long code;
	private String desc;
	private List<DayPrizesDetail> list;
	private int nd;
	private double am;

	public DayPrizesReturnVo() {
		super();
	}

	public DayPrizesReturnVo(Long code, String desc,
			List<DayPrizesDetail> list, int nd, double am) {
		super();
		this.code = code;
		this.desc = desc;
		this.list = list;
		this.nd = nd;
		this.am = am;
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

	public List<DayPrizesDetail> getList() {
		return list;
	}

	public void setList(List<DayPrizesDetail> list) {
		this.list = list;
	}

	public int getNd() {
		return nd;
	}

	public void setNd(int nd) {
		this.nd = nd;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

}
