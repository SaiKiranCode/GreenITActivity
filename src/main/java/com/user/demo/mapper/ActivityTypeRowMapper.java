package com.user.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.user.demo.model.ActivityType;

public class ActivityTypeRowMapper implements RowMapper<ActivityType> {

	@Override
	public ActivityType mapRow(ResultSet rs, int rowNum) throws SQLException {
		ActivityType activityTypeDetails = new ActivityType();
		activityTypeDetails.setId(rs.getLong("id"));
		activityTypeDetails.setActivity_type_name(rs.getString("activity_type_name"));
		activityTypeDetails.setHas_context(rs.getBoolean("has_context"));
		activityTypeDetails.setContext_name(rs.getString("context_name"));
		activityTypeDetails.setMultiplier(rs.getFloat("multiplier"));
		activityTypeDetails.setWork_type(rs.getString("work_type"));
		activityTypeDetails.setExplanation(rs.getString("explanation"));
		return activityTypeDetails;
	}

}
