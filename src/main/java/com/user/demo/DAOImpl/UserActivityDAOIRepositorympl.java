package com.user.demo.DAOImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.user.demo.DAO.UserActivityRepository;
import com.user.demo.mapper.ActivityRowMapper;
import com.user.demo.mapper.ActivityTypeRowMapper;
import com.user.demo.mapper.UserRowMpper;
import com.user.demo.model.Activity;
import com.user.demo.model.ActivityType;
import com.user.demo.model.User;

@Service
public class UserActivityDAOIRepositorympl implements UserActivityRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		int output = 0;
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			final String INSERT_MESSAGE_SQL = "insert into activity (id,User_id, ActivityType_id, date,details,context_value,impact) values(?,?,?,?,?,?,?);";

			output = jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(INSERT_MESSAGE_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, activity.getId());
				ps.setLong(2, activity.getUser_id());
				ps.setLong(3, activity.getActivityType_id());
				ps.setDate(4, activity.getDate());
				ps.setString(5, activity.getDetails());
				ps.setFloat(6, activity.getContext_value());
				ps.setFloat(7, activity.getImpact());

				return ps;
			}, keyHolder);

			long ActivtyId = (long) keyHolder.getKey();

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (output == 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Boolean deleteActivityById(Long Id) {
		final String DELETE_SQL = "Delete from " + "activity" + " where " + "id" + " =\"" + Id + "\"";

		int out_delete = jdbcTemplate.update(DELETE_SQL);
		System.out.println("Delete status  " + out_delete);
		return true;
	}

	@Override
	public User getUserbyUserName(String user) {

		User user1 = null;
		try {
			final String sql = "select * from User where user=?";
			user1 = (User) jdbcTemplate.query(sql, new UserRowMpper(), user);

		} catch (Exception e) {

		}

		return user1;

	}

	public List<Activity> getActivityById(Long activityId) {
		final String GET_ACTIVITY_BY_ACTIVITY_ID = "select * from activity where id=?";
		@SuppressWarnings("deprecation")
		List<Activity> activityList = jdbcTemplate.query(GET_ACTIVITY_BY_ACTIVITY_ID, new Object[] { activityId },
				new ActivityRowMapper());
		return activityList;
	}

	public List<User> getUserByUserName(String user) {
		final String GET_USER_BY_USER = "select * from User where user_name=?";
		@SuppressWarnings("deprecation")
		List<User> userList = jdbcTemplate.query(GET_USER_BY_USER, new Object[] { user }, new UserRowMpper());
		return userList;
	}

	@Override
	public List<Activity> getActivityByUserId(int userId) {
		final String GET_ACTIVITY_BY_USER = "select * from activity where User_id=?";
		@SuppressWarnings("deprecation")
		List<Activity> activityList = jdbcTemplate.query(GET_ACTIVITY_BY_USER, new Object[] { userId },
				new ActivityRowMapper());
		return activityList;
	}
	// select * from useractivity.activity where date ='2017-01-23' order by `date`
	// desc ;

	@Override
	public List<Activity> getActivityByDate(Date date) {
		final String GET_ACTIVITY_BY_DATE = "select * from activity where date=? order by date desc";
		@SuppressWarnings("deprecation")
		List<Activity> activityList = jdbcTemplate.query(GET_ACTIVITY_BY_DATE, new Object[] { date },
				new ActivityRowMapper());
		return activityList;
	}

	@Override
	public Boolean putUsertoDB(String user, String name, Long points) {
		try {
			final String sql = "INSERT INTO user (user,name,total_points) VALUES (?,?,?);";
			int output = jdbcTemplate.update(sql, user, name, points);
			if (output == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * @Override public Long getImpactByUser(String user) {
	 * 
	 * // select sum(points) from useractivity.activity where user='user'; final
	 * String sql = "select sum(points) from useractivity.activity where user=?";
	 * 
	 * @SuppressWarnings("deprecation") Long impactOfUser = (Long)
	 * jdbcTemplate.queryForObject(sql, new Object[] { user }, Long.class); return
	 * impactOfUser;
	 * 
	 * }
	 */
	@Override
	public Long getOverAllImpact() {
		final String sql = "select sum(points) from useractivity.activity";
		// @SuppressWarnings("deprecation")
		Long impactOfUser = (Long) jdbcTemplate.queryForObject(sql, Long.class);
		return impactOfUser;
	}

	@Override
	public Long getTotalPointsByUser(String user) {
		final String sql = "select sum(points) from useractivity.activity where user=?";
		@SuppressWarnings("deprecation")
		Long totalPointsOfUser = (Long) jdbcTemplate.queryForObject(sql, new Object[] { user }, Long.class);
		return totalPointsOfUser;

	}

	@Override
	public Long getTotalDistanceByUser(String user) {
		final String sql = "select sum(distance) from useractivity.activity where user=?";
		@SuppressWarnings("deprecation")
		Long totalDistanceOfUser = (Long) jdbcTemplate.queryForObject(sql, new Object[] { user }, Long.class);
		return totalDistanceOfUser;
	}

	@Override
	public Long getUserIdByAcf2Id(String acf2_id) {
		final String sql = "select id from useractivity.user where acf2_id=?";
		@SuppressWarnings("deprecation")
		Long acf2_id_db = (Long) jdbcTemplate.queryForObject(sql, new Object[] { acf2_id }, Long.class);
		return acf2_id_db;
	}
	@Override
	public List<ActivityType> getActivityTypes() {
	    final String GET_ACTIVITY_TYPE = "select * from useractivity.ActivityType ";
	    @SuppressWarnings("deprecation")
	    List<ActivityType> activityType_List = jdbcTemplate.query(GET_ACTIVITY_TYPE, new ActivityTypeRowMapper());
	    return activityType_List;
	}
}
