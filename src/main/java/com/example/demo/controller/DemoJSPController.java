package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoJSPController {
	private final static String JSP_PRE_FIX = "/WEB-INF/jsp/";
	private final static String JSP_POST_FIX = ".jsp";

	@RequestMapping("/")
	public String index() {
		return DemoJSPController.jSPURLFormatter("index");
	}
	
	@RequestMapping("/information")
	public String helo() {
		return DemoJSPController.jSPURLFormatter("information");
	}
	
	private static String jSPURLFormatter(String fileName) {
		return (JSP_PRE_FIX + fileName + JSP_POST_FIX);
	}
	
}
