/** @UserController.java Created on 29 September 2018 */
package com.user.enrollment.application.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.enrollment.application.database.UserPersist;
import com.user.enrollment.application.database.UserView;
import com.user.enrollment.application.database.dao.User;

/**
 * Rest Controller to serve user related operation
 * 
 * @author Lavanya
 */
@RestController
public class UserRestController {

	/**
	 * userView - UserView instance.
	 */
	@Autowired
	private UserView userView; 
	
	/**
	 * userPersist - UserPersist instance.
	 */
	@Autowired
	private UserPersist userPersist;
	
	
	/**
	 * getAllUser Method to fetch all User List.
	 * 
	 * @return Map instance.
	 */
	@RequestMapping("/getAllUser")
	public Map<String, List<User>> getAllUser() {
		final Map<String, List<User>> dataResult = new ConcurrentHashMap<String, List<User>>();
		dataResult.put("data", userView.getAllUser());
		return dataResult;
	}
	
	/**
	 * getAllUser Method to fetch all User List.
	 * 
	 * @return Map instance.
	 */
	@RequestMapping("/getUser")
	public User getUser(final @RequestParam("userId") Long userId) {
		User resUser = null;
		for(User user : userView.getAllUser()) {
			if(user.getUserId() == userId) {
				resUser = user;
				break;
			}
		}
		return resUser;
	}
	
	/**
	 * getAllUser Method to fetch all User List.
	 * 
	 * @return Map instance.
	 */
	@RequestMapping("/getUserSkeleton")
	public User getUserSkeleton() {
		final User user = new User();
		user.setUserName("TEST_USER");
		user.setUserAddress1("TEST_USER_ADDRESS1");
		user.setUserAddress2("TEST_USER_ADDRESS2");
		user.setPhoneNumber("123-123-1234");
		user.setEmailAddress("TEST@GMAIL.COM");
		return user;
	}
	
	/**
	 * addUser Method to add User into database.
	 * 
	 * @return Map instance.
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public User addUser(@RequestBody User userData) {
		userPersist.addUser(userData);
		return userData;
	}
	
	/**
	 * addUser Method to add User into database.
	 * 
	 * @return Map instance.
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public Map<String, String> updateUser(@RequestParam("userId") Long userId, @RequestBody User userData) {
		final Map<String, String> resultMap = new ConcurrentHashMap<String, String>();
		userPersist.updateUser(userData);
		resultMap.put("status", "succuess");
		resultMap.put("userId", userId.toString());
		return resultMap;
	}
	
	/**
	 * addUser Method to add User into database.
	 * 
	 * @return Map instance.
	 */
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	public Map<String, String> deleteUser(@RequestParam("userId") Long userId) {
		final Map<String, String> resultMap = new ConcurrentHashMap<String, String>();
		userPersist.deleteUser(userId);
		resultMap.put("status", "succuess");
		resultMap.put("userId", userId.toString());
		return resultMap;
	}
}
