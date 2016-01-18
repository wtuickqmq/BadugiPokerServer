package com.badugi.game.logic.model.vo.api.user;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api获取facebook好友返回值
 * 
 * @author amin
 */
public class UserCountsVo extends ResultVo {

	private Long code;
	private String desc;
	private Long fbid;// facebook编号
	private int fbcount;// facebook牌友总人数
	private int fblinecount;// facebook牌友在线总人数
	private int friendcount;// 牌友总人数
	private int friendlinecount;// 牌友在线总人数
	private int blackcount;// 黑名单总人数
	private int blacklinecount;// 黑名单在线人数
	private int fishcount;// fish总人数
	private int fishlinecount;// fish在线总人数
	private int foecount;// 敌人总人数
	private int foelinecount;// 敌人总在线人数

	public UserCountsVo() {
		super();
	}
	
	public UserCountsVo(Long code, String desc, Long fbid, int fbcount,
			int fblinecount, int friendcount, int friendlinecount,
			int blackcount, int blacklinecount, int fishcount,
			int fishlinecount, int foecount, int foelinecount) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.fbcount = fbcount;
		this.fblinecount = fblinecount;
		this.friendcount = friendcount;
		this.friendlinecount = friendlinecount;
		this.blackcount = blackcount;
		this.blacklinecount = blacklinecount;
		this.fishcount = fishcount;
		this.fishlinecount = fishlinecount;
		this.foecount = foecount;
		this.foelinecount = foelinecount;
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

	public int getFbcount() {
		return fbcount;
	}

	public void setFbcount(int fbcount) {
		this.fbcount = fbcount;
	}

	public int getFblinecount() {
		return fblinecount;
	}

	public void setFblinecount(int fblinecount) {
		this.fblinecount = fblinecount;
	}

	public int getFriendcount() {
		return friendcount;
	}

	public void setFriendcount(int friendcount) {
		this.friendcount = friendcount;
	}

	public int getFriendlinecount() {
		return friendlinecount;
	}

	public void setFriendlinecount(int friendlinecount) {
		this.friendlinecount = friendlinecount;
	}

	public int getBlackcount() {
		return blackcount;
	}

	public void setBlackcount(int blackcount) {
		this.blackcount = blackcount;
	}

	public int getBlacklinecount() {
		return blacklinecount;
	}

	public void setBlacklinecount(int blacklinecount) {
		this.blacklinecount = blacklinecount;
	}

	public int getFishcount() {
		return fishcount;
	}

	public void setFishcount(int fishcount) {
		this.fishcount = fishcount;
	}

	public int getFishlinecount() {
		return fishlinecount;
	}

	public void setFishlinecount(int fishlinecount) {
		this.fishlinecount = fishlinecount;
	}

	public int getFoecount() {
		return foecount;
	}

	public void setFoecount(int foecount) {
		this.foecount = foecount;
	}

	public int getFoelinecount() {
		return foelinecount;
	}

	public void setFoelinecount(int foelinecount) {
		this.foelinecount = foelinecount;
	}

}
