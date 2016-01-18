package com.badugi.game.logic.model.domain.vo.flash.operators;

import java.util.List;

/**
 * 帅处理
 * 
 * @author amin
 */
public class SmartOp {

	private Integer rid;
	private Long st;
	private Long et;
	private boolean ie;
	private List<SmartResult> list;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Long getSt() {
		return st;
	}

	public void setSt(Long st) {
		this.st = st;
	}

	public Long getEt() {
		return et;
	}

	public void setEt(Long et) {
		this.et = et;
	}
	
	public boolean getIe() {
		return ie;
	}

	public void setIe(boolean ie) {
		this.ie = ie;
	}

	public List<SmartResult> getList() {
		return list;
	}

	public void setList(List<SmartResult> list) {
		this.list = list;
	}

}
