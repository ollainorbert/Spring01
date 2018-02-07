package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoJSPController {
	public final static String ROUTING_ROOT = "/";
	public final static String ROUTING_INFORMATION = "/information";
	
	@RequestMapping(ROUTING_ROOT)
	public String index() {
		return "index";
	}
	
	@RequestMapping(ROUTING_INFORMATION)
	public String information() {
		return "information";
	}
}
