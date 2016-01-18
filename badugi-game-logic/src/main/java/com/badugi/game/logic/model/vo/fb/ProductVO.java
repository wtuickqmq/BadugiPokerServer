package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class ProductVO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -5436234377764729724L;
	private Integer item_id;
	private String title;
	private String description;
	private String image_url;
	private String product_url;
	private Integer price;
	private Integer chips;
	private String data;
	private Double locprice;//本地货币数量值
	private String cur;//$
	private String cursign;//USD
	private Integer ishot;
	private Integer specialChips;
	private Double discount;
	private Double disprice;
	private Integer type;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer itemId) {
		item_id = itemId;
	}
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getChips() {
		return chips;
	}
	public void setChips(Integer chips) {
		this.chips = chips;
	}
	public Double getLocprice() {
		return locprice;
	}
	public void setLocprice(Double locprice) {
		this.locprice = locprice;
	}
	public String getCur() {
		return cur;
	}
	public void setCur(String cur) {
		this.cur = cur;
	}
	public String getCursign() {
		return cursign;
	}
	public void setCursign(String cursign) {
		this.cursign = cursign;
	}
	public Integer getIshot() {
		return ishot;
	}
	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}
	public Integer getSpecialChips() {
		return specialChips;
	}
	public void setSpecialChips(Integer specialChips) {
		this.specialChips = specialChips;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getDisprice() {
		return disprice;
	}
	public void setDisprice(Double disprice) {
		this.disprice = disprice;
	}

}
