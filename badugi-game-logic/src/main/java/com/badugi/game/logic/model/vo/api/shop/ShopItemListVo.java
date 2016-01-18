package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class ShopItemListVo extends ResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long code;
	private String desc;
	private Integer mg;
	private List<ShopItemVo> list;
	
	
	public ShopItemListVo() {
		super();
	}


	public ShopItemListVo(Long code, String desc, Integer mg,
			List<ShopItemVo> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.mg = mg;
		this.list = list;
	}


	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public Integer getMg() {
		return mg;
	}


	public void setMg(Integer mg) {
		this.mg = mg;
	}


	public List<ShopItemVo> getList() {
		return list;
	}


	public void setList(List<ShopItemVo> list) {
		this.list = list;
	}
	
	
	
}
