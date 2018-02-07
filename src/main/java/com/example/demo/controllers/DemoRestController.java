package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	private final static String ROUTING_NAME = "/name";
	private final static String MY_NAME = "Norbert";
	
	public static String GetRoutingName() {
		return ROUTING_NAME;
	}
	
	public String GetMyName() {
		return MY_NAME;
	}
	
	@RequestMapping(value = ROUTING_NAME)
	public String testGetName() {
		return MY_NAME;
	}
	
}
