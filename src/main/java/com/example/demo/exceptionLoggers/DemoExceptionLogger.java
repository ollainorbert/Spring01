package com.example.demo.exceptionLoggers;

import org.slf4j.Logger;
import org.springframework.web.client.HttpClientErrorException;

public class DemoExceptionLogger {
	private static final String STANDARD_ERROR_PREFIX = "Error: ";
	
	public static void exceptionLogger(Logger logger, Exception e) {
		logger.error(STANDARD_ERROR_PREFIX, e);	
	}
	
	public static void exceptionLoggerWithHttpClient(Logger logger, HttpClientErrorException e) {
		logger.error(STANDARD_ERROR_PREFIX, e.getResponseBodyAsString());
		logger.error(STANDARD_ERROR_PREFIX, e);
	}
}
