package com.badugi.game.logic.model.vo.api.user;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api等级排行返回值
 * 
 * @author amin
 */
public class LevelRanksVo extends ResultVo {

	private Long code;
	private String desc;
	private Long fbid;// 请求facebook编号
	private Integer type;// 排行类型(0 全部用户 1我的牌友)
	private Integer myrank;// 我的排行
	private List<LevelRankDetail> list;// 排名详细

	public LevelRanksVo() {
		super();
	}

	public LevelRanksVo(Long code, String desc, Long fbid, Integer type,
			Integer myrank, List<LevelRankDetail> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.type = type;
		this.myrank = myrank;
		this.list = list;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMyrank() {
		return myrank;
	}

	public void setMyrank(Integer myrank) {
		this.myrank = myrank;
	}

	public List<LevelRankDetail> getList() {
		return list;
	}

	public void setList(List<LevelRankDetail> list) {
		this.list = list;
	}

}
