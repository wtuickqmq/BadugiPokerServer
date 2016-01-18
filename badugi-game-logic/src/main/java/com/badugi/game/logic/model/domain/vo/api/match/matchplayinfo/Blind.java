package com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo;

public class Blind {

	private Integer bl;//盲注等级
	private Integer bb;//大盲
	private Integer sb;//小盲
	private Integer bt;//注意持续时间
	private Integer pot;//底注
	
	public Blind(Integer bl, Integer bb, Integer sb, Integer bt, Integer pot) {
		super();
		this.bl = bl;
		this.bb = bb;
		this.sb = sb;
		this.bt = bt;
		this.pot = pot;
	}
	
	public Integer getBl() {
		return bl;
	}
	public void setBl(Integer bl) {
		this.bl = bl;
	}
	public Integer getBb() {
		return bb;
	}
	public void setBb(Integer bb) {
		this.bb = bb;
	}
	public Integer getSb() {
		return sb;
	}
	public void setSb(Integer sb) {
		this.sb = sb;
	}
	public Integer getBt() {
		return bt;
	}
	public void setBt(Integer bt) {
		this.bt = bt;
	}
	public Integer getPot() {
		return pot;
	}
	public void setPot(Integer pot) {
		this.pot = pot;
	}
	
	
	
}
