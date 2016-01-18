package com.badugi.game.logic.model.vo.record;

/**
 * 游戏动作
 * @author hcy
 *
 */
public class ActionVo {
	private Double oldchips;
	private Double newchips;
	private Integer state;
	private Double obet;
	
	public Double getOldchips() {
		return oldchips;
	}
	public void setOldchips(Double oldchips) {
		this.oldchips = oldchips;
	}
	public Double getNewchips() {
		return newchips;
	}
	public void setNewchips(Double newchips) {
		this.newchips = newchips;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Double getObet() {
		return obet;
	}
	public void setObet(Double obet) {
		this.obet = obet;
	}
	
}
