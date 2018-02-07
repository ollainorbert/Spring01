package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	public final static String ROUTING_NAME = "/name";
	
	@RequestMapping(value = ROUTING_NAME)
	public String testGetName() {
		return "Norbert";
	}
	

}
