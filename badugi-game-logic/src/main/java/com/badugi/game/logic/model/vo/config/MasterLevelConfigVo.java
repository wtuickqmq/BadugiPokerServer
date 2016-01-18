package com.badugi.game.logic.model.vo.config;
/**
 * @copyright：Copyright 2011  highesthelp.com All Rights Reserved
 * @author: weijie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: 2012-10-23
 * @description：
 */
public class MasterLevelConfigVo {
	
	private int level;
	private String name;
	private int value;
	private int totalvalue;
	private int istip;
	private String comment;
	
	public MasterLevelConfigVo() {
		super();
	}


	public MasterLevelConfigVo(int level, int value) {
		super();
		this.level = level;
		this.value = value;
	}
	
	public MasterLevelConfigVo(int level, int value, int totalvalue) {
		super();
		this.level = level;
		this.value = value;
		this.totalvalue = totalvalue;
	}
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getTotalvalue() {
		return totalvalue;
	}
	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}
	public int getIstip() {
		return istip;
	}
	public void setIstip(int istip) {
		this.istip = istip;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
