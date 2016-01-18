package com.badugi.game.logic.model.vo.config;

import java.util.List;

/**
 * 猜大小任务的配置
 * 
 * @author amin
 */
public class GuessTicketVo {

	private int count;
	private List<GuessTicketDetail> tickets;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<GuessTicketDetail> getTickets() {
		return tickets;
	}

	public void setTickets(List<GuessTicketDetail> tickets) {
		this.tickets = tickets;
	}

}
