/** @UserView.java Created on 29 September 2018 */
package com.user.enrollment.application.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.enrollment.application.database.dao.User;

/**
 * User View class used to fetch records from User table.
 * 
 * @author Lavanya
 */
@Transactional
@Repository
public class UserView {

	/** jdbcTemplate - JdbcTemplate instance. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> getAllUser() {
		final String sqlQuery = "select userId, userName, userAddress1, userAddress2, phoneNumber, "
								+ "emailAddress from user order by userName asc";
		List<User> result = jdbcTemplate.query(sqlQuery, new UserListRowMapper());
		return result;

	}

	/**
	 * User list row mapper class.
	 * 
	 * @author Lavanya
	 */
	private class UserListRowMapper implements RowMapper<User> {
		/**
		 * Method to map row data into DAO user object.
		 */
		@Override
		public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			User user = new User();
			user.setUserId(resultSet.getLong(1));
			user.setUserName(resultSet.getString(2));
			user.setUserAddress1(resultSet.getString(3));
			user.setUserAddress2(resultSet.getString(4));
			user.setPhoneNumber(resultSet.getString(5));
			user.setEmailAddress(resultSet.getString(6));
			return user;
		}
	}
}
