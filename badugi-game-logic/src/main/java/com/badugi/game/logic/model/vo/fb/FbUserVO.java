package com.badugi.game.logic.model.vo.fb;

import java.io.Serializable;

public class FbUserVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8995855219980365803L;
	private String country;
	private String locale;
	private Age age;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public Age getAge() {
		return age;
	}
	public void setAge(Age age) {
		this.age = age;
	}
	
	
}
