package com.badugi.game.logic.model.vo.api;

import java.util.List;


public class JewelBoxListVo extends ResultVo {
	private Long code;
	private String desc;
	private Long fbid;
	private List<JewelBoxVo> list;
	private int currpage;//当前页
	private int count;//总个数
	
	
	public JewelBoxListVo(Long code, String desc, Long fbid,
			List<JewelBoxVo> list, int currpage, int count) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.list = list;
		this.currpage = currpage;
		this.count = count;
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
	public Long getFbid() {
		return fbid;
	}
	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	public List<JewelBoxVo> getList() {
		return list;
	}
	public void setList(List<JewelBoxVo> list) {
		this.list = list;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
