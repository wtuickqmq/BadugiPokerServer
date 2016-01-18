package com.badugi.game.logic.model.vo.api.shop;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 饰品
 * @author amin
 */
public class DecorateShopVo extends ResultVo {

	private Integer gid;// :商品编号
	private String gn;// 商品名称
	private String gimg;// 商品图片
	private Integer gag;// 兑换该商品所需的金块
	private Integer flag;// 是否装饰

	public DecorateShopVo() {
		super();
	}

	public DecorateShopVo(Integer gid, String gn, String gimg, Integer gag,
			Integer flag) {
		super();
		this.gid = gid;
		this.gn = gn;
		this.gimg = gimg;
		this.gag = gag;
		this.flag = flag;
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

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
