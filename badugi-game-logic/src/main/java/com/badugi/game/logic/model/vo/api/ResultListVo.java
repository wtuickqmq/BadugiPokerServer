package com.badugi.game.logic.model.vo.api;

import java.util.List;

/**
 * @createTime: 2013-04-25
 * @description：
 */
@SuppressWarnings("rawtypes")
public class ResultListVo extends ApiResultVo {
	private List list;

	public ResultListVo(Long code, String description) {
		super(code, description);
	}

	public ResultListVo(Long code, String description, List list) {
		super(code, description);
		this.list = list;
	}

	public ResultListVo(Long code, String description, String detailError) {
		super(code, description, detailError);
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
