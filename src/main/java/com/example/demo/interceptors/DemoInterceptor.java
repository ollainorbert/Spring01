package com.example.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(DemoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		// if returned false, we need to make sure 'response' is sent
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		long endTime = System.currentTimeMillis();
		long startTime = (Long) request.getAttribute("startTime");
		long elapsedTime = endTime - startTime;

		if(logger.isInfoEnabled()) {
			logger.info("Request method: " + request.getMethod());
			logger.info("Request URL: " + request.getRequestURL().toString());
			logger.info(String.format("%s: %d %s", "Elapsed Time between handle and exit", elapsedTime, "ms"));
		}	
	}
}
