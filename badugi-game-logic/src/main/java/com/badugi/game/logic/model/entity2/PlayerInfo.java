package com.badugi.game.logic.model.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name = "t_player", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class PlayerInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name; 

	public PlayerInfo() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false, updatable = true, length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
