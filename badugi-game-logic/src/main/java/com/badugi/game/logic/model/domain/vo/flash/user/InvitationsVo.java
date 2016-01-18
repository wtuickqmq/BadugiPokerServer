package com.badugi.game.logic.model.domain.vo.flash.user;

import java.util.List;

public class InvitationsVo {

	private Long code;
	private String desc;
	private List<Invitations> users;
	
	public InvitationsVo() {
		super();
	}

	public InvitationsVo(Long code, String desc, List<Invitations> users) {
		super();
		this.code = code;
		this.desc = desc;
		this.users = users;
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

	public List<Invitations> getUsers() {
		return users;
	}

	public void setUsers(List<Invitations> users) {
		this.users = users;
	}

	
	
}
