package com.badugi.game.logic.model.vo.flash.match;

/**
 * 拼桌详细
 * @author amin
 */
public class MergeTableDetail {

	private String puid;//父账号
	private String rid;//新桌房间ID

	public MergeTableDetail() {
		super();
	}

	public MergeTableDetail(String puid, String rid) {
		super();
		this.puid = puid;
		this.rid = rid;
	}

	public String getPuid() {
		return puid;
	}

	public void setPuid(String puid) {
		this.puid = puid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

}
