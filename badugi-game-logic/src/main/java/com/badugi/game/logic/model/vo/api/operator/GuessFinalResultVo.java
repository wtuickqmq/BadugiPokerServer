package com.badugi.game.logic.model.vo.api.operator;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * 猜大小结果返回值
 * 
 * @author amin
 */
public class GuessFinalResultVo extends ResultVo {

	private Long code;
	private String desc;
	private List<GuessFinalDetailVo> bslist;// 牌型集合
	private int count;// 需要多少次完成
	private int step;// 第几次
	private int isend;// 是否结束(1：完成0：未完成)
	private int right;// 猜对的数量
	private String tn;// 奖品名称

	public GuessFinalResultVo() {
		super();
	}

	public GuessFinalResultVo(Long code, String desc,
			List<GuessFinalDetailVo> bslist, int count, int step, int isend,
			int right, String tn) {
		super();
		this.code = code;
		this.desc = desc;
		this.bslist = bslist;
		this.count = count;
		this.step = step;
		this.isend = isend;
		this.right = right;
		this.tn = tn;
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

	public List<GuessFinalDetailVo> getBslist() {
		return bslist;
	}

	public void setBslist(List<GuessFinalDetailVo> bslist) {
		this.bslist = bslist;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getIsend() {
		return isend;
	}

	public void setIsend(int isend) {
		this.isend = isend;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

}
