package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CfgGeneralLevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cfg_general_level")
public class CfgGeneralLevel extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short generalLevel;
	private Integer minExpLevel;

	// Constructors

	/** default constructor */
	public CfgGeneralLevel() {
	}

	/** full constructor */
	public CfgGeneralLevel(Short generalLevel, Integer minExpLevel) {
		this.generalLevel = generalLevel;
		this.minExpLevel = minExpLevel;
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

	@Column(name = "GeneralLevel", nullable = false)
	public Short getGeneralLevel() {
		return this.generalLevel;
	}

	public void setGeneralLevel(Short generalLevel) {
		this.generalLevel = generalLevel;
	}

	@Column(name = "MinExpLevel", nullable = false)
	public Integer getMinExpLevel() {
		return this.minExpLevel;
	}

	public void setMinExpLevel(Integer minExpLevel) {
		this.minExpLevel = minExpLevel;
	}

}