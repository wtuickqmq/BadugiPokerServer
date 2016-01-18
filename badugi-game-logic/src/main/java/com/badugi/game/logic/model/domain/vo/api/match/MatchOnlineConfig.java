package com.badugi.game.logic.model.domain.vo.api.match;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author amin
 */
public class MatchOnlineConfig {

	private int bt;
	private int et;
	private double tc;
	private double add;
	
	private static List<MatchOnlineConfig> MATCH_ONLINES = new ArrayList<MatchOnlineConfig>();
	
	static{
		MATCH_ONLINES.add(new MatchOnlineConfig(0,2,3,-2));
		MATCH_ONLINES.add(new MatchOnlineConfig(2,8,1,2));
		MATCH_ONLINES.add(new MatchOnlineConfig(8,10,3,1));
		MATCH_ONLINES.add(new MatchOnlineConfig(10,14,4,1));
		MATCH_ONLINES.add(new MatchOnlineConfig(14,16,5,1));
		MATCH_ONLINES.add(new MatchOnlineConfig(16,20,6,-1));
		MATCH_ONLINES.add(new MatchOnlineConfig(20,23,5,-2));
	}
	
	public MatchOnlineConfig(){
		super();
	}
	
	public MatchOnlineConfig(int bt, int et, int tc, int add) {
		super();
		this.bt = bt;
		this.et = et;
		this.tc = tc;
		this.add = add;
	}

	public static List<MatchOnlineConfig> getMatchOnlineConfigs(){
		return MATCH_ONLINES;
	}

	public int getBt() {
		return bt;
	}

	public void setBt(int bt) {
		this.bt = bt;
	}

	public int getEt() {
		return et;
	}

	public void setEt(int et) {
		this.et = et;
	}

	public double getTc() {
		return tc;
	}

	public void setTc(double tc) {
		this.tc = tc;
	}

	public double getAdd() {
		return add;
	}

	public void setAdd(double add) {
		this.add = add;
	}
	
}
