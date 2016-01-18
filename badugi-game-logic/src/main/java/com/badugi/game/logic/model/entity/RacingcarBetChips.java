package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "racingcar_betchips")
public class RacingcarBetChips extends BaseEntity {
	private static final long serialVersionUID = -646429181659846227L;
	private Integer betChipId;
	private Integer chip;// 本次押注筹码
	private Long chipPlayer;// 押注玩家ID
	private String itemId;// 押注项
	private String racingcarId; // 游戏ID
	private Date chipTime;// 押注时间
	private Long dealerId;// 庄家ID

	public RacingcarBetChips() {
	}

	public RacingcarBetChips(Integer chip, Long chipPlayer, String itemId, String racingcarId, Long dealerId) {
		
		this.chip = chip;
		this.chipPlayer = chipPlayer;
		this.itemId = itemId;
		this.racingcarId = racingcarId;
		this.dealerId = dealerId;
		this.chipTime = new Date();
	}

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "betchip_id", unique = true, nullable = false)
	public Integer getBetChipId() {
		return betChipId;
	}

	public void setBetChipId(Integer betChipId) {
		this.betChipId = betChipId;
	}

	@Column(name = "chip")
	public Integer getChip() {
		return chip;
	}

	public void setChip(Integer chip) {
		this.chip = chip;
	}

	@Column(name = "chip_player")
	public Long getChipPlayer() {
		return chipPlayer;
	}

	public void setChipPlayer(Long chipPlayer) {
		this.chipPlayer = chipPlayer;
	}

	@Column(name = "chip_time")
	public Date getChipTime() {
		return chipTime;
	}

	public void setChipTime(Date chipTime) {
		this.chipTime = chipTime;
	}

	@Column(name = "dealer_id")
	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	@Column(name = "racingcar_id")
	public String getRacingcarId() {
		return racingcarId;
	}

	public void setRacingcarId(String racingcarId) {
		this.racingcarId = racingcarId;
	}

	@Column(name = "item_id")
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}
