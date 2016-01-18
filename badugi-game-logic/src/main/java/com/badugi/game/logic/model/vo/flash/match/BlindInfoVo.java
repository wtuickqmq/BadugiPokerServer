package com.badugi.game.logic.model.vo.flash.match;

/****
 * 盲注等级通知VO
 * @author weijie
 *
 */
public class BlindInfoVo {
	private Integer tid;
	private Double bb;
	private Double sb;
	private Double at;
	
	
	
	
	
	public BlindInfoVo(Integer tid,Double bb, Double sb, Double at) {
		super();
		this.tid = tid;
		this.bb = bb;
		this.sb = sb;
		this.at = at;
	}
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Double getBb() {
		return bb;
	}
	public void setBb(Double bb) {
		this.bb = bb;
	}
	public Double getSb() {
		return sb;
	}
	public void setSb(Double sb) {
		this.sb = sb;
	}

	public Double getAt() {
		return at;
	}
	public void setAt(Double at) {
		this.at = at;
	}
	
	
	
}
