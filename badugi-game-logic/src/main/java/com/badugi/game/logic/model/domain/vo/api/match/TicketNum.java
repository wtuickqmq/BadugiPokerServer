package com.badugi.game.logic.model.domain.vo.api.match;

import java.io.Serializable;

public class TicketNum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tp ;
	private Integer tc;
	public Integer getTp() {
		return tp;
	}
	public void setTp(Integer tp) {
		this.tp = tp;
	}
	public Integer getTc() {
		return tc;
	}
	public void setTc(Integer tc) {
		this.tc = tc;
	}
	
	

}
