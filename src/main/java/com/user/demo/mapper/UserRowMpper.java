package com.user.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.user.demo.model.User;

public class UserRowMpper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User uderdetails = new User();
		uderdetails.setId(rs.getLong("id"));
		uderdetails.setUser_name(rs.getString("user_name"));
		uderdetails.setAcf2_id(rs.getString("acf2_id"));

		return uderdetails;

	}

}
