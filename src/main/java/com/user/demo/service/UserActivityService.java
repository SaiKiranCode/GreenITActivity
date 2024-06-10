package com.user.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.user.demo.DAOImpl.UserActivityDAOIRepositorympl;
import com.user.demo.model.Activity;
import com.user.demo.model.ActivityType;
import com.user.demo.model.User;

@Service
public class UserActivityService {

	/*
	 * List<Activity> fetchStuydentlist();
	 * 
	 * Activity saveActivity(Activity activity); Activity updateActivity (Activity
	 * activity, Long activityid ); void deleteActivitybyId(Long activityid);
	 */

	@Autowired
	UserActivityDAOIRepositorympl userActivityDAOIRepositorympl;

	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return userActivityDAOIRepositorympl.putActivitytoDB(activity, namedParameterJdbcTemplate);
	}

	public boolean deleteActivityById(Long Id) {
		return userActivityDAOIRepositorympl.deleteActivityById(Id);
	}

	public User getUserbyUserName(String user) {
		// TODO Auto-generated method stub
		return userActivityDAOIRepositorympl.getUserbyUserName(user);
	}

	public List<Activity> getActivityById(Long activityId) {
		// TODO Auto-generated method stub
		return userActivityDAOIRepositorympl.getActivityById(activityId);
	}

	public List<User> getUserByUserName(String user) {
		return userActivityDAOIRepositorympl.getUserByUserName(user);
	}

	public List<Activity> getActivityByUserId(int userId) {
		return userActivityDAOIRepositorympl.getActivityByUserId(userId);
	}

	public List<Activity> getActivityByDate(Date date) {
		return userActivityDAOIRepositorympl.getActivityByDate(date);
	}

	public Boolean putUsertoDB(String user, String name, Long points) {
		return userActivityDAOIRepositorympl.putUsertoDB(user, name, points);

	}

	public Long getImpactByUser(String user) {
		Long totalImpactOfUser = null;

		Long ImpactFromPoints = (long) 0;
		Long ImpactfromDistance = (long) 0;

		Long totalPoints = userActivityDAOIRepositorympl.getTotalPointsByUser(user);
		Long totalDistance = userActivityDAOIRepositorympl.getTotalDistanceByUser(user);
		if (totalPoints != null) {
			ImpactFromPoints = (long) (totalPoints * 1.5);
			totalImpactOfUser = ImpactFromPoints;
		}

		if (totalDistance != null) {
			ImpactfromDistance = totalDistance * 1;
			totalImpactOfUser = ImpactfromDistance;

		}
		if (totalPoints != null && totalDistance != null) {
			totalImpactOfUser = ImpactFromPoints + ImpactfromDistance;
		}

		return totalImpactOfUser;

	}

	public Long getOverAllImpact() {
		return userActivityDAOIRepositorympl.getOverAllImpact();
	}

	public Long getUserIdByAcf2Id(String acf2_id) {
		return userActivityDAOIRepositorympl.getUserIdByAcf2Id(acf2_id);
	}
	public List<ActivityType> getActivityTypes() {

	    return userActivityDAOIRepositorympl.getActivityTypes();
	}
}
