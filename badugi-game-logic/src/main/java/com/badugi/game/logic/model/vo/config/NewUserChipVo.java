package com.badugi.game.logic.model.vo.config;

/**
 * 
* 项目名称：qq1.0   
* 类名称：NewUserChipVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Mar 13, 2013 4:48:57 PM    
* @version 1.0
 */
public class NewUserChipVo {

	private int minchips;// 新用户最小获得筹码数
	private int maxchips;// 新用户最大获得筹码数
	private int guidechips;// 新手指引获得筹码数
	

	public NewUserChipVo() {
		super();
	}


	public NewUserChipVo(int minchips, int maxchips) {
		super();
		this.minchips = minchips;
		this.maxchips = maxchips;
	}


	public int getMinchips() {
		return minchips;
	}


	public void setMinchips(int minchips) {
		this.minchips = minchips;
	}


	public int getMaxchips() {
		return maxchips;
	}


	public void setMaxchips(int maxchips) {
		this.maxchips = maxchips;
	}
	
	public int getGuidechips() {
		return guidechips;
	}
	
	public void setGuidechips(int guidechips) {
		this.guidechips = guidechips;
	}


}
