package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@RequestMapping(value = "/")
	public String test1() {
		return "Ures";
	}
	
	@RequestMapping(value = "/name")
	public String test2() {
		return "Norbert";
	}
    
}
