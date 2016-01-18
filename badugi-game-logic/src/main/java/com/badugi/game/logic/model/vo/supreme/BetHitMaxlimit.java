package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.Map;

public class BetHitMaxlimit  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private String item;//押注门类
	private Long fbId;
	private Long hitLimitChips;//达到上限时押注的筹码量
	private Long maxLimitChips; //上限筹码
	private Map<String,Boolean> poolIsExceeding;//<门类,是否达上限>
	public BetHitMaxlimit(){}
	public BetHitMaxlimit(String cmd,Long fbId,String item,Long hitLimitChips,Long maxLimitChips,Map<String,Boolean> poolIsExceeding){
		this.cmd = cmd;
		this.fbId = fbId;
		this.item = item;
		this.hitLimitChips = hitLimitChips;
		this.maxLimitChips =maxLimitChips ;
		this.poolIsExceeding = poolIsExceeding;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Long getMaxLimitChips() {
		return maxLimitChips;
	}
	public void setMaxLimitChips(Long maxLimitChips) {
		this.maxLimitChips = maxLimitChips;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public Long getHitLimitChips() {
		return hitLimitChips;
	}
	public void setHitLimitChips(Long hitLimitChips) {
		this.hitLimitChips = hitLimitChips;
	}
	public Map<String, Boolean> getPoolIsExceeding() {
		return poolIsExceeding;
	}
	public void setPoolIsExceeding(Map<String, Boolean> poolIsExceeding) {
		this.poolIsExceeding = poolIsExceeding;
	}
}
