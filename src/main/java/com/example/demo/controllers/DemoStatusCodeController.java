package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoStatusCodeController {

	@RequestMapping(value = "/200")
	public HttpStatus get200() {
		return HttpStatus.OK;
	}

	@RequestMapping(value = "/404")
	public HttpStatus get404() {
		return HttpStatus.NOT_FOUND;
	}

	@RequestMapping(value = "/500")
	public HttpStatus get500() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
