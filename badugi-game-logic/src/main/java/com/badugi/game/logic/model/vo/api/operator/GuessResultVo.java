package com.badugi.game.logic.model.vo.api.operator;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 猜大小返回值
 * 
 * @author amin
 */
public class GuessResultVo extends ResultVo {

	private Long code;
	private String desc;
	private Long fbid;// 请求facebook编号
	private int id;// 牌型ID
	private int count;// 猜大小的次数
	private int right;// 才对的次数
	private List<GuessDetailVo> bslist;// 牌型集合

	public GuessResultVo() {
		super();
	}

	public GuessResultVo(Long code, String desc, Long fbid, int id, int count,
			int right, List<GuessDetailVo> bslist) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.id = id;
		this.count = count;
		this.right = right;
		this.bslist = bslist;
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

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public List<GuessDetailVo> getBslist() {
		return bslist;
	}

	public void setBslist(List<GuessDetailVo> bslist) {
		this.bslist = bslist;
	}

}
