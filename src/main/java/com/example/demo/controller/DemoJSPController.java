package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoJSPController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/information")
	public String helo() {
		return "information";
	}
}
