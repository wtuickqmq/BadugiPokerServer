package com.badugi.game.logic.model.vo.record;


/**
 * 初始数据_总数据
 * @author hcy
 *
 */
public class InitTotalVo {
	private InitPlayerVo[] pos;
	private String d;
	private String bb;
	private String sb;
	private Double s;
	private Double b;
	
	public InitPlayerVo[] getPos() {
		return pos;
	}
	public void setPos(InitPlayerVo[] pos) {
		this.pos = pos;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getBb() {
		return bb;
	}
	public void setBb(String bb) {
		this.bb = bb;
	}
	public String getSb() {
		return sb;
	}
	public void setSb(String sb) {
		this.sb = sb;
	}
	public Double getS() {
		return s;
	}
	public void setS(Double s) {
		this.s = s;
	}
	public Double getB() {
		return b;
	}
	public void setB(Double b) {
		this.b = b;
	}
	
	
}
