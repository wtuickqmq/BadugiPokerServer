package com.badugi.game.logic.model.vo.api.shop;

import java.io.Serializable;
import java.util.List;

import com.badugi.game.logic.model.vo.api.ResultVo;
import com.badugi.game.logic.model.vo.fb.ProductVO;

public class ProductListVo extends ResultVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5825374485423812384L;
	private Long code;
	private String desc;
	private List<ProductVO> products;
	
	
	
	public ProductListVo(Long code, String desc, List<ProductVO> products) {
		super();
		this.code = code;
		this.desc = desc;
		this.products = products;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<ProductVO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductVO> products) {
		this.products = products;
	}
	
	
}
