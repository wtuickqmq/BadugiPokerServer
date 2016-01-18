package com.badugi.game.logic.model.vo.config;

/**
 * 筹码赠送配置VO
 * 
 * @author amin
 */
public class PresentChipsConfigVo {

	private int count;// 赠送次数
	private double remain;// 对于多少赠送
	private double chips;// 赠送筹码
	private int value;// 赠送筹码的价值
	private int befordays;// 几天内才有破产补助
	private int dfbuy;// 自动补助后默认买入
	private double sb;// 自动补助后默认进入的小盲房间
	private double bb;// 自动补助后默认进入的大盲房间

	public PresentChipsConfigVo() {
		super();
	}

	public PresentChipsConfigVo(int count, double remain, double chips,
			int value) {
		super();
		this.count = count;
		this.remain = remain;
		this.chips = chips;
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getRemain() {
		return remain;
	}

	public void setRemain(double remain) {
		this.remain = remain;
	}

	public double getChips() {
		return chips;
	}

	public void setChips(double chips) {
		this.chips = chips;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getBefordays() {
		return befordays;
	}

	public void setBefordays(int befordays) {
		this.befordays = befordays;
	}

	public int getDfbuy() {
		return dfbuy;
	}

	public void setDfbuy(int dfbuy) {
		this.dfbuy = dfbuy;
	}

	public double getSb() {
		return sb;
	}

	public void setSb(double sb) {
		this.sb = sb;
	}

	public double getBb() {
		return bb;
	}

	public void setBb(double bb) {
		this.bb = bb;
	}

}
