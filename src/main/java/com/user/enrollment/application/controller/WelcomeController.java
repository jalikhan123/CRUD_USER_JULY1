/** @WelcomeController.java Created on 29 September 2018 */
package com.user.enrollment.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Welcome controller class used to show welcome page for User Enrollment web
 * application.
 * 
 * @author Lavanya
 */
@Controller
public class WelcomeController {

	/**
	 * getAllUser Method to fetch all User List.
	 * 
	 * @return Map instance.
	 */
	@RequestMapping("/")
	public String showUserEnrollmentPage() {
		return "user/showUserEnrollment";
	}
}
