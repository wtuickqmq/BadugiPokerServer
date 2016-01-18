package com.badugi.game.logic.model.vo.api.user;

/**
 * 我的装饰详情
 * 
 * @author amin
 */
public class DecorateDetailVo {

	private int did;// 编号
	private String dn;// 名称
	private String dmn;// 图片名称
	private int dc;// 数量
	private String dst;// 开始时间
	private String det;// 结束时间
	private int ie;// 是否装饰

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getDmn() {
		return dmn;
	}

	public void setDmn(String dmn) {
		this.dmn = dmn;
	}

	public int getDc() {
		return dc;
	}

	public void setDc(int dc) {
		this.dc = dc;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public String getDet() {
		return det;
	}

	public void setDet(String det) {
		this.det = det;
	}

	public int getIe() {
		return ie;
	}

	public void setIe(int ie) {
		this.ie = ie;
	}

}
