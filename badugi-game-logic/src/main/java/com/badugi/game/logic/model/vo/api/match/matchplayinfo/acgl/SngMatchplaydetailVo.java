package com.badugi.game.logic.model.vo.api.match.matchplayinfo.acgl;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * SNG比赛详情
 * @author Administrator
 *
 */
public class SngMatchplaydetailVo extends ResultVo {
	private Long code;
	private String desc;
	private Integer mi;//	赛事编号MatchId	Int(-1无大赛)
	private String mn;//	比赛名称 MatchName	string
	private Integer sj;//	单场奖金(20珠)，单张20珠	int
	private Integer pe;//	每积累X张换一张Y泰珠充值卡的X	int
	private Integer tj;//	每积累X张换一张Y泰珠充值卡的Y	int
	private List<LastWeeKPrize> plist;//上周获奖排行
	private List<SngSinglePrize> slist;//单场奖励
	
	
	public SngMatchplaydetailVo(Long code, String desc, Integer mi, String mn,
			Integer sj, Integer pe, Integer tj, List<LastWeeKPrize> plist,
			List<SngSinglePrize> slist) {
		super();
		this.code = code;
		this.desc = desc;
		this.mi = mi;
		this.mn = mn;
		this.sj = sj;
		this.pe = pe;
		this.tj = tj;
		this.plist = plist;
		this.slist = slist;
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
	public Integer getMi() {
		return mi;
	}
	public void setMi(Integer mi) {
		this.mi = mi;
	}
	public String getMn() {
		return mn;
	}
	public void setMn(String mn) {
		this.mn = mn;
	}
	public Integer getSj() {
		return sj;
	}
	public void setSj(Integer sj) {
		this.sj = sj;
	}
	public Integer getPe() {
		return pe;
	}
	public void setPe(Integer pe) {
		this.pe = pe;
	}
	public Integer getTj() {
		return tj;
	}
	public void setTj(Integer tj) {
		this.tj = tj;
	}
	public List<LastWeeKPrize> getPlist() {
		return plist;
	}
	public void setPlist(List<LastWeeKPrize> plist) {
		this.plist = plist;
	}
	public List<SngSinglePrize> getSlist() {
		return slist;
	}
	public void setSlist(List<SngSinglePrize> slist) {
		this.slist = slist;
	}
	
	


}
