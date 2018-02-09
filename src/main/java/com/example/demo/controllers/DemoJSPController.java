package com.example.demo.controllers;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.loggers.LoggerLevelChecker;

@Controller
public class DemoJSPController {
	private DemoJSPController() {
		LoggerLevelChecker.LogLoggerLevels(logger);
	}
	
	private static final String ROUTING_ROOT = "/";
	private static final String ROUTING_INFORMATION = "/information";
	//private static final Logger logger = LogManager.getLogger(DemoJSPController.class);
	private static final Logger logger = LoggerFactory.getLogger(DemoJSPController.class);
	
	public static String GetRoutingRoot() {
		return ROUTING_ROOT;
	}
	
	public static String GetRoutingInformation() {
		return ROUTING_INFORMATION;
	}
	
	@RequestMapping(ROUTING_ROOT)
	public String index() {
		logger.error("ROUTE: Root");
		return "index";
	}
	
	@RequestMapping(ROUTING_INFORMATION)
	public String information() {
		logger.info("ROUTE: Information");
		return "information";
	}
}
