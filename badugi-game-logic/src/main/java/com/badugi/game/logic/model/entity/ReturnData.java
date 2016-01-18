package com.badugi.game.logic.model.entity;

import java.util.List;

// Generated 2006-5-19 23:09:43 by Hibernate Tools 3.1.0.beta5

public class ReturnData<T> extends BaseEntity {

	private static final long serialVersionUID = 780085706010046654L;

	private int recordcount = 0;

	private int returnResult;

	private BaseEntity entity;

	private List<T> resultlist;

	public List<T> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	public int getRecordcount() {
		return recordcount;
	}

	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}

	public BaseEntity getEntity() {
		return entity;
	}

	public void setEntity(BaseEntity entity) {
		this.entity = entity;
	}

	public int getReturnResult() {
		return returnResult;
	}

	public void setReturnResult(int returnResult) {
		this.returnResult = returnResult;
	}

}
