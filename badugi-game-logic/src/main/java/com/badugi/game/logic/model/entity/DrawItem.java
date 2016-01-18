package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="draw_item")
public class DrawItem extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String itemId;
	private String item;
	private String itemAlias;
	
	public DrawItem(){}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_id", unique = true, nullable = false)
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	@Column(name="item")
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	@Column(name="item_alias")
	public String getItemAlias() {
		return itemAlias;
	}
	public void setItemAlias(String itemAlias) {
		this.itemAlias = itemAlias;
	}
	
	
}
