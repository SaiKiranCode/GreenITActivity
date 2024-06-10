package com.user.demo.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.demo.model.Activity;
import com.user.demo.model.ActivityType;
import com.user.demo.model.User;

@Repository
public interface UserActivityRepository {

	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate);

	public Boolean deleteActivityById(Long Id);

	public User getUserbyUserName(String user);

	public List<Activity> getActivityById(Long activityId);

	public List<User> getUserByUserName(String user);

	public List<Activity> getActivityByDate(Date date);

	public Boolean putUsertoDB(String user, String name, Long points);;

	public Long getTotalPointsByUser(String user);

	public Long getTotalDistanceByUser(String user);

	public Long getOverAllImpact();
	List<Activity> getActivityByUserId(int userId);
	public Long getUserIdByAcf2Id(String acf2_id);
	public List<ActivityType> getActivityTypes() ;
	
}
