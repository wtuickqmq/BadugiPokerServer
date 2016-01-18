package com.badugi.game.logic.model.vo.flash.match;
/*****
 * 同步发牌
 * @author weijie
 *
 */
public class MatchSyncDeal {
	
	private Integer matchConfigId;
	
	private int startUserCount;
	
	private int stopUserCount;

	public MatchSyncDeal() {
		super();
	}

	public MatchSyncDeal(int matchConfigId, int startUserCount,
			int stopUserCount) {
		super();
		this.matchConfigId = matchConfigId;
		this.startUserCount = startUserCount;
		this.stopUserCount = stopUserCount;
	}

	public int getMatchConfigId() {
		return matchConfigId;
	}

	public void setMatchConfigId(int matchConfigId) {
		this.matchConfigId = matchConfigId;
	}

	public int getStartUserCount() {
		return startUserCount;
	}

	public void setStartUserCount(int startUserCount) {
		this.startUserCount = startUserCount;
	}

	public int getStopUserCount() {
		return stopUserCount;
	}

	public void setStopUserCount(int stopUserCount) {
		this.stopUserCount = stopUserCount;
	}
	
	
	
	
}
