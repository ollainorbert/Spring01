package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.loggers.LoggerLevelChecker;

@RestController
public class DemoRestController {
	private DemoRestController() {
		LoggerLevelChecker.LogLoggerLevels(logger);
	}

	private static final String ROUTING_NAME = "/name";
	private static final String MY_NAME = "Norbert";
	private static final Logger logger = LoggerFactory.getLogger(DemoRestController.class);

	public static String GetRoutingName() {
		return ROUTING_NAME;
	}

	public static String GetMyName() {
		return MY_NAME;
	}

	@RequestMapping(value = ROUTING_NAME)
	public String testGetName() {
		return MY_NAME;
	}

}
