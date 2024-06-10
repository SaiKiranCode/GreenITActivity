
package com.user.demo.model;

public class User {

	private Long id;
	private String user_name;

	private Float total_impact;
	private String acf2_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Float getTotal_impact() {
		return total_impact;
	}

	public void setTotal_impact(Float total_impact) {
		this.total_impact = total_impact;
	}

	public String getAcf2_id() {
		return acf2_id;
	}

	public void setAcf2_id(String acf2_id) {
		this.acf2_id = acf2_id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", total_impact=" + total_impact + ", acf2_id=" + acf2_id
				+ "]";
	}

}
