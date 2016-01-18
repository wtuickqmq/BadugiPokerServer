package com.badugi.game.logic.model.vo.qq;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class TReturnVo  extends ResultVo{
	private Integer ret;
	private String msg;
	private Integer is_lost;
	public Integer getRet() {
		return ret;
	}
	public void setRet(Integer ret) {
		this.ret = ret;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getIs_lost() {
		return is_lost;
	}
	public void setIs_lost(Integer isLost) {
		is_lost = isLost;
	}
	
	
}
