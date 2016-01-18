package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_relation")
public class UserRelation extends BaseEntity implements java.io.Serializable {

	/**
	 * 陌生人(type=0)
	 */
	public static final Short TYPE_NO = 0;
	/**
	 * 牌友(type=1)
	 */
	public static final Short TYPE_FRIEND = 1;
	/**
	 * QQ好友(type=2)
	 */
	public static final Short TYPE_FBFRIEND = 2;
	
	/**
	 * 无标记(flag=0)
	 */
	public static final Short FLAG_NO = 0;
	/**
	 * 鱼(flag=1)
	 */
	public static final Short FLAG_FISH = 1;
	/**
	 * 敌人(flag=2)
	 */
	public static final Short FLAG_FOE = 2;
	/**
	 * 黑名单(flag=3)
	 */
	public static final Short FLAG_BKLIST = 3;
	
	
	// Fields

	private Integer id;
	private Long fbId;
	private Long objectFbId;
	private Short relationType;
	private Short relationFlag;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public UserRelation() {
	}

	public UserRelation(Short relationType, Short relationFlag){
		super();
		this.relationType = relationType;
		this.relationFlag = relationFlag;
	}

	
	/** full constructor */
	public UserRelation(Long fbId, Long objectFbId, Short relationType,
			Short relationFlag, Timestamp createTime) {
		this.fbId = fbId;
		this.objectFbId = objectFbId;
		this.relationType = relationType;
		this.relationFlag = relationFlag;
		this.createTime = createTime;
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

	@Column(name = "ObjectFbId", nullable = false)
	public Long getObjectFbId() {
		return this.objectFbId;
	}

	public void setObjectFbId(Long objectFbId) {
		this.objectFbId = objectFbId;
	}

	@Column(name = "RelationType", nullable = false)
	public Short getRelationType() {
		return this.relationType;
	}

	public void setRelationType(Short relationType) {
		this.relationType = relationType;
	}

	@Column(name = "RelationFlag", nullable = false)
	public Short getRelationFlag() {
		return this.relationFlag;
	}

	public void setRelationFlag(Short relationFlag) {
		this.relationFlag = relationFlag;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}