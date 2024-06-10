package com.user.demo.model;

public class ActivityType {

	private Long id;
	private String activity_type_name;

	private Boolean has_context;
	private String context_name;
	private Float multiplier;
	private String work_type;
	private String explanation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActivity_type_name() {
		return activity_type_name;
	}
	public void setActivity_type_name(String activity_type_name) {
		this.activity_type_name = activity_type_name;
	}
	public Boolean getHas_context() {
		return has_context;
	}
	public void setHas_context(Boolean has_context) {
		this.has_context = has_context;
	}
	public String getContext_name() {
		return context_name;
	}
	public void setContext_name(String context_name) {
		this.context_name = context_name;
	}
	public Float getMultiplier() {
		return multiplier;
	}
	public void setMultiplier(Float multiplier) {
		this.multiplier = multiplier;
	}
	public String getWork_type() {
		return work_type;
	}
	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@Override
	public String toString() {
		return "ActivityType [id=" + id + ", activity_type_name=" + activity_type_name + ", has_context=" + has_context
				+ ", context_name=" + context_name + ", multiplier=" + multiplier + ", work_type=" + work_type
				+ ", explanation=" + explanation + "]";
	}
	
	
}
