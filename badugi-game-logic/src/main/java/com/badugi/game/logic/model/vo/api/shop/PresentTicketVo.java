package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;

public class PresentTicketVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tid;//门票/物品编号
	private String tn;//门票/物品名称
	private Integer myticketid;//我的门票ID
	private String tmn;//门票/物品图片（跟之前门票/物品路径一致）
	private Integer tc;//门票总张数
	private Integer tam;//门票价值
	private String tst;//有效开始时间
	private String tet;//有效结束时间
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}
	public String getTmn() {
		return tmn;
	}
	public void setTmn(String tmn) {
		this.tmn = tmn;
	}
	public Integer getTc() {
		return tc;
	}
	public void setTc(Integer tc) {
		this.tc = tc;
	}
	public String getTst() {
		return tst;
	}
	public void setTst(String tst) {
		this.tst = tst;
	}
	public String getTet() {
		return tet;
	}
	public void setTet(String tet) {
		this.tet = tet;
	}
	public Integer getTam() {
		return tam;
	}
	public void setTam(Integer tam) {
		this.tam = tam;
	}
	public Integer getMyticketid() {
		return myticketid;
	}
	public void setMyticketid(Integer myticketid) {
		this.myticketid = myticketid;
	}

	
}
