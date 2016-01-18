package com.badugi.game.logic.model.domain.vo.api.match.matchplayinfo;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

public class MatchPlayInfoVo extends ResultVo {

	private Long code;
	private String desc;
	private String mn;//比赛名称
	private Integer ms;//比赛状态  0开放登记;1正在进行 ;2人数已满;3比赛结束;4报名截止
	private Integer mt;//比赛类型  1坐满就玩;2锦标赛
	private Integer sam;//起手筹码(初始筹码)
	private Integer jfc;//参赛费用
	private Integer fwc;//服务费用
	private Integer mjc;//参赛最多人数
	private Integer sjc;//参赛最少人数 
	private Integer cl;//每多少(cl)筹码送一个门票券
	private String ar;//门票名称
	private Integer lc;//lc:奖池中不超过xx(lc)筹码形式发放
	private Double vp;//VIP积分
	private Double vd;//vip点数
	private Integer rc;//赏金
	private Integer rmc;//每张桌子最多人数
	private Integer blt;//断线保护时间
	private Integer mcfg;//奖金id,取代原mlist
	private Long sblevel;//当前盲注等级
	private List<Blind> blist;//盲注集合
	private List<BonusSaiQian> mlist;//奖金集合
	private List<MutipleBonusShow> mslist;//奖金集合多桌登录状态
	
	private ConInfo istb;//时间银行信息
	private ConInfo isbr;//断线保护信息
	private PauseVo isht;//中场休息信息
	private SyndealVo issd;//同步发牌信息
	private ConInfo isdr;//延迟登记信息
	private ConInfo isac;//加买筹码信息
	private ConInfo isfc;//最终筹码信息
	private ConInfo rt;//报名方式
	private ConInfo so;//特殊选项
	private Scdes sc;//实物/筹码定时赛
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
	public String getMn() {
		return mn;
	}
	public void setMn(String mn) {
		this.mn = mn;
	}
	public Integer getSam() {
		return sam;
	}
	public void setSam(Integer sam) {
		this.sam = sam;
	}
	public Integer getJfc() {
		return jfc;
	}
	public void setJfc(Integer jfc) {
		this.jfc = jfc;
	}
	public Integer getFwc() {
		return fwc;
	}
	public void setFwc(Integer fwc) {
		this.fwc = fwc;
	}
	public Integer getMjc() {
		return mjc;
	}
	public void setMjc(Integer mjc) {
		this.mjc = mjc;
	}
	public Integer getSjc() {
		return sjc;
	}
	public void setSjc(Integer sjc) {
		this.sjc = sjc;
	}
	public Integer getRmc() {
		return rmc;
	}
	public void setRmc(Integer rmc) {
		this.rmc = rmc;
	}
	public Integer getBlt() {
		return blt;
	}
	public void setBlt(Integer blt) {
		this.blt = blt;
	}
	public List<Blind> getBlist() {
		return blist;
	}
	public void setBlist(List<Blind> blist) {
		this.blist = blist;
	}
	public List<BonusSaiQian> getMlist() {
		return mlist;
	}
	public void setMlist(List<BonusSaiQian> mlist) {
		this.mlist = mlist;
	}
	public ConInfo getIstb() {
		return istb;
	}
	public void setIstb(ConInfo istb) {
		this.istb = istb;
	}
	public ConInfo getIsbr() {
		return isbr;
	}
	public void setIsbr(ConInfo isbr) {
		this.isbr = isbr;
	}
	public PauseVo getIsht() {
		return isht;
	}
	public void setIsht(PauseVo isht) {
		this.isht = isht;
	}
	public SyndealVo getIssd() {
		return issd;
	}
	public void setIssd(SyndealVo issd) {
		this.issd = issd;
	}
	public ConInfo getIsdr() {
		return isdr;
	}
	public void setIsdr(ConInfo isdr) {
		this.isdr = isdr;
	}
	public ConInfo getIsac() {
		return isac;
	}
	public void setIsac(ConInfo isac) {
		this.isac = isac;
	}
	public ConInfo getIsfc() {
		return isfc;
	}
	public void setIsfc(ConInfo isfc) {
		this.isfc = isfc;
	}
	public ConInfo getRt() {
		return rt;
	}
	public void setRt(ConInfo rt) {
		this.rt = rt;
	}
	public ConInfo getSo() {
		return so;
	}
	public void setSo(ConInfo so) {
		this.so = so;
	}
	public Integer getRc() {
		return rc;
	}
	public void setRc(Integer rc) {
		this.rc = rc;
	}
	public List<MutipleBonusShow> getMslist() {
		return mslist;
	}
	public void setMslist(List<MutipleBonusShow> mslist) {
		this.mslist = mslist;
	}
	public Integer getMs() {
		return ms;
	}
	public void setMs(Integer ms) {
		this.ms = ms;
	}
	public Integer getMt() {
		return mt;
	}
	public void setMt(Integer mt) {
		this.mt = mt;
	}
	public Integer getCl() {
		return cl;
	}
	public void setCl(Integer cl) {
		this.cl = cl;
	}
	public String getAr() {
		return ar;
	}
	public void setAr(String ar) {
		this.ar = ar;
	}
	public Integer getLc() {
		return lc;
	}
	public void setLc(Integer lc) {
		this.lc = lc;
	}
	public Double getVp() {
		return vp;
	}
	public void setVp(Double vp) {
		this.vp = vp;
	}
	public Double getVd() {
		return vd;
	}
	public void setVd(Double vd) {
		this.vd = vd;
	}
	public Scdes getSc() {
		return sc;
	}
	public void setSc(Scdes sc) {
		this.sc = sc;
	}
	public Integer getMcfg() {
		return mcfg;
	}
	public void setMcfg(Integer mcfg) {
		this.mcfg = mcfg;
	}
	public Long getSblevel() {
		return sblevel;
	}
	public void setSblevel(Long sblevel) {
		this.sblevel = sblevel;
	}
	

	
}
