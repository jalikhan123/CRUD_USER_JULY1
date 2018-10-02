/** @User.java Created on 29 September 2018 */
package com.user.enrollment.application.database.dao;

/**
 * User pojo class.
 * 
 * @author Lavanya
 */
public class User {
	/** userId. */
	private Long userId;
	
	/** userName. */
	private String userName;
	
	/** userAddress1. */
	private String userAddress1;
	
	/** userAddress2. */
	private String userAddress2;
	
	/** phoneNumber. */
	private String phoneNumber;
	
	/** emailAddress. */
	private String emailAddress;
	
	/**
	 * Getter method for userId.
	 * 
	 * @return userId long instance.
	 */
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * Setter method for userId.
	 * 
	 * @param userId long instance.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Getter method for userName.
	 * 
	 * @return userName string instance.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter method for userName.
	 * 
	 * @param userName string instance.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Getter method for userAddress1.
	 * 
	 * @return userAddress1 string instance.
	 */
	public String getUserAddress1() {
		return userAddress1;
	}
	
	/**
	 * Setter method for userAddress1.
	 * 
	 * @param userAddress1 string instance.
	 */
	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}
	
	/**
	 * Getter method for userAddress2.
	 * 
	 * @return userAddress2 string instance.
	 */
	public String getUserAddress2() {
		return userAddress2;
	}
	
	/**
	 * Setter method for userAddress2.
	 * 
	 * @param userAddress2 string instance.
	 */
	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}
	
	/**
	 * Getter method for phoneNumber.
	 * 
	 * @return phoneNumber string instance.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Setter method for phoneNumber.
	 * 
	 * @param phoneNumber string instance.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Getter method for emailAddress.
	 * 
	 * @return emailAddress string instance.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	
	/**
	 * Setter method for emailAddress.
	 * 
	 * @param emailAddress string instance.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
