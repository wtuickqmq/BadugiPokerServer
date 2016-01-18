package com.badugi.game.logic.model.vo.fb;

public class CurrencyVo {
	private String user_currency;
	private Double currency_exchange;
	private Double currency_exchange_inverse;
	private Double usd_exchange;
	private Double usd_exchange_inverse;
	private Double currency_offset;
	
	public String getUser_currency() {
		return user_currency;
	}
	public void setUser_currency(String userCurrency) {
		user_currency = userCurrency;
	}
	public Double getCurrency_exchange() {
		return currency_exchange;
	}
	public void setCurrency_exchange(Double currencyExchange) {
		currency_exchange = currencyExchange;
	}
	public Double getCurrency_exchange_inverse() {
		return currency_exchange_inverse;
	}
	public void setCurrency_exchange_inverse(Double currencyExchangeInverse) {
		currency_exchange_inverse = currencyExchangeInverse;
	}
	public Double getCurrency_offset() {
		return currency_offset;
	}
	public void setCurrency_offset(Double currencyOffset) {
		currency_offset = currencyOffset;
	}
	public Double getUsd_exchange() {
		return usd_exchange;
	}
	public void setUsd_exchange(Double usdExchange) {
		usd_exchange = usdExchange;
	}
	public Double getUsd_exchange_inverse() {
		return usd_exchange_inverse;
	}
	public void setUsd_exchange_inverse(Double usdExchangeInverse) {
		usd_exchange_inverse = usdExchangeInverse;
	}

	
	
}
