package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class OrderInfoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4958285093526586642L;
	private Integer item_id;
	private String title;
	private String description;
	private String image_url;
	private String product_url;
	private Integer price;
	private String data;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String imageUrl) {
		image_url = imageUrl;
	}
	public String getProduct_url() {
		return product_url;
	}
	public void setProduct_url(String productUrl) {
		product_url = productUrl;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer itemId) {
		item_id = itemId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
