package com.badugi.game.logic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Guess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guess")
public class Guess extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer guessId;
	private String hand1;
	private Double chance1;
	private String hand2;
	private Double chance2;
	private String hand3;
	private Double chance3;
	private String winHand;

	// Constructors

	/** default constructor */
	public Guess() {
	}

	/** full constructor */
	public Guess(String hand1, Double chance1, String hand2, Double chance2,
			String hand3, Double chance3, String winHand) {
		this.hand1 = hand1;
		this.chance1 = chance1;
		this.hand2 = hand2;
		this.chance2 = chance2;
		this.hand3 = hand3;
		this.chance3 = chance3;
		this.winHand = winHand;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "GuessId", unique = true, nullable = false)
	public Integer getGuessId() {
		return this.guessId;
	}

	public void setGuessId(Integer guessId) {
		this.guessId = guessId;
	}

	@Column(name = "Hand1", nullable = false, length = 20)
	public String getHand1() {
		return this.hand1;
	}

	public void setHand1(String hand1) {
		this.hand1 = hand1;
	}

	@Column(name = "Chance1", nullable = false, scale = 4)
	public Double getChance1() {
		return this.chance1;
	}

	public void setChance1(Double chance1) {
		this.chance1 = chance1;
	}

	@Column(name = "Hand2", nullable = false, length = 20)
	public String getHand2() {
		return this.hand2;
	}

	public void setHand2(String hand2) {
		this.hand2 = hand2;
	}

	@Column(name = "Chance2", nullable = false, scale = 4)
	public Double getChance2() {
		return this.chance2;
	}

	public void setChance2(Double chance2) {
		this.chance2 = chance2;
	}

	@Column(name = "Hand3", nullable = false, length = 20)
	public String getHand3() {
		return this.hand3;
	}

	public void setHand3(String hand3) {
		this.hand3 = hand3;
	}

	@Column(name = "Chance3", nullable = false, scale = 4)
	public Double getChance3() {
		return this.chance3;
	}

	public void setChance3(Double chance3) {
		this.chance3 = chance3;
	}

	@Column(name = "WinHand", nullable = false, length = 20)
	public String getWinHand() {
		return this.winHand;
	}

	public void setWinHand(String winHand) {
		this.winHand = winHand;
	}

}