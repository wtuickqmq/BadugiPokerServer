package com.badugi.game.logic.model.vo.api.user;

public class FriendsInfos {

	private Long fbid;// facebook编号
	private String name;// 名称
	private int explevel;// 普通等级
	private int viplevel;// vip等级
	private int chips;// 筹码数量
	private int newstype;// 动态类型
	private String content;// 动态内容
	private String createtime;// 创建时间
	private int discon;//是否失联（1：是，0：否）

	public FriendsInfos() {
		super();
	}

	public FriendsInfos(Long fbid, String name, int explevel,
			int viplevel, int chips, int newstype, String content,
			String createtime) {
		super();
		this.fbid = fbid;
		this.name = name;
		this.explevel = explevel;
		this.viplevel = viplevel;
		this.chips = chips;
		this.newstype = newstype;
		this.content = content;
		this.createtime = createtime;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExplevel() {
		return explevel;
	}

	public void setExplevel(int explevel) {
		this.explevel = explevel;
	}

	public int getViplevel() {
		return viplevel;
	}

	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	public int getNewstype() {
		return newstype;
	}

	public void setNewstype(int newstype) {
		this.newstype = newstype;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getDiscon() {
		return discon;
	}

	public void setDiscon(int discon) {
		this.discon = discon;
	}
	
}
