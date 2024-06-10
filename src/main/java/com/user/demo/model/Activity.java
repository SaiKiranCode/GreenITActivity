package com.user.demo.model;

import java.sql.Date;

public class Activity {

	private Long id;
	private Long User_id;
	private Long activityType_id;

	private Date date;
	private String details;

	private Float context_value;
	private Float impact;
	private String acf2_id;

	public String getAcf2_id() {
		return acf2_id;
	}

	public void setAcf2_id(String acf2_id) {
		this.acf2_id = acf2_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return User_id;
	}

	public void setUser_id(Long user_id) {
		User_id = user_id;
	}

	

	public Long getActivityType_id() {
		return activityType_id;
	}

	public void setActivityType_id(Long activityType_id) {
		this.activityType_id = activityType_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Float getContext_value() {
		return context_value;
	}

	public void setContext_value(Float context_value) {
		this.context_value = context_value;
	}

	public Float getImpact() {
		return impact;
	}

	public void setImpact(Float impact) {
		this.impact = impact;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", User_id=" + User_id + ", activityType_id=" + activityType_id + ", date=" + date
				+ ", details=" + details + ", context_value=" + context_value + ", impact=" + impact + ", acf2_id="
				+ acf2_id + "]";
	}

}
