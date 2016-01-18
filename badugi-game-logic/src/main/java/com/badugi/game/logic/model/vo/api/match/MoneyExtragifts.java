package com.badugi.game.logic.model.vo.api.match;

import java.util.List;

/**
 * 超过多少人额外赠送筹码或实物的钱圈配置方案
 * 
 * @author amin
 */
public class MoneyExtragifts {

	private int ck;// 超过多少人参加额外赠送
	private int mgt;// 赠送的类型(0：筹码，1：实物)
	private int mgc;// 赠送的筹码数/赠送奖品的ID
	private int am;// 赠送的份数
	private List<MoneyCircle> rs;

	public MoneyExtragifts() {
		super();
	}

	public MoneyExtragifts(int ck, int mgt, int mgc, int am,
			List<MoneyCircle> rs) {
		super();
		this.ck = ck;
		this.mgt = mgt;
		this.mgc = mgc;
		this.am = am;
		this.rs = rs;
	}

	public int getCk() {
		return ck;
	}

	public void setCk(int ck) {
		this.ck = ck;
	}

	public int getMgt() {
		return mgt;
	}

	public void setMgt(int mgt) {
		this.mgt = mgt;
	}

	public int getMgc() {
		return mgc;
	}

	public void setMgc(int mgc) {
		this.mgc = mgc;
	}

	public int getAm() {
		return am;
	}

	public void setAm(int am) {
		this.am = am;
	}

	public List<MoneyCircle> getRs() {
		return rs;
	}

	public void setRs(List<MoneyCircle> rs) {
		this.rs = rs;
	}

}
