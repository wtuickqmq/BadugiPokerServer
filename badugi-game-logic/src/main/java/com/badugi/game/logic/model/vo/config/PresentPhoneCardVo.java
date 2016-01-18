package com.badugi.game.logic.model.vo.config;

/**
 * 赠送泰铢充值卡
 * 
 * @author amin
 */
public class PresentPhoneCardVo {
	/*{"count":5000,"sum":5000,"value":20,"ticketid":1}*/
	private double count;// 赠送泰铢充值卡张数
	private double sum;// 赠送充值卡需要的游戏盈亏
	private double value;// 赠送泰铢充值卡的价值
	private int ticketid;// 赠送泰铢充值卡的门票ID

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

}
