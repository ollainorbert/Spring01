package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoJSPController {
	private final static String ROUTING_ROOT = "/";
	private final static String ROUTING_INFORMATION = "/information";
	
	public static String GetRoutingRoot() {
		return ROUTING_ROOT;
	}
	
	public static String GetRoutingInformation() {
		return ROUTING_INFORMATION;
	}
	
	@RequestMapping(ROUTING_ROOT)
	public String index() {
		return "index";
	}
	
	@RequestMapping(ROUTING_INFORMATION)
	public String information() {
		return "information";
	}
}
