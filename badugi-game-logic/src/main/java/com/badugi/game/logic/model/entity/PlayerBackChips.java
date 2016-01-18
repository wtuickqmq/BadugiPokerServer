package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class PlayerBackChips extends BaseEntity implements java.io.Serializable {

	private Long rcount;
	private Long sumtime;
	private double changechips;
	private Long points;
	private Long defchips;

	public PlayerBackChips() {
		super();

	}

	public PlayerBackChips(Long rcount, Long sumtime, double changechips, Long points, Long defchips) {
		super();
		this.rcount = rcount;
		this.sumtime = sumtime;
		this.changechips = changechips;
		this.points = points;
		this.defchips = defchips;
	}
	
	public Long getRcount() {
		return rcount;
	}

	public void setRcount(Long rcount) {
		this.rcount = rcount;
	}


	public Long getSumtime() {
		return sumtime;
	}

	public void setSumtime(Long sumtime) {
		this.sumtime = sumtime;
	}

	
	
	public double getChangechips() {
		return changechips;
	}

	public void setChangechips(double changechips) {
		this.changechips = changechips;
	}

	
	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	
	
	public Long getDefchips() {
		return defchips;
	}

	public void setDefchips(Long defchips) {
		this.defchips = defchips;
	}

}
