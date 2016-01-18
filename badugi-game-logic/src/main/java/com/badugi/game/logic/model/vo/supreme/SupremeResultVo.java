package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.List;


public class SupremeResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 玩家押注
	 */
	public static final int Supreme_1 = 1;
	private String cmd;
	private long code;
	private int flag;
	private List<PlayerInRoomResult> list;
	private String rid; //小游戏房间号
	private double am;//游戏房间筹码
	private Long fbId;//用户id
	private String description;
	private List<Double> chipLayers;
	private Long nowTime;
	public SupremeResultVo(){}
	public SupremeResultVo(String cmd){
		this.cmd = cmd;
	}
	public SupremeResultVo(long code,String description){
		this.code = code; 
		this.description = description;
	}
	public SupremeResultVo(String cmd,long code){
		this.code = code; 
		this.cmd = cmd;
	}
	public SupremeResultVo(Long fbId,String cmd,String description){
		this.cmd = cmd; 
		this.description = description;
		this.fbId = fbId;
	}
	public SupremeResultVo(Long code,String cmd,Long fbId,String description){
		this.code = code;
		this.cmd = cmd; 
		this.description = description;
		this.fbId = fbId;
	}
	public SupremeResultVo(long code,String description,Long fbId){
		this.code = code; 
		this.description = description;
		this.fbId = fbId;
	}
	public SupremeResultVo(long code,String description,Long fbId,String rid,List<PlayerInRoomResult> list,Long nowTime){
		this.code = code; 
		this.nowTime = nowTime;
		this.description = description;
		this.fbId = fbId;
		this.rid = rid;
		this.list = list;
	}
	/**
	 * 
	 * @param type
	 * @param code
	 * @param list
	 */
	public SupremeResultVo(String cmd,Long code,String rid,double am,List<PlayerInRoomResult> list){
		this.cmd = cmd;
		this.code = code;
		this.am = am;
		this.rid = rid;
		this.list = list;
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public List<PlayerInRoomResult> getList() {
		return list;
	}
	public void setList(List<PlayerInRoomResult> list) {
		this.list = list;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public double getAm() {
		return am;
	}
	public void setAm(double am) {
		this.am = am;
	}

	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public List<Double> getChipLayers() {
		return chipLayers;
	}
	public void setChipLayers(List<Double> chipLayers) {
		this.chipLayers = chipLayers;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getNowTime() {
		return nowTime;
	}
	public void setNowTime(Long nowTime) {
		this.nowTime = nowTime;
	}
}
