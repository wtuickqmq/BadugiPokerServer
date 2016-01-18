package com.badugi.game.logic.model.vo.fb.newpay;

public class ActionsVo {

	private String type;
	private String status;
	private String currency;
	private String amount;
	private String time_created;
	private String time_updated;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTime_created() {
		return time_created;
	}
	public void setTime_created(String timeCreated) {
		time_created = timeCreated;
	}
	public String getTime_updated() {
		return time_updated;
	}
	public void setTime_updated(String timeUpdated) {
		time_updated = timeUpdated;
	}
	
}
