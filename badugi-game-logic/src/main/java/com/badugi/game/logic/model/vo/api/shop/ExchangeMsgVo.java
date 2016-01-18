package com.badugi.game.logic.model.vo.api.shop;

import java.net.URLDecoder;

public class ExchangeMsgVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5398959939416884738L;

	private String cmd;
	/**
	 * 返回码
	 */
	private Long code;
	
	/*兑换者ID*/
	private Long uid;
	
	/*兑换物品名称*/
	private String goodsName;
	
	/*兑换数量*/
	private Integer num;

	public ExchangeMsgVo() {
		super();
	}
	
	public ExchangeMsgVo(String cmd, Long code, Long uid, String goodsName, Integer num) {
		super();
		this.cmd = cmd;
		this.code = code;
		this.uid = uid;
		this.goodsName = goodsName;
		this.num = num;
	}
	
	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String toString() {
		return "您提交的" + goodsName +"（数量：" + num +"）领取申请，我们正在仔细核对";
	}
}
