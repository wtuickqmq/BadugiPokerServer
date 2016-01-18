package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GameAction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "game_action")
public class GameAction extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roundId;
	private Long fbId;
	private String nickName;
	private Short position;
	private Integer actionType;
	private Timestamp actionTime;
	private String actionContent;
	public static final Integer ACTIONTYPE_CHATLOG = 6;

	// Constructors

	/** default constructor */
	public GameAction() {
	}

	/** minimal constructor */
	public GameAction(Integer roundId, Long fbId, String nickName,
			Short position, Integer actionType, Timestamp actionTime) {
		this.roundId = roundId;
		this.fbId = fbId;
		this.nickName = nickName;
		this.position = position;
		this.actionType = actionType;
		this.actionTime = actionTime;
	}

	/** full constructor */
	public GameAction(Integer roundId, Long fbId, String nickName,
			Short position, Integer actionType, Timestamp actionTime,
			String actionContent) {
		this.roundId = roundId;
		this.fbId = fbId;
		this.nickName = nickName;
		this.position = position;
		this.actionType = actionType;
		this.actionTime = actionTime;
		this.actionContent = actionContent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "RoundID", nullable = false)
	public Integer getRoundId() {
		return this.roundId;
	}

	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "NickName", nullable = false, length = 50)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "Position", nullable = false)
	public Short getPosition() {
		return this.position;
	}

	public void setPosition(Short position) {
		this.position = position;
	}

	@Column(name = "ActionType", nullable = false)
	public Integer getActionType() {
		return this.actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	@Column(name = "ActionTime", nullable = false, length = 19)
	public Timestamp getActionTime() {
		return this.actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
	}

	@Column(name = "ActionContent", length = 4000)
	public String getActionContent() {
		return this.actionContent;
	}

	public void setActionContent(String actionContent) {
		this.actionContent = actionContent;
	}
	
	public String toJson() {
		String quotstr="";
		if(this.actionType==6||this.actionType==20){
			quotstr="\"";
		}
		return "{\"userId\":\"" + this.getFbId() + "\",\"userNick\":\"" + this.getNickName() + "\",\"position\":\"" + this.getPosition() + "\",\"actionType\":\"" + this.getActionType() + "\",\"actionContent\":"
				+quotstr+ this.getActionContent() +quotstr+ "}";
	}

}