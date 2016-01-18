package com.badugi.game.logic.model.vo.api.user;

/**
 * 偏好设置vo
 * @author amin
 * @date 2012-3-21 下午05:07:05
 * @description
 *
 */
public class UserSeatVo {

	private Integer type;
	private Integer value;
	
	public UserSeatVo(){
	}
	
	public UserSeatVo(Integer type, Integer value){
		this.type = type;
		this.value = value;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}

