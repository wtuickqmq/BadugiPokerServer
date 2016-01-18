package com.badugi.game.logic.model.vo.api.user;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api成就返回值
 * 
 * @author amin
 */
public class AchieveVo extends ResultVo {

	private Long code;
	private String desc;
	private Long fbid;// facebook编号
	private String fbname;// facebook名称
	private Integer vipallrank;// vip全部用户排行
	private Integer viprank;// vip我的牌友排行
	private Integer viplevel;// vip等级
	private double vipper;// 下一个vip等级百分比
	private Integer levelallrank;// 等级全部用户排行
	private Integer levelrank;// 等级我的牌友排行
	private Integer level;// 我的等级
	private Integer chipsallrank;// 筹码全部用户排行
	private Integer chipsrank;// 筹码我的牌友排行
	private double chips;// 我的筹码

	public AchieveVo() {
		super();
	}

	public AchieveVo(Long code, String desc, Long fbid, String fbname,
			Integer vipallrank, Integer viprank, Integer viplevel,
			double vipper, Integer levelallrank, Integer levelrank,
			Integer level, Integer chipsallrank, Integer chipsrank, double chips) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.fbname = fbname;
		this.vipallrank = vipallrank;
		this.viprank = viprank;
		this.viplevel = viplevel;
		this.vipper = vipper;
		this.levelallrank = levelallrank;
		this.levelrank = levelrank;
		this.level = level;
		this.chipsallrank = chipsallrank;
		this.chipsrank = chipsrank;
		this.chips = chips;
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

	public String getFbname() {
		return fbname;
	}

	public void setFbname(String fbname) {
		this.fbname = fbname;
	}

	public Integer getVipallrank() {
		return vipallrank;
	}

	public void setVipallrank(Integer vipallrank) {
		this.vipallrank = vipallrank;
	}

	public Integer getViprank() {
		return viprank;
	}

	public void setViprank(Integer viprank) {
		this.viprank = viprank;
	}

	public Integer getViplevel() {
		return viplevel;
	}

	public void setViplevel(Integer viplevel) {
		this.viplevel = viplevel;
	}

	public double getVipper() {
		return vipper;
	}

	public void setVipper(double vipper) {
		this.vipper = vipper;
	}

	public Integer getLevelallrank() {
		return levelallrank;
	}

	public void setLevelallrank(Integer levelallrank) {
		this.levelallrank = levelallrank;
	}

	public Integer getLevelrank() {
		return levelrank;
	}

	public void setLevelrank(Integer levelrank) {
		this.levelrank = levelrank;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getChipsallrank() {
		return chipsallrank;
	}

	public void setChipsallrank(Integer chipsallrank) {
		this.chipsallrank = chipsallrank;
	}

	public Integer getChipsrank() {
		return chipsrank;
	}

	public void setChipsrank(Integer chipsrank) {
		this.chipsrank = chipsrank;
	}

	public double getChips() {
		return chips;
	}

	public void setChips(double chips) {
		this.chips = chips;
	}

}
