package com.badugi.game.logic.model.vo.record;

import java.io.Serializable;

public class GameStatisticsVo implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = -7617773677039783686L;
	public Double winloss;
	public String begin;
	public String end;
	public String name;
	public Integer plays;

	public GameStatisticsVo() {
		super();
	}
	
	public GameStatisticsVo(Double winloss) {
		super();
		this.winloss = winloss;
	}

	public Double getWinloss() {
		return winloss;
	}

	public void setWinloss(Double winloss) {
		this.winloss = winloss;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPlays() {
		return plays;
	}

	public void setPlays(Integer plays) {
		this.plays = plays;
	}


}
