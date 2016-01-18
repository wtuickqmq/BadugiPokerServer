package com.badugi.game.logic.model.domain.vo.flash.match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.badugi.game.logic.util.MathExtendUtils;



/****
 * 牌桌
 * 
 * @author weijie
 * 
 */
public class Table {

	private String id;
	/***
	 * 最高筹码
	 */
	private Double maxChip;
	/****
	 * 平均筹码
	 */
	private Double avgChip;
	/***
	 * 最小筹码
	 */
	private Double minChip;

	/****
	 * 比赛 编号
	 */
	private Integer matchId;
	/**
	 * 排序
	 */
	private Integer roomSort;
	/**
	 * 是否删除（拼桌的时候需要这个值）
	 */
	private boolean isRemove;
	
	
	/*****
	 * 用户信息 long fbid
	 */
	private List<Long> users = new ArrayList<Long>();

	public Table() {
		super();
	}
	
	public Table(String id, Double maxChip, Double avgChip, Double minChip) {
		super();
		this.id = id;
		this.maxChip = maxChip;
		this.avgChip = avgChip;
		this.minChip = minChip;
	}
	
	public Table(String id, Double maxChip, Double avgChip, Double minChip, Integer roomSort) {
		super();
		this.id = id;
		this.maxChip = maxChip;
		this.avgChip = avgChip;
		this.minChip = minChip;
		this.roomSort = roomSort;
	}

	public Table(String id, Double maxChip, Double avgChip, Double minChip,
			List<Long> users) {
		super();
		this.id = id;
		this.maxChip = maxChip;
		this.avgChip = avgChip;
		this.minChip = minChip;
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getMaxChip() {
		return maxChip;
	}

	public void setMaxChip(Double maxChip) {
		this.maxChip = maxChip;
	}

	public Double getAvgChip() {
		return avgChip;
	}

	public void setAvgChip(Double avgChip) {
		this.avgChip = avgChip;
	}

	public Double getMinChip() {
		return minChip;
	}

	public void setMinChip(Double minChip) {
		this.minChip = minChip;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public List<Long> getUsers() {
		return users;
	}

	public void setUsers(List<Long> users) {
		this.users = users;
	}
	
	public Integer getRoomSort() {
		return roomSort;
	}

	public void setRoomSort(Integer roomSort) {
		this.roomSort = roomSort;
	}
	
	public boolean getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

	public void calculate(List<Double> chips){
		Collections.sort(chips);    
		if(chips.size()>0){
			maxChip=chips.get(0);
			minChip=chips.get(chips.size()-1);
		}
		Double sum=0.0;
		for(Double double_:chips){
			sum=MathExtendUtils.add(sum, double_);
		}
		if(sum>0){
			avgChip=MathExtendUtils.divide(sum.doubleValue(), new Integer(chips.size()).doubleValue());
		}
	}
 
}
