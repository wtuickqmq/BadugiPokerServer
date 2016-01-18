package com.badugi.game.logic.model.vo.api.shop;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class DecorateShopListVo extends ResultVo {

	private Long code;
	private String desc;
	private Integer mg;
	private List<DecorateShopVo> list;

	public DecorateShopListVo() {
		super();
	}

	public DecorateShopListVo(Long code, String desc, Integer mg,
			List<DecorateShopVo> list) {
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

	public List<DecorateShopVo> getList() {
		return list;
	}

	public void setList(List<DecorateShopVo> list) {
		this.list = list;
	}

}
