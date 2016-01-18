package com.badugi.game.logic.model.vo.flash.operators;

/**
 * 赠送筹码通知flash信息vo
 * 
 * @author amin
 */
public class PresentPhoneCardNoticeVo {

	/**
	 * 返回码
	 */
	private Long code;
	/**
	 * 操作类型
	 */
	private String cmd;
	/**
	 * 赠送充值卡的张数
	 */
	private double count;
	/**
	 * 需要赢取的筹码数
	 */
	private double sum;
	/**
	 * 泰铢充值卡的价值
	 */
	private double value;
	/**
	 * 还需要赢取的筹码数
	 */
	private double ssum;

	public PresentPhoneCardNoticeVo() {
		super();
	}

	public PresentPhoneCardNoticeVo(Long code, String cmd, double count,
			double sum, double value, double ssum) {
		super();
		this.code = code;
		this.cmd = cmd;
		this.count = count;
		this.sum = sum;
		this.value = value;
		this.ssum = ssum;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

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

	public double getSsum() {
		return ssum;
	}

	public void setSsum(double ssum) {
		this.ssum = ssum;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
