package com.badugi.game.logic.model.vo.api.task;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 今日金块摇奖信息
 * 
 * @author amin
 */
public class GoldChipsInfoResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int g;
	private int c;
	private int am;
	private int allam;
	private List<Integer> list;

	public GoldChipsInfoResultVo() {
		super();
	}

	public GoldChipsInfoResultVo(Long code, String desc, int g, int c, int allam, List<Integer> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.g = g;
		this.c = c;
		this.allam = allam;
		this.list = list;
	}

	public GoldChipsInfoResultVo(Long code, String desc, int g, int c, int am,
			int allam) {
		super();
		this.code = code;
		this.desc = desc;
		this.g = g;
		this.c = c;
		this.am = am;
		this.allam = allam;
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

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getAm() {
		return am;
	}

	public void setAm(int am) {
		this.am = am;
	}

	public int getAllam() {
		return allam;
	}

	public void setAllam(int allam) {
		this.allam = allam;
	}
	
	public List<Integer> getList() {
		return list;
	}
	
	public void setList(List<Integer> list) {
		this.list = list;
	}

}
