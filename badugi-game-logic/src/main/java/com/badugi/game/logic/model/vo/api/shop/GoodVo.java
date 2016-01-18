package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;

public class GoodVo implements Serializable{

	/**
	 * 
	   id:物品编号
	   gid:物品类型
       gn: 物品名称
       gam: 物品价值
       gmn:物品图片(相对目录：flash上级目录下的/goods)
       gc:此类物品数量
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer gid;
	private String gn;
	private String gmn;
	private Integer gc;
	private Integer gam;
	private Integer gp;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getGmn() {
		return gmn;
	}
	public void setGmn(String gmn) {
		this.gmn = gmn;
	}
	public Integer getGc() {
		return gc;
	}
	public void setGc(Integer gc) {
		this.gc = gc;
	}
	public Integer getGam() {
		return gam;
	}
	public void setGam(Integer gam) {
		this.gam = gam;
	}
	public Integer getGp() {
		return gp;
	}
	public void setGp(Integer gp) {
		this.gp = gp;
	}
	public GoodVo(Integer gid, String gn, String gmn, Integer gc, Integer gam,Integer gp) {
		super();
		this.gid = gid;
		this.gn = gn;
		this.gmn = gmn;
		this.gc = gc;
		this.gam = gam;
		this.gp=gp;
	}
	public GoodVo() {
		super();
	}
	
}
