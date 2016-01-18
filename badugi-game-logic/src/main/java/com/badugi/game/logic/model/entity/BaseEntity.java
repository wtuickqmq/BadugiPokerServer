package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.persistence.Transient;

public class BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = 7800857563510046654L;

	private int returnResult;

	private BaseEntity entity;

	private Integer targetpage;

	private Integer pagesize;

	private String userIds;

	private Map<String,Object> additionalInfo;
	
	private Integer orderType;
	private Integer orderValue;
	private String orderinfo;
	
	@Transient
	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	@Transient
	public BaseEntity getEntity() {
		return entity;
	}

	public void setEntity(BaseEntity entity) {
		this.entity = entity;
	}

	@Transient
	public int getReturnResult() {
		return returnResult;
	}

	public void setReturnResult(int returnResult) {
		this.returnResult = returnResult;
	}

	@Transient
	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	@Transient
	public Integer getTargetpage() {
		return targetpage;
	}

	public void setTargetpage(Integer targetpage) {
		this.targetpage = targetpage;
	}

	public int compareTo(Object o) {
		return 0;
	}

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Transient
	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	@Transient
	public Integer getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Integer orderValue) {
		this.orderValue = orderValue;
	}

	@Transient
	public String getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(String orderinfo) {
		this.orderinfo = orderinfo;
	}
	
	protected static Timestamp string2Timestamp(String dateStr){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    try {
	      Date date = sdf.parse(dateStr);
	      date.getTime();
	      cal.setTime(date);
	      return new Timestamp(cal.getTimeInMillis());
	    } catch (Exception e) {
	      e.printStackTrace();

	      cal.setTime(new Date()); }
	    return new Timestamp(cal.getTimeInMillis());
	}
	

}
