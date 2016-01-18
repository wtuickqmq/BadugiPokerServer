package com.badugi.game.logic.model.domain.vo.flash.operators;

/**
 * 拼桌中间缓存
 * 
 * @author amin
 */
public class MergeTableUserVo {

	private Long fbid;
	private String rid;// 原房间ID
	private String nrid;// 新房间ID

	public MergeTableUserVo() {
		super();
	}

	public MergeTableUserVo(Long fbid, String rid, String nrid) {
		super();
		this.fbid = fbid;
		this.rid = rid;
		this.nrid = nrid;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getNrid() {
		return nrid;
	}

	public void setNrid(String nrid) {
		this.nrid = nrid;
	}

}
