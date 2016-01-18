package com.badugi.game.logic.model.vo.api.user;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api获取鱼/敌人/黑名单返回值
 * @author amin
 */
public class RelationsVo extends ResultVo {

	private Long code;
	private String desc;
	private Integer type;// 调用类型
	private List<Relations> users;
	private int currpage;//当前页
	private int count;//总条数
	private int onlinecount;//在线个数

	public RelationsVo() {
		super();
	}

	public RelationsVo(Long code, String desc, Integer type,
			List<Relations> users, int currpage, int count, int onlinecount) {
		super();
		this.code = code;
		this.desc = desc;
		this.type = type;
		this.users = users;
		this.currpage = currpage;
		this.count = count;
		this.onlinecount = onlinecount;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Relations> getUsers() {
		return users;
	}

	public void setUsers(List<Relations> users) {
		this.users = users;
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

	public int getOnlinecount() {
		return onlinecount;
	}

	public void setOnlinecount(int onlinecount) {
		this.onlinecount = onlinecount;
	}
	
	
}
