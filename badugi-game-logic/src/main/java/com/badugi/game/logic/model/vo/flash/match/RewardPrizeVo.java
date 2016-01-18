package com.badugi.game.logic.model.vo.flash.match;

import java.util.ArrayList;
import java.util.List;

/**
 * 奖品
 * 
 * @author amin
 */
public class RewardPrizeVo {

	private double am;
	private int g;
	private int m;
	private List<TicketDetail> tlist = new ArrayList<TicketDetail>();
	private List<GoodsDetail> glist = new ArrayList<GoodsDetail>();

	public RewardPrizeVo() {
		super();
	}
	
	public RewardPrizeVo(double am){
		super();
		this.am = am;
	}

	public RewardPrizeVo(double am, int g, int m, List<TicketDetail> tlist,
			List<GoodsDetail> glist) {
		super();
		this.am = am;
		this.g = g;
		this.m = m;
		this.tlist = tlist;
		this.glist = glist;
	}
	
	public RewardPrizeVo(double am, int g, int m) {
		super();
		this.am = am;
		this.g = g;
		this.m = m;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public List<TicketDetail> getTlist() {
		return tlist;
	}

	public void setTlist(List<TicketDetail> tlist) {
		this.tlist = tlist;
	}

	public List<GoodsDetail> getGlist() {
		return glist;
	}

	public void setGlist(List<GoodsDetail> glist) {
		this.glist = glist;
	}

}
