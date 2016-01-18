package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DealerQueueResult  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long code;
	private String cmd;
	private ConcurrentLinkedQueue<DealerQueueVo> dealqueue;
	private String remark;
	private Long fbId;
	
	public DealerQueueResult(){}
	
	public DealerQueueResult(String cmd,Long code,String remark){
		this.cmd = cmd;
		this.code = code;
		this.remark = remark;
	}
	public DealerQueueResult(String cmd,Long code,String remark,Long fbId){
		this.cmd = cmd;
		this.code = code;
		this.remark = remark;
		this.fbId = fbId;
	}
	public DealerQueueResult(String cmd,Long code,ConcurrentLinkedQueue<DealerQueueVo> dealqueue){
		this.cmd = cmd;
		this.code = code;
		this.dealqueue = dealqueue;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public ConcurrentLinkedQueue<DealerQueueVo> getDealqueue() {
		return dealqueue;
	}
	public void setDealqueue(ConcurrentLinkedQueue<DealerQueueVo> dealqueue) {
		this.dealqueue = dealqueue;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getFbId() {
		return fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
}
