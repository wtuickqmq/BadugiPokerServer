package com.badugi.game.logic.model.domain.vo.api.match;

import java.io.Serializable;

public class TicketVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tid;
	private String tn;
	private String tmn;
	private Integer tc;
	private String tst;
	private String tet;
	private Integer tam;
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

	
}
