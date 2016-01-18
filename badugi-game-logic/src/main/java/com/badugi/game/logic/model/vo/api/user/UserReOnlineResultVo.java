package com.badugi.game.logic.model.vo.api.user;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 用户关系圈在线情况返回值
 * 
 * @author amin
 */
public class UserReOnlineResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int f;// 好友是否在线(fb好友和fb牌友)
	private int s;// 鱼是否在线
	private int e;// 敌人是否在线

	public UserReOnlineResultVo() {
		super();
	}

	public UserReOnlineResultVo(Long code, String desc, int f, int s, int e) {
		super();
		this.code = code;
		this.desc = desc;
		this.f = f;
		this.s = s;
		this.e = e;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

}
