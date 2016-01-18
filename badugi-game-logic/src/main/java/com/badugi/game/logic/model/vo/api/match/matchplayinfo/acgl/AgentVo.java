package com.badugi.game.logic.model.vo.api.match.matchplayinfo.acgl;

public class AgentVo {

	private Long fbid;//:代理商ID long
	private String un;//:代理商名称 string
	private String ph;//:电话 string
	private Long cp;//:筹码(int)
	private Integer ol;//:在线状态(1在线0反之)(int)
	public Long getFbid() {
		return fbid;
	}
	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public Long getCp() {
		return cp;
	}
	public void setCp(Long cp) {
		this.cp = cp;
	}
	public Integer getOl() {
		return ol;
	}
	public void setOl(Integer ol) {
		this.ol = ol;
	}
	
	

}
