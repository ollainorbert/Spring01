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
	private static final String ROUTING_ADD = "/add";
	private static final String ROUTING_ADD_RESULT = "/addResult";
	private static final String ROUTING_FULL_LIST = "/fullList";
	private static final String ROUTING_FULL_LIST_TAG_LIB = "/fullListTagLib";
	
	private static final String JSP_INDEX = "index";
	private static final String JSP_INFORMATION = "information";
	private static final String JSP_ADD = "add";
	private static final String JSP_ADD_RESULT = "addResult";
	private static final String JSP_FULL_LIST = "fullList";
	private static final String JSP_FULL_LIST_TAG_LIB = "fullListTagLib";
	
	//private static final Logger logger = LogManager.getLogger(DemoJSPController.class);
	private static final Logger logger = LoggerFactory.getLogger(DemoJSPController.class);
	
	public static String GetRoutingRoot() {
		return ROUTING_ROOT;
	}
	
	public static String GetRoutingInformation() {
		return ROUTING_INFORMATION;
	}
	
	public static String GetRoutingAdd() {
		return ROUTING_ADD;
	}
	
	public static String GetRoutingAddResult() {
		return ROUTING_ADD_RESULT;
	}
	
	public static String GetRoutingFullList() {
		return ROUTING_FULL_LIST;
	}
	
	public static String GetRoutingFullListTagLib() {
		return ROUTING_FULL_LIST_TAG_LIB;
	}
	
	@RequestMapping(ROUTING_ROOT)
	public String index() {
		return JSP_INDEX;
	}
	
	@RequestMapping(ROUTING_INFORMATION)
	public String information() {
		return JSP_INFORMATION;
	}
	
	@RequestMapping(ROUTING_ADD)
	public String add() {
		return JSP_ADD;
	}
	
	@RequestMapping(ROUTING_ADD_RESULT)
	public String addResult() {
		return JSP_ADD_RESULT;
	}
	
	@RequestMapping(ROUTING_FULL_LIST)
	public String fullList() {
		return JSP_FULL_LIST;
	}
	
	@RequestMapping(ROUTING_FULL_LIST_TAG_LIB)
	public String fullListTagLib() {
		return JSP_FULL_LIST_TAG_LIB;
	}
}
