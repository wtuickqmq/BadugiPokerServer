package com.badugi.game.logic.model.vo.flash.match;

/**
* 中场休息
* 项目名称：qq1.0   
* 类名称：MathcPause   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Jan 10, 2013 3:44:32 PM    
* @version 1.0
 */
public class MathcPauseVo {
	private Integer tid;
	private Boolean pause;
	private int bt;
	private int time;
	
	
	public MathcPauseVo(Integer tid, Boolean pause, int bt, int time) {
		super();
		this.tid = tid;
		this.pause = pause;
		this.bt = bt;
		this.time = time;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Boolean getPause() {
		return pause;
	}
	public void setPause(Boolean pause) {
		this.pause = pause;
	}
	public int getBt() {
		return bt;
	}
	public void setBt(int bt) {
		this.bt = bt;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
	
}
