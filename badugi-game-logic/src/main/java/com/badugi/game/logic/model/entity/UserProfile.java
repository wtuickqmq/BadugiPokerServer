package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile extends BaseEntity implements java.io.Serializable{

	private static final long serialVersionUID = 5633222222445659L;

	/*用户id*/
	private Long uid;
	
	/*用户名*/
	private String uname;
	
	/*用户签名*/
	private String comment;
	
	/*赢局数*/
	private Integer win;
	
	/*失败数*/
	private Integer lost;
	
	/*平局数*/
	private Integer draw;
	
	/*成就数*/
	private Integer achieveCount;
	
	/*参赛次数*/
	private Integer matchTime;
	
	/*获胜次数*/
	private Integer matchWin;
	
	/*好友数*/
	private Integer friends;
	
	/*邀请数*/
	private Integer inviteFriend;
	
	/*赠送数*/
	private Integer sendSutff;
	
	/*分享数*/
	private Integer shares;
	
	/*鱼的数量*/
	private Integer fishs;
	
	/*敌人数*/
	private Integer enemys;

	/*装饰id*/
	private Integer decorate;
	
	/*进入游戏时间*/
//	private Timestamp joinTime;
	
	/*用户头像*/
	private String imgurl;
	
	/*皇家同花顺*/
	private Short royalFlush;
	
	/*同花顺*/
	private Short straightFlush;
	
	/*四条*/
	private Short fourKind;
	
	/*葫芦*/
	private Short fullHouse;
	
	/*同花*/
	private Short flush;
	
	/*顺子*/
	private Short straight;
	
	/*三条*/
	private Short threeKind;

	public UserProfile() {
		super();
	}

	public UserProfile(Long uid, String uname, String imgurl) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.imgurl = imgurl;
		
		this.win = 0;
		this.lost = 0;
		this.draw = 0;
		this.achieveCount = 0;
		this.matchTime = 0;
		this.matchWin = 0;
		this.friends = 0;
		this.inviteFriend = 0;
		this.sendSutff = 0;
		this.shares = 0;
		this.fishs = 0;
		this.enemys = 0;
		this.decorate = 0;
		this.royalFlush = 0;
		this.straightFlush = 0;
		this.fourKind = 0;
		this.fullHouse = 0;
		this.flush = 0;
		this.straight = 0;
		this.threeKind = 0;
	}
	@Id
	@Column(name = "u_id", unique = true, nullable = false)
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	@Column(name = "u_name", nullable = true)
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	@Column(name = "comment", nullable = true)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "win", nullable = false)
	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	@Column(name = "lost", nullable = false)
	public Integer getLost() {
		return lost;
	}

	public void setLost(Integer lost) {
		this.lost = lost;
	}

	@Column(name = "draw", nullable = false)
	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	@Column(name = "achieve_count", nullable = false)
	public Integer getAchieveCount() {
		return achieveCount;
	}

	public void setAchieveCount(Integer achieveCount) {
		this.achieveCount = achieveCount;
	}

	@Column(name = "match_time", nullable = false)
	public Integer getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Integer matchTime) {
		this.matchTime = matchTime;
	}

	@Column(name = "match_win", nullable = false)
	public Integer getMatchWin() {
		return matchWin;
	}

	public void setMatchWin(Integer matchWin) {
		this.matchWin = matchWin;
	}

	@Column(name = "friends", nullable = false)
	public Integer getFriends() {
		return friends;
	}

	public void setFriends(Integer friends) {
		this.friends = friends;
	}

	@Column(name = "invite_friend", nullable = false)
	public Integer getInviteFriend() {
		return inviteFriend;
	}

	public void setInviteFriend(Integer inviteFriend) {
		this.inviteFriend = inviteFriend;
	}

	@Column(name = "send_sutff", nullable = false)
	public Integer getSendSutff() {
		return sendSutff;
	}

	public void setSendSutff(Integer sendSutff) {
		this.sendSutff = sendSutff;
	}

	@Column(name = "shares", nullable = false)
	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	@Column(name = "fishs", nullable = false)
	public Integer getFishs() {
		return fishs;
	}

	public void setFishs(Integer fishs) {
		this.fishs = fishs;
	}

	@Column(name = "enemys", nullable = false)
	public Integer getEnemys() {
		return enemys;
	}

	public void setEnemys(Integer enemys) {
		this.enemys = enemys;
	}

	@Column(name = "decorate", nullable = true)
	public Integer getDecorate() {
		return decorate;
	}

	public void setDecorate(Integer decorate) {
		this.decorate = decorate;
	}

//	@Column(name = "join_time", nullable = true)
//	public Timestamp getJoinTime() {
//		return joinTime;
//	}
//
//	public void setJoinTime(Timestamp joinTime) {
//		this.joinTime = joinTime;
//	}

	@Column(name = "imgurl", nullable = true)
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Column(name = "royal_flush", nullable = false)
	public Short getRoyalFlush() {
		return royalFlush;
	}

	public void setRoyalFlush(Short royalFlush) {
		this.royalFlush = royalFlush;
	}

	@Column(name = "straight_flush", nullable = false)
	public Short getStraightFlush() {
		return straightFlush;
	}

	public void setStraightFlush(Short straightFlush) {
		this.straightFlush = straightFlush;
	}

	@Column(name = "four_kind", nullable = false)
	public Short getFourKind() {
		return fourKind;
	}

	public void setFourKind(Short fourKind) {
		this.fourKind = fourKind;
	}

	@Column(name = "full_house", nullable = false)
	public Short getFullHouse() {
		return fullHouse;
	}

	public void setFullHouse(Short fullHouse) {
		this.fullHouse = fullHouse;
	}

	@Column(name = "flush", nullable = false)
	public Short getFlush() {
		return flush;
	}

	public void setFlush(Short flush) {
		this.flush = flush;
	}

	@Column(name = "straight", nullable = false)
	public Short getStraight() {
		return straight;
	}

	public void setStraight(Short straight) {
		this.straight = straight;
	}

	@Column(name = "three_kind", nullable = false)
	public Short getThreeKind() {
		return threeKind;
	}

	public void setThreeKind(Short threeKind) {
		this.threeKind = threeKind;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
