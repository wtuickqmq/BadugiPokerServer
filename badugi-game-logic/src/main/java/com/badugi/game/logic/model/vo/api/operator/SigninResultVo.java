package com.badugi.game.logic.model.vo.api.operator;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 签到结果返回值
 * 
 * @author amin
 */
public class SigninResultVo extends ResultVo {

	private Long code;
	private String desc;
	private int count;// 月累计签到次数
	private long date;// 日期时间戳
	private List<SigninBoxDetailVo> plist;// 签到获得的奖品列表
	private List<SigninDayDetailVo> dlist;// 签到日期列表

	public SigninResultVo() {
		super();
	}

	public SigninResultVo(Long code, String desc, int count, long date,
			List<SigninBoxDetailVo> plist, List<SigninDayDetailVo> dlist) {
		super();
		this.code = code;
		this.desc = desc;
		this.count = count;
		this.date = date;
		this.plist = plist;
		this.dlist = dlist;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public List<SigninBoxDetailVo> getPlist() {
		return plist;
	}

	public void setPlist(List<SigninBoxDetailVo> plist) {
		this.plist = plist;
	}

	public List<SigninDayDetailVo> getDlist() {
		return dlist;
	}

	public void setDlist(List<SigninDayDetailVo> dlist) {
		this.dlist = dlist;
	}

}
