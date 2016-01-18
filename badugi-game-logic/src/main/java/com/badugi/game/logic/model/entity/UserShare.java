package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserShare entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_share")
public class UserShare extends BaseEntity implements java.io.Serializable {

	//分享类型 1、牌桌里分享；2、邀请好友进入游戏应用分享；3成为应用中牌友分享；4比赛结束后获得排名后分享;5发送求帮助
	public final static Integer ROOM_SHARE=1;
	public final static Integer FB_INVITES_HARE=2;
	public final static Integer APP_INVITE_SHARE=3;
	public final static Integer MATCH_SHARE=4;
	public final static Integer FORHELP_SHARE=5;
	
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private String content;
	private Timestamp createTime;
	private Integer shareType;
	private String shareTypeName;
	private Long uniqueId;

	// Constructors

	/** default constructor */
	public UserShare() {
	}

	/** minimal constructor */
	public UserShare(Long fbId, Timestamp createTime) {
		this.fbId = fbId;
		this.createTime = createTime;
	}

	/** full constructor */
	public UserShare(Long fbId, String content, Timestamp createTime,
			Integer shareType) {
		this.fbId = fbId;
		this.content = content;
		this.createTime = createTime;
		this.shareType = shareType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "Content", length = 200)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "shareType")
	public Integer getShareType() {
		return this.shareType;
	}

	public void setShareType(Integer shareType) {
		this.shareType = shareType;
	}
	@Column(name = "ShareTypeName")
	public String getShareTypeName() {
		return shareTypeName;
	}

	public void setShareTypeName(String shareTypeName) {
		this.shareTypeName = shareTypeName;
	}
	
	@Column(name = "uniqueId")
	public Long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}

}