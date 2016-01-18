package com.badugi.game.logic.model.vo.api.user;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;
import com.badugi.game.logic.model.vo.api.task.UserTaskFinalVo;

/**
 * api获取用户详情返回值
 * @author amin
 */
public class UserVo extends ResultVo {

	private Long code;
	private String desc;

	private Long fbid;// fbid
	private String name;// 名称
	private int expvalue;// 经验值(减去上一级的)
	private int explevel;// 普通等级
	private int nextlevelexpvalue;// 下个普通等级需要的经验值
	private int viplevel;// vpi等级
	private double currvipvalue;// 本期所获vip积分
	private double periodvipvalue;//vip保值积分
	private double nextlevelvipvalue;// 下个vip等级需要的积分
	private double vippoints;// vpi点数
	private String vipfromdate;// 等级起始时间
	private String vipenddate;// 等级结束时间
	private double chips;// 筹码数量
	private String createtime;// 注册时间
	private String lastlogintime;// 上次登录时间
	private int friendcount;// 好友数量
	private int playcount;// 已经玩局数
	private int wincount;// 胜局数
	private String besthands;// 最好手牌
	private double maxchips;// 最多筹码
	private double roundmaxchips;// 单局最多赢取筹码
	private int flag;//标记类型 0 无,1 鱼 2 敌人
	private int isfriend;//是否是牌友 0 不是 1是
	private int isfbfriend;//是否是facebook牌友0 不是 1是
	private int fbfriendcount;//facebook好有个数
	private int fishcount;//fish个数
	private int foecount;//敌人个数
	private int type;//是否为机器人1:是0:否
	private List<UserTaskFinalVo> tasklist;//任务完成情况
	private int likecount;//赞的总数
	private int islikeu;//是否已经赞过
	private int g;//金块
	private int m;//大师分
	private int ml;//大师分等级
	private int nm;//下一级大师分需要的大师分
	private String imgurl;//腾讯头像url

	public UserVo() {
		super();
	}

	//api/user调用
	public UserVo(Long code, String desc, Long fbid, String name,
			int expvalue, int explevel, int viplevel, int type,
			double currvipvalue, double vippoints, String vipfromdate,
			double chips, String createtime, String lastlogintime,
			int friendcount, int playcount, int wincount,
			String besthands, double maxchips, double roundmaxchips,
			int glod, int masterValue, int masterLevel) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.name = name;
		this.expvalue = expvalue;
		this.explevel = explevel;
		this.viplevel = viplevel;
		this.type = type;
		this.currvipvalue = currvipvalue;
		this.vippoints = vippoints;
		this.vipfromdate = vipfromdate;
		this.chips = chips;
		this.createtime = createtime;
		this.lastlogintime = lastlogintime;
		this.friendcount = friendcount;
		this.playcount = playcount;
		this.wincount = wincount;
		this.besthands = besthands;
		this.maxchips = maxchips;
		this.roundmaxchips = roundmaxchips;
		this.g = glod;
		this.m = masterValue;
		this.ml = masterLevel;
	}

	public UserVo(Long code, String desc, Long fbid, String name,
			int expvalue, int explevel, int nextlevelexpvalue,
			int viplevel, double currvipvalue, double nextlevelvipvalue,
			double vippoints, String vipfromdate, String vipenddate,
			double chips, String createtime, String lastlogintime,
			int friendcount, int playcount, int wincount,
			String besthands, double maxchips, double roundmaxchips) {
		super();
		this.code = code;
		this.desc = desc;
		this.fbid = fbid;
		this.name = name;
		this.expvalue = expvalue;
		this.explevel = explevel;
		this.nextlevelexpvalue = nextlevelexpvalue;
		this.viplevel = viplevel;
		this.currvipvalue = currvipvalue;
		this.nextlevelvipvalue = nextlevelvipvalue;
		this.vippoints = vippoints;
		this.vipfromdate = vipfromdate;
		this.vipenddate = vipenddate;
		this.chips = chips;
		this.createtime = createtime;
		this.lastlogintime = lastlogintime;
		this.friendcount = friendcount;
		this.playcount = playcount;
		this.wincount = wincount;
		this.besthands = besthands;
		this.maxchips = maxchips;
		this.roundmaxchips = roundmaxchips;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExpvalue() {
		return expvalue;
	}

	public void setExpvalue(int expvalue) {
		this.expvalue = expvalue;
	}

	public int getExplevel() {
		return explevel;
	}

	public void setExplevel(int explevel) {
		this.explevel = explevel;
	}

	public int getNextlevelexpvalue() {
		return nextlevelexpvalue;
	}

	public void setNextlevelexpvalue(int nextlevelexpvalue) {
		this.nextlevelexpvalue = nextlevelexpvalue;
	}

	public int getViplevel() {
		return viplevel;
	}

	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}

	public double getCurrvipvalue() {
		return currvipvalue;
	}

	public void setCurrvipvalue(double currvipvalue) {
		this.currvipvalue = currvipvalue;
	}
	
	public double getPeriodvipvalue() {
		return periodvipvalue;
	}

	public void setPeriodvipvalue(double periodvipvalue) {
		this.periodvipvalue = periodvipvalue;
	}

	public double getNextlevelvipvalue() {
		return nextlevelvipvalue;
	}

	public void setNextlevelvipvalue(double nextlevelvipvalue) {
		this.nextlevelvipvalue = nextlevelvipvalue;
	}

	public double getVippoints() {
		return vippoints;
	}

	public void setVippoints(double vippoints) {
		this.vippoints = vippoints;
	}

	public String getVipfromdate() {
		return vipfromdate;
	}

	public void setVipfromdate(String vipfromdate) {
		this.vipfromdate = vipfromdate;
	}

	public String getVipenddate() {
		return vipenddate;
	}

	public void setVipenddate(String vipenddate) {
		this.vipenddate = vipenddate;
	}

	public double getChips() {
		return chips;
	}

	public void setChips(double chips) {
		this.chips = chips;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public int getFriendcount() {
		return friendcount;
	}

	public void setFriendcount(int friendcount) {
		this.friendcount = friendcount;
	}

	public int getPlaycount() {
		return playcount;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	public int getWincount() {
		return wincount;
	}

	public void setWincount(int wincount) {
		this.wincount = wincount;
	}

	public String getBesthands() {
		return besthands;
	}

	public void setBesthands(String besthands) {
		this.besthands = besthands;
	}

	public double getMaxchips() {
		return maxchips;
	}

	public void setMaxchips(double maxchips) {
		this.maxchips = maxchips;
	}

	public double getRoundmaxchips() {
		return roundmaxchips;
	}

	public void setRoundmaxchips(double roundmaxchips) {
		this.roundmaxchips = roundmaxchips;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getIsfriend() {
		return isfriend;
	}

	public void setIsfriend(int isfriend) {
		this.isfriend = isfriend;
	}

	public int getIsfbfriend() {
		return isfbfriend;
	}

	public void setIsfbfriend(int isfbfriend) {
		this.isfbfriend = isfbfriend;
	}

	public int getFbfriendcount() {
		return fbfriendcount;
	}

	public void setFbfriendcount(int fbfriendcount) {
		this.fbfriendcount = fbfriendcount;
	}

	public int getFishcount() {
		return fishcount;
	}

	public void setFishcount(int fishcount) {
		this.fishcount = fishcount;
	}

	public int getFoecount() {
		return foecount;
	}

	public void setFoecount(int foecount) {
		this.foecount = foecount;
	}

	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

	public List<UserTaskFinalVo> getTasklist() {
		return tasklist;
	}

	public void setTasklist(List<UserTaskFinalVo> tasklist) {
		this.tasklist = tasklist;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	public int getIslikeu() {
		return islikeu;
	}

	public void setIslikeu(int islikeu) {
		this.islikeu = islikeu;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
	}

	public int getNm() {
		return nm;
	}

	public void setNm(int nm) {
		this.nm = nm;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
}
