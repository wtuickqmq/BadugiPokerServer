package com.badugi.game.logic.model.vo.api.user;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api获取好友动态返回值
 * @author amin
 */
public class FriendsInfosVo extends ResultVo {

	private Long code;
	private String desc;
	private List<FriendsInfos> users;
	private int currpage;//当前页数
	private int count;//总页数

	public FriendsInfosVo() {
		super();
	}

	public FriendsInfosVo(Long code, String desc, List<FriendsInfos> users,
			int currpage, int count) {
		super();
		this.code = code;
		this.desc = desc;
		this.users = users;
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

	public List<FriendsInfos> getUsers() {
		return users;
	}

	public void setUsers(List<FriendsInfos> users) {
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
	
}
