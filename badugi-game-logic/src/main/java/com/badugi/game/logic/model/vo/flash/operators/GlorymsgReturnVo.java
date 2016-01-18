package com.badugi.game.logic.model.vo.flash.operators;

import java.util.List;

import com.badugi.game.logic.model.vo.flash.match.GoodsDetail;
import com.badugi.game.logic.model.vo.flash.match.RewardPrizeVo;
import com.badugi.game.logic.model.vo.flash.match.TicketDetail;

public class GlorymsgReturnVo {

	/**
	 * 返回码
	 */
	private String cmd;
	private Long code;

	private Long fbid;
	private String fbname;
	private Integer gtype;// 1:赢大钱(超过300大盲)2:帅3:每日场任务4:比赛冠军5:升大级6:金块兑换实物

	// 1
	private Double sb;
	private Double bb;
	// 2
	private String bt;
	private String et;
	private String rn;
	// 4
	private String mn;
	// 5,6
	private String name;
	private Long value;

	private Double chips;
	private String msg;

	private RewardPrizeVo prize;

	private String imgurl;

	private Integer role;

	public GlorymsgReturnVo() {
		super();
	}

	/**
	 * 赢大钱额外奖励
	 */
	public GlorymsgReturnVo(Long fbid, Integer gtype, Double sb, Double bb,
			Double am, Double chips, String msg) {
		super();
		this.fbid = fbid;
		this.gtype = gtype;
		this.sb = sb;
		this.bb = bb;
		this.prize = new RewardPrizeVo(am);
		this.chips = chips;
		this.msg = msg;
	}

	/**
	 * 帅
	 */
	public GlorymsgReturnVo(Long fbid, Integer gtype, String bt, String et,
			String rn, Double am, Double chips, String msg) {
		super();
		this.fbid = fbid;
		this.gtype = gtype;
		this.bt = bt;
		this.et = et;
		this.rn = rn;
		this.prize = new RewardPrizeVo(am);
		this.chips = chips;
		this.msg = msg;
	}

	/**
	 * 比赛冠军广播
	 */
	public GlorymsgReturnVo(Long fbid, Integer gtype, String mn, Double am,
			Integer g, Integer m, String imgurl, Integer role, List<TicketDetail> tlist,
			List<GoodsDetail> glist) {
		super();
		this.fbid = fbid;
		this.gtype = gtype;
		this.mn = mn;
		this.imgurl = imgurl;
		this.role = role;
		this.prize = new RewardPrizeVo(am, g, m, tlist, glist);
	}

	/**
	 * 升大级广播
	 */
	public GlorymsgReturnVo(Long fbid, Integer gtype, String name, Long value) {
		super();
		this.fbid = fbid;
		this.gtype = gtype;
		this.name = name;
		this.value = value;
	}

	/**
	 * 金块兑换实物广播
	 */
	public GlorymsgReturnVo(Long fbid, Integer gtype, RewardPrizeVo prize, Long value) {
		this.fbid = fbid;
		this.gtype = gtype;
		this.prize = prize;
		this.value = value;
	}

	/**
	 * KO明星广播
	 */
	public GlorymsgReturnVo(Long fbid, Integer gtype, String mn, String name, Long value, Integer g) {
		this.fbid = fbid;
		this.gtype = gtype;
		this.mn = mn;
		this.name = name;
		this.value = value;
		this.prize = new RewardPrizeVo(0, g, 0);
	}

	public GlorymsgReturnVo(String cmd, Long code) {
		super();
		this.cmd = cmd;
		this.code = code;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
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

	public Integer getGtype() {
		return gtype;
	}

	public void setGtype(Integer gtype) {
		this.gtype = gtype;
	}

	public Double getSb() {
		return sb;
	}

	public void setSb(Double sb) {
		this.sb = sb;
	}

	public Double getBb() {
		return bb;
	}

	public void setBb(Double bb) {
		this.bb = bb;
	}

	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}

	public String getEt() {
		return et;
	}

	public void setEt(String et) {
		this.et = et;
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Double getChips() {
		return chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public RewardPrizeVo getPrize() {
		return prize;
	}

	public void setPrize(RewardPrizeVo prize) {
		this.prize = prize;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
