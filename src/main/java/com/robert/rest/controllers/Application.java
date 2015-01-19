package com.robert.rest.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@ImportResource() used to import a spring-config.xml
@EnableAutoConfiguration()
//@EnableAsync
//@EnableScheduling
@ComponentScan
@RestController
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class.getName());

	@Value("${app.displayMessage}")
	private String displayMessage;

	@Autowired
	private MessageSource applicationProperties;

	@Autowired
	Environment environment;

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);
		logger.info("Media Gateway started with embedded tomcat...");
	}


	@RequestMapping("/manage/sanity")
	ResponseEntity<?> sanity() {
		return new ResponseEntity<Object>(
				new Object() {
					@SuppressWarnings("unused")
					public String message = applicationProperties.getMessage("app.displayMessage", null,
							"lookup failed", null);
				}, HttpStatus.OK);
	}

	@RequestMapping("/manage/profiles")
	ResponseEntity<?> envprops() {
		return new ResponseEntity<Object>(
				new Object() {
					@SuppressWarnings("unused")
					public String[] activeProfiles = environment.getActiveProfiles();
				}, HttpStatus.OK);
	}


	@RequestMapping("/manage/errortest")
	ResponseEntity<?> errortest() {
		try{
			throw new RuntimeException();
		}
		catch (RuntimeException e) {
			logger.error("This is a test of the handlers for a runtime exception.", e);
		}
		return new ResponseEntity<Object>(
				new Object() {
					@SuppressWarnings("unused")
					public String result = "Test error was logged";
				}, HttpStatus.OK);
	}
}