package com.badugi.game.logic.model.vo.record;

public class RoomVo {
	
	private Integer roomId;
	private Integer userCount;
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getUserCount() {
		return userCount;
	}
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	public RoomVo(Integer roomId, Integer userCount) {
		super();
		this.roomId = roomId;
		this.userCount = userCount;
	}
	public RoomVo(Object roomId, Object userCount) {
		super();
	}
	public RoomVo() {
		super();
	}
	

}
