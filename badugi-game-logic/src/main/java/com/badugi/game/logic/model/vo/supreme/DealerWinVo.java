package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

public class DealerWinVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String item;//赢取筹码门类
	private Long kindbetChips;//该门押注筹码量
	private Long kindwinChips;//该门输赢筹码量
	public DealerWinVo(){}
	public DealerWinVo(String item,Long kindbetChips,Long kindwinChips){
		 this.item = item;
		 this.kindbetChips = kindbetChips;
		 this.kindwinChips = kindwinChips;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Long getKindbetChips() {
		return kindbetChips;
	}
	public void setKindbetChips(Long kindbetChips) {
		this.kindbetChips = kindbetChips;
	}
	public Long getKindwinChips() {
		return kindwinChips;
	}
	public void setKindwinChips(Long kindwinChips) {
		this.kindwinChips = kindwinChips;
	}
	 
	
}
