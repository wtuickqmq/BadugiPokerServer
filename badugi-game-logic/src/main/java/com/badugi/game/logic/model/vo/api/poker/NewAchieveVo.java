package com.badugi.game.logic.model.vo.api.poker;

public class NewAchieveVo {
	private String name;
	private Integer id;
	private String img;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "NewAchieveVo [name=" + name + ", id=" + id + ", img=" + img
				+ "]";
	}
}
