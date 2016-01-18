package com.badugi.game.logic.model.vo.flash.operators;

public class DuJiangVo {

	private Integer id;
	private String fbName;
	private String ticketName;
	private String matchNameDisp;
	private Integer rank;
	private String createTime;
	private String imageName;
	public DuJiangVo(Integer id, String fbName, String ticketName,
			String matchNameDisp, Integer rank, String createTime) {
		super();
		this.id = id;
		this.fbName = fbName;
		this.ticketName = ticketName;
		this.matchNameDisp = matchNameDisp;
		this.rank = rank;
		this.createTime = createTime;
	}
	public DuJiangVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFbName() {
		return fbName;
	}
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getMatchNameDisp() {
		return matchNameDisp;
	}
	public void setMatchNameDisp(String matchNameDisp) {
		this.matchNameDisp = matchNameDisp;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
}
