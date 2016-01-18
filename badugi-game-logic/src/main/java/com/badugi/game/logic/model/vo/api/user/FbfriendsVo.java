package com.badugi.game.logic.model.vo.api.user;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api获取facebook好友返回值
 * @author amin
 */
public class FbfriendsVo extends ResultVo {

	private Long code;
	private String desc;
	private List<Fbfriends> users;
	private int currpage;//当前页
	private int count;//总个数
	private int onlinecount;//在线个数

	public FbfriendsVo() {
		super();
	}

	public FbfriendsVo(Long code, String desc, List<Fbfriends> users,
			int currpage, int count, int onlinecount) {
		super();
		this.code = code;
		this.desc = desc;
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

	public List<Fbfriends> getUsers() {
		return users;
	}

	public void setUsers(List<Fbfriends> users) {
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
