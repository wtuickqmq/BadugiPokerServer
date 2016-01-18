package com.badugi.game.logic.model.vo.fb.newpay;

public class PaymentVo {
	
	private String id;
	private UserVo user;
	private ApplicationVo application;
	private ActionsVo actions[];
	private RefundableAmountVo refundable_amount;
	private ItemsVo items[];
	private String request_id;
	private String country;
	private String created_time;
	private String test;
	private String fraud_status;
	private String payout_foreign_exchange_rate;
	private DisputesVo disputes[];
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserVo getUser() {
		return user;
	}
	public void setUser(UserVo user) {
		this.user = user;
	}
	public ApplicationVo getApplication() {
		return application;
	}
	public void setApplication(ApplicationVo application) {
		this.application = application;
	}
	public ActionsVo[] getActions() {
		return actions;
	}
	public void setActions(ActionsVo[] actions) {
		this.actions = actions;
	}
	public RefundableAmountVo getRefundable_amount() {
		return refundable_amount;
	}
	public void setRefundable_amount(RefundableAmountVo refundableAmount) {
		refundable_amount = refundableAmount;
	}
	public ItemsVo[] getItems() {
		return items;
	}
	public void setItems(ItemsVo[] items) {
		this.items = items;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String createdTime) {
		created_time = createdTime;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getFraud_status() {
		return fraud_status;
	}
	public void setFraud_status(String fraudStatus) {
		fraud_status = fraudStatus;
	}
	public String getPayout_foreign_exchange_rate() {
		return payout_foreign_exchange_rate;
	}
	public void setPayout_foreign_exchange_rate(String payoutForeignExchangeRate) {
		payout_foreign_exchange_rate = payoutForeignExchangeRate;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String requestId) {
		request_id = requestId;
	}
	public DisputesVo[] getDisputes() {
		return disputes;
	}
	public void setDisputes(DisputesVo[] disputes) {
		this.disputes = disputes;
	}
	
	
}
