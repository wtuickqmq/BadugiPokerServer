package com.badugi.game.logic.model.vo.api.user;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
*追踪
*/
public class TrackVo extends ResultVo {

	private Long code;
	private String description;
	private List<TrackRooms> list;

	public TrackVo() {
		super();
	}

	public TrackVo(Long code, String description, List<TrackRooms> list) {
		super();
		this.code = code;
		this.description = description;
		this.list = list;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TrackRooms> getList() {
		return list;
	}

	public void setList(List<TrackRooms> list) {
		this.list = list;
	}

}
