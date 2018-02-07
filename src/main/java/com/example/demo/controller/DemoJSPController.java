package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoJSPController {
	@RequestMapping("/")
	public String welcome() {
		return "/WEB-INF/jsp/welcome.jsp";
	}
	
	@RequestMapping("/helo")
	public String helo() {
		return "/WEB-INF/jsp/helo.jsp";
	}

}
