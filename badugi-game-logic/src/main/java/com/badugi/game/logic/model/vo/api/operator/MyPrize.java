package com.badugi.game.logic.model.vo.api.operator;

import java.io.Serializable;

public class MyPrize implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String date;
	private Integer type;
	private String mn;
	private Integer rank;
	private String prize;
	private Long fbid;
	private String fbname;
	
	
	public MyPrize(String date, Integer type, String mn, Integer rank,
			String prize) {
		super();
		this.date = date;
		this.type = type;
		this.mn = mn;
		this.rank = rank;
		this.prize = prize;
	}
	
	
	public MyPrize() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getMn() {
		return mn;
	}
	public void setMn(String mn) {
		this.mn = mn;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}


	public Long getFbid() {
		return fbid;
	}


	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}


	public String getFbname() {
		return fbname;
	}


	public void setFbname(String fbname) {
		this.fbname = fbname;
	}
	
	

}
