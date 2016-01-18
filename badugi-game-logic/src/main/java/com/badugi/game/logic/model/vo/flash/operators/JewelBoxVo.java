package com.badugi.game.logic.model.vo.flash.operators;
/**
 * 
 * @author wtu
 * 聚宝盆总金额
 *
 */
public class JewelBoxVo {

	private Integer ticketid;
	
	private Integer ticketgid;
	
	private Long fbid;
	
	private String fbname;
	
	private String imgurl;

	private String wincards;
	
	private Short wintype;
	
	private Long winchips;
	
	
	public Integer getTicketid() {
		return ticketid;
	}

	public void setTicketid(Integer ticketid) {
		this.ticketid = ticketid;
	}

	public Integer getTicketgid() {
		return ticketgid;
	}

	public void setTicketgid(Integer ticketgid) {
		this.ticketgid = ticketgid;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getWincards() {
		return wincards;
	}

	public void setWincards(String wincards) {
		this.wincards = wincards;
	}

	public Short getWintype() {
		return wintype;
	}

	public void setWintype(Short wintype) {
		this.wintype = wintype;
	}

	public JewelBoxVo()
	{
		super();
	}
	
	

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public String getFbname() {
		return fbname;
	}

	public void setFbname(String fbname) {
		this.fbname = fbname;
	}


	public Long getWinchips() {
		return winchips;
	}

	public void setWinchips(Long winchips) {
		this.winchips = winchips;
	}

	

	

}
