package com.badugi.game.logic.model.vo.api.user;

import java.util.List;

/**
 * 用户设置vo
 * 
 * @author amin
 * @date 2012-3-21 下午02:40:51
 * @description
 */
@SuppressWarnings("rawtypes")
public class UserSettingVo {

	private Integer os;// 弹窗模式
	private Integer rs;// 牌桌风格
	private Integer ps;// 扑克风格
	private List ss;// 偏好设置
	
	public UserSettingVo(){
	}
	
	public UserSettingVo(Integer os, Integer rs, Integer ps, List ss){
		this.os = os;
		this.rs = rs;
		this.ps = ps;
		this.ss = ss;
	}

	public Integer getOs() {
		return os;
	}

	public void setOs(Integer os) {
		this.os = os;
	}

	public Integer getRs() {
		return rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public Integer getPs() {
		return ps;
	}

	public void setPs(Integer ps) {
		this.ps = ps;
	}

	public List getSs() {
		return ss;
	}

	public void setSs(List ss) {
		this.ss = ss;
	}

}

