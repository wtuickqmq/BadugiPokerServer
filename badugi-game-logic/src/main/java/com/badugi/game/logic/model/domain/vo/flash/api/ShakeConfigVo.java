package com.badugi.game.logic.model.domain.vo.flash.api;

import java.util.List;

import com.badugi.game.logic.model.domain.vo.flash.ResultVo;

public class ShakeConfigVo extends ResultVo {
	
	private Integer maxb;//大盲
	private Integer minb;//小盲
   
    public ShakeConfigVo() {
		super();
	}
	public ShakeConfigVo(Integer maxb, Integer minb) {
		super();
		this.maxb = maxb;
		this.minb = minb;
			}
	
	
	public Integer getMaxb() {
		return maxb;
	}
	public void setMaxb(Integer maxb) {
		this.maxb = maxb;
	}
	public Integer getMinb() {
		return minb;
	}
	public void setMinb(Integer minb) {
		this.minb = minb;
	}
	
	
	
	
	
    
}
