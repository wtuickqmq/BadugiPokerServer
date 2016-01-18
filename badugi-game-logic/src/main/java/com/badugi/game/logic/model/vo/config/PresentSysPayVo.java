package com.badugi.game.logic.model.vo.config;

/**
 * 系统补偿
 * 
 * @author amin
 */
public class PresentSysPayVo {

	/* {'date':'2013-11-25','afdays':7,'objectid':'20131125','am':30000} */
	private String date;// 什么日前前的补偿
	private int afdays;// 几天之后停止该活动
	private long objectid;// 对应编号
	private int am;// 补偿的金额

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAfdays() {
		return afdays;
	}

	public void setAfdays(int afdays) {
		this.afdays = afdays;
	}

	public long getObjectid() {
		return objectid;
	}

	public void setObjectid(long objectid) {
		this.objectid = objectid;
	}

	public int getAm() {
		return am;
	}

	public void setAm(int am) {
		this.am = am;
	}

}
