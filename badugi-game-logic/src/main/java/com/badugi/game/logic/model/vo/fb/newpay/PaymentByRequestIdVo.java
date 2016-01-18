package com.badugi.game.logic.model.vo.fb.newpay;

public class PaymentByRequestIdVo {

	private PaymentVo data[];
	private Paging paging;
	public PaymentVo[] getData() {
		return data;
	}
	public void setData(PaymentVo[] data) {
		this.data = data;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	
}
