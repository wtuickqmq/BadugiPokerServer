package com.badugi.game.logic.model.vo.api.joker;

public class JokerUserInfoVo {
	private Integer id;
	private Integer username;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUsername() {
		return username;
	}
	public void setUsername(Integer username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "JokerUserInfoVo [id=" + id + ", username=" + username + "]";
	}
}
