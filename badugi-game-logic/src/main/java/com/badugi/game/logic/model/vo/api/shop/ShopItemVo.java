package com.badugi.game.logic.model.vo.api.shop;

import com.badugi.game.logic.model.vo.api.ResultVo;


public class ShopItemVo extends ResultVo {

	private Integer gid;//:商品编号
	private String gn;//商品名称
	private String gimg;//商品图片
	private Integer gag;//兑换该商品所需的金块
	private Integer type;//类型

	public ShopItemVo() {
		super();
	}

	public ShopItemVo(Integer gid, String gn, String gimg, Integer gag,Integer type) {
		super();
		this.gid = gid;
		this.gn = gn;
		this.gimg = gimg;
		this.gag = gag;
		this.type=type;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGn() {
		return gn;
	}

	public void setGn(String gn) {
		this.gn = gn;
	}

	public String getGimg() {
		return gimg;
	}

	public void setGimg(String gimg) {
		this.gimg = gimg;
	}

	public Integer getGag() {
		return gag;
	}

	public void setGag(Integer gag) {
		this.gag = gag;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	
}
