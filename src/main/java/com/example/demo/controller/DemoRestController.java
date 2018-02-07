package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	@RequestMapping(value = "/name")
	public String testGetName() {
		return "Norbert";
	}
	

}
