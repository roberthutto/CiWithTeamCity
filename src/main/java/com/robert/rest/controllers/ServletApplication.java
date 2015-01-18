package com.robert.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class ServletApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(ServletApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("Media Gateway started in Servlet Container...");
		return application.sources(Application.class);
	}

}