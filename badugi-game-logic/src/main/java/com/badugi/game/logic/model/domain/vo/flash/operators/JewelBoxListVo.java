package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.List;

import com.badugi.game.logic.model.domain.vo.flash.api.JewelBoxVo;

public class JewelBoxListVo {
	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;
	
	private Integer roomid;
	
	private Long chips;
	
	private List<JewelBoxVo> list;

	
	
	public JewelBoxListVo() {
		super();
	}

	public JewelBoxListVo(String cmd, Long code, Integer roomid, Long chips,
			List<JewelBoxVo> list) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.roomid = roomid;
		this.chips = chips;
		this.list = list;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Long getChips() {
		return chips;
	}

	public void setChips(Long chips) {
		this.chips = chips;
	}

	public List<JewelBoxVo> getList() {
		return list;
	}

	public void setList(List<JewelBoxVo> list) {
		this.list = list;
	}

}
