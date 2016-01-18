package com.badugi.game.logic.model.domain.vo.api.match;

import java.util.Map;

/**
 * 用户奖励
 * 
 * @author amin
 */
public class MoneyCircleReward {

	private Map<Integer, Integer> tickets;
	private Map<Integer, Integer> goods;
	private int m;// 大师分
	private int g;// 金块
	private double am;// 奖金

	public Map<Integer, Integer> getTickets() {
		return tickets;
	}

	public void setTickets(Map<Integer, Integer> tickets) {
		this.tickets = tickets;
	}

	public Map<Integer, Integer> getGoods() {
		return goods;
	}

	public void setGoods(Map<Integer, Integer> goods) {
		this.goods = goods;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

}
