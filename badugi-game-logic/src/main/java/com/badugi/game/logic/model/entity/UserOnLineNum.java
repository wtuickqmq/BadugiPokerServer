package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;

/**
 * UserOnLineNum entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "game_car_count")
public class UserOnLineNum extends BaseEntity implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer num;
	private Integer version =  1;
	private Integer pf = 1;
	private Timestamp create_time;

	// Constructors

	/** default constructor */
	public UserOnLineNum() {
	}

	/** full constructor */
	public UserOnLineNum(Integer id, Integer num, Timestamp create_time) {
		this.id = id;
		this.create_time = create_time;
		this.num = num;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, length = 11)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "num", length = 11)
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "version", length = 4)
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "pf", length = 4)
	public Integer getPf() {
		return pf;
	}

	public void setPf(Integer pf) {
		this.pf = pf;
	}

	@Column(name = "create_time", nullable = false)
	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
}