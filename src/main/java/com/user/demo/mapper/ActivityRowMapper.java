package com.user.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.user.demo.model.Activity;

public class ActivityRowMapper implements RowMapper<Activity> {

	@Override
	public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
		Activity activityDetails = new Activity();
		activityDetails.setId(rs.getLong("id"));
		// activityDetails.setUser(rs.getString("user"));
		activityDetails.setUser_id(rs.getLong("User_id"));
		activityDetails.setActivityType_id(rs.getLong("activityType_id"));
		activityDetails.setDetails(rs.getString("details"));
		activityDetails.setDate(rs.getDate("date"));
		activityDetails.setContext_value(rs.getFloat("context_value"));
		activityDetails.setImpact(rs.getFloat("impact"));

		return activityDetails;
	}

}
