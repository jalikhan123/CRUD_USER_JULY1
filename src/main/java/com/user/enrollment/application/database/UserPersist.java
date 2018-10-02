/** @UserPersist.java Created on 29 September 2018 */
package com.user.enrollment.application.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.enrollment.application.database.dao.User;

/**
 * User Persist class used to perform insert, update & delete user record from user table.
 * 
 * @author Lavanya
 */
@Transactional
@Repository
public class UserPersist {

	/** jdbcTemplate - JdbcTemplate instance. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** ADD_USER_QUERY. */
	private static final String ADD_USER_QUERY = "insert into user(userName, userAddress1, userAddress2, phoneNumber, emailAddress) "
			+ "values (?, ?, ?, ?, ?)";
	
	/** UPDATE_USER_QUERY. */
	private static final String UPDATE_USER_QUERY = "update user set userName = ?, userAddress1 = ?, "
			+ "userAddress2 = ?, phoneNumber = ?, emailAddress = ? where userId = ?";
	
	/** DELETE_USER_QUERY. */
	private static final String DELETE_USER_QUERY = "delete from user where userId = ?";
	
	/**
	 * Method to add user object.
	 * 
	 * @param user instance.
	 * @return User instance.
	 */
	public User addUser(User user) {
		jdbcTemplate.update(ADD_USER_QUERY, new Object[] { user.getUserName(), user.getUserAddress1(),
				user.getUserAddress2(), user.getPhoneNumber(), user.getEmailAddress() });
		return user;
	}
	
	/**
	 * Method to update user object.
	 * 
	 * @param user instance.
	 * @return User instance.
	 */
	public User updateUser(User user) {
		jdbcTemplate.update(UPDATE_USER_QUERY, new Object[] { user.getUserName(), user.getUserAddress1(),
				user.getUserAddress2(), user.getPhoneNumber(), user.getEmailAddress(), user.getUserId() });
		return user;
	}
	
	/**
	 * Method to update user object.
	 * 
	 * @param UserId long instance.
	 */
	public void deleteUser(final Long userId) {
		jdbcTemplate.update(DELETE_USER_QUERY, new Object[] { userId });
	}
}
