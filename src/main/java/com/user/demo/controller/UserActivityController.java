package com.user.demo.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.demo.model.Activity;
import com.user.demo.model.ActivityType;
import com.user.demo.model.User;
import com.user.demo.service.UserActivityService;

@RestController
public class UserActivityController {

	@Autowired
	UserActivityService userActivityService;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostMapping(value = "/createActivity", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Map<String, String>> createActivity(@RequestBody Activity activitydata) {
		final Map<String, String> responseMap = new HashMap<>();

		boolean status_user = false;
		boolean status_activity = false;
		final Long UserId = userActivityService.getUserIdByAcf2Id(activitydata.getAcf2_id());
		if (UserId != null) {
			activitydata.setUser_id(UserId);
			status_activity = userActivityService.putActivitytoDB(activitydata, namedParameterJdbcTemplate);
			
			if(status_activity ==true) {
			responseMap.put("Status", "Success");}
			else {
				responseMap.put("Failed to insert Activity", "Activity not inserted");
			}
		} else {
			responseMap.put("Fail", "UserNotFund");
		}

		return new ResponseEntity<Map<String, String>>(responseMap, HttpStatus.OK);
	}

	@DeleteMapping("/activity/{id}")
	public String deleteActivity(@PathVariable("id") Long activityId) {

		boolean status = false;

		status = userActivityService.deleteActivityById(activityId);

		if (status == true) {

			return "Activity deleted Succesuffully ";
		} else {
			return "failure while deleting activity with ID " + activityId;
		}

	}

	@GetMapping("/getActivityByuserId/{useId}")
	public ResponseEntity<Map<String, List<Activity>>> getActivitiesAssignedForUser(@PathVariable final int useId) {
		final Map<String, List<Activity>> responseMap = new HashMap<>();
		final List<Activity> activityList = userActivityService.getActivityByUserId(useId);
		responseMap.put("activityList", activityList);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

	@GetMapping("/getActivityById/{activityId}")
	public ResponseEntity<Map<String, List<Activity>>> getActivitiesAssignedForId(@PathVariable final Long activityId) {
		final Map<String, List<Activity>> responseMap = new HashMap<>();
		final List<Activity> activityList = userActivityService.getActivityById(activityId);
		responseMap.put("activityList", activityList);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

	@GetMapping("/getUserByuserName/{userName}")
	public ResponseEntity<Map<String, List<User>>> getUserByUserName(@PathVariable final String user) {
		final Map<String, List<User>> responseMap = new HashMap<>();
		final List<User> userList = userActivityService.getUserByUserName(user);
		responseMap.put("userList", userList);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

	@GetMapping("/getActivityByDate/{date}")
	public ResponseEntity<Map<String, List<Activity>>> getActivityByDate(@PathVariable final Date date) {
		final Map<String, List<Activity>> responseMap = new HashMap<>();
		final List<Activity> activityList = userActivityService.getActivityByDate(date);
		responseMap.put("activityList", activityList);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

	@GetMapping("/getImpactByUser/{user}")
	public ResponseEntity<Map<String, Long>> getImpactByUser(@PathVariable final String user) {
		final Map<String, Long> responseMap = new HashMap<>();
		final Long impactOfUser = userActivityService.getImpactByUser(user);
		responseMap.put("Impact for user - " + user, impactOfUser);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

	@GetMapping("/getOverAllImpact")
	public ResponseEntity<Map<String, Long>> getOverAllImpact() {
		final Map<String, Long> responseMap = new HashMap<>();
		final Long impactOfAllUser = userActivityService.getOverAllImpact();
		responseMap.put("Over All impact of All users is - ", impactOfAllUser);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}
	
	@GetMapping("/getActivityTypes")
	public ResponseEntity<Map<String,  List<ActivityType>>> getActivityTypes() {
	    final Map<String,  List<ActivityType>> responseMap = new HashMap<>();
	    final List<ActivityType> activityTypeList= userActivityService.getActivityTypes();
	    responseMap.put("List of activityTypes- ", activityTypeList);
	    return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

}
