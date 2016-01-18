package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="draw_record")
public class DrawRecord extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 728053202252613214L;
	private String drawId;
	private String itemId;
	private Date drawTime;
	private String drawRacingcar;
	
	public DrawRecord(){}
	public DrawRecord(String drawId,String itemId,String drawRacingcar){
		this.drawId = drawId;
		this.drawRacingcar = drawRacingcar;
		this.itemId = itemId;
	}
	public DrawRecord(String itemId,Date drawTime){
		this.itemId = itemId;
		this.drawTime = drawTime;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "draw_id", unique = true, nullable = false)
	
	public String getDrawId() {
		return drawId;
	}
	public void setDrawId(String drawId) {
		this.drawId = drawId;
	}
	@Column(name = "item_id",nullable = true)
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
		
	@Column(name = "draw_time",nullable = true)
	public Date getDrawTime() {
		return drawTime;
	}
	public void setDrawTime(Date drawTime) {
		this.drawTime = drawTime;
	}
	@Column(name = "draw_racingcar",nullable = true)
	public String getDrawRacingcar() {
		return drawRacingcar;
	}
	public void setDrawRacingcar(String drawRacingcar) {
		this.drawRacingcar = drawRacingcar;
	}
	
	
}
