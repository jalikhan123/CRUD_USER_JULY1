/** @MainApplication.java Created on 29 September 2018  */
package com.user.enrollment.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Main Application Class. Starting point for Spring boot application.
 * 
 * @author Lavanya
 */
@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

	/**
	 * Method to provide configuration.
	 * 
	 * @param application SpringApplicationBuilder instance.
	 * @return SpringApplicationBuilder instance.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApplication.class);
	}

	/**
	 * Main Method. Application start point.
	 * 
	 * @param args string array
	 * @throws Exception instance.
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplication.class, args);
	}

}