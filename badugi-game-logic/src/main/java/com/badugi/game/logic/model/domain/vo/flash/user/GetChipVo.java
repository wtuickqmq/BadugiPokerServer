package com.badugi.game.logic.model.domain.vo.flash.user;

/**
 * 
* 项目名称：qq1.0   
* 类名称：GetChipVo   
* 创建人：huangcaiyuan 
* emial: caiyuan.huang@gmail.com   
* 创建时间：Mar 13, 2013 5:01:23 PM    
* @version 1.0
* 获得赠送筹码提示
 */
public class GetChipVo {

	
	/**
	 * 操作类型
	 */
	private Integer type;
	/**
	* fb编号
	*/
	private Long fbid;
	/**
	 * 美金价值
	 */
	private Double dl;
	
	/**
	 * 赠送用户筹码
	 */
	private Double chips;
	
	private Integer counts;
	
	private String cmd;
	private long code;
	
	public GetChipVo(){
		super();
	}

	public GetChipVo(Integer type, Long fbid, Double dl, Double chips,Integer counts) {
		super();
		this.type = type;
		this.fbid = fbid;
		this.dl = dl;
		this.chips = chips;
		this.counts=counts;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public Double getDl() {
		return dl;
	}

	public void setDl(Double dl) {
		this.dl = dl;
	}

	public Double getChips() {
		return chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
	

}
