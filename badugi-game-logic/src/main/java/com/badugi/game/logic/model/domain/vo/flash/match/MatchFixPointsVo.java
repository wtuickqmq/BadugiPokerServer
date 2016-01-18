package com.badugi.game.logic.model.domain.vo.flash.match;

import java.io.Serializable;

/**
 * 积分配置方案
 * 
 * @author amin
 */
public class MatchFixPointsVo implements java.io.Serializable {

	private int ft;// 类型1:固定积分0:普通
	private double v;// 方案值

	public int getFt() {
		return ft;
	}

	public void setFt(int ft) {
		this.ft = ft;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

}
