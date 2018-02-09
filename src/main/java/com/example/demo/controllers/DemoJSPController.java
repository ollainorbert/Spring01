package com.example.demo.controllers;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoJSPController {
	private final static String ROUTING_ROOT = "/";
	private final static String ROUTING_INFORMATION = "/information";
	
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
		System.out.println(logger.isDebugEnabled()); // mindig false
		System.out.println(logger.isTraceEnabled()); // mindig false
		
		System.out.println(logger.isErrorEnabled()); // mindig true
		//System.out.println(logger.isFatalEnabled()); log4j-nel van, slf4j-nel nincs // mindig true
		System.out.println(logger.isInfoEnabled());	// mindig true
		System.out.println(logger.isWarnEnabled()); // mindig true
		
		return "index";
	}
	
	@RequestMapping(ROUTING_INFORMATION)
	public String information() {
		logger.info("ROUTE: Information");
		return "information";
	}
}
