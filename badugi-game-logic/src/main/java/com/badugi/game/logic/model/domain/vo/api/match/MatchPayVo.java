package com.badugi.game.logic.model.domain.vo.api.match;

import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;

/**
 * api获取比赛参加方式
 * 
 * @author amin
 */
public class MatchPayVo extends ResultVo {

	private Long code;
	private String desc;
	private String mn;// 比赛名称
	private Integer gt;// 比赛大类型 
	private Integer mt;// 比赛二级类型
	private String ml;// 比赛类型名称
	private Integer mcr;// 币种
	private double jfc;// 参赛费用
	private double fwc;// 服务费用
	private double rc;//赏金
	private double ac;//当前可用额
	private double anm;//门票/积分
	private List<PayWays> list;// 钱圈

	public MatchPayVo() {
		super();
	}

	public MatchPayVo(Long code, String desc, String mn, String ml, Integer mcr, 
			double jfc, double fwc, double rc, double ac, List<PayWays> list) {
		super();
		this.code = code;
		this.desc = desc;
		this.mn = mn;
		this.ml = ml;
		this.mcr = mcr;
		this.jfc = jfc;
		this.fwc = fwc;
		this.rc = rc;
		this.ac = ac;
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

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}
	
	public Integer getGt() {
		return gt;
	}

	public void setGt(Integer gt) {
		this.gt = gt;
	}

	public Integer getMt() {
		return mt;
	}

	public void setMt(Integer mt) {
		this.mt = mt;
	}

	public String getMl() {
		return ml;
	}

	public void setMl(String ml) {
		this.ml = ml;
	}
	
	public Integer getMcr() {
		return mcr;
	}

	public void setMcr(Integer mcr) {
		this.mcr = mcr;
	}

	public double getJfc() {
		return jfc;
	}

	public void setJfc(double jfc) {
		this.jfc = jfc;
	}

	public double getFwc() {
		return fwc;
	}

	public void setFwc(double fwc) {
		this.fwc = fwc;
	}
	
	public double getAc() {
		return ac;
	}
	
	public void setAc(double ac) {
		this.ac = ac;
	}
	
	public double getAnm() {
		return anm;
	}

	public void setAnm(double anm) {
		this.anm = anm;
	}

	public List<PayWays> getList() {
		return list;
	}

	public void setList(List<PayWays> list) {
		this.list = list;
	}

	public double getRc() {
		return rc;
	}

	public void setRc(double rc) {
		this.rc = rc;
	}
	
}
