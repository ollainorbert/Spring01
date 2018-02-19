package com.example.demo.services.WeatherServices.Providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public abstract class WeatherProviderBase {
	private static final Logger logger = LoggerFactory.getLogger(WeatherProviderBase.class);

	public abstract float getTemperatureByCityName(String cityName) throws Exception;

	protected static String getResponseFromStringRequest(String requestString) {
		logger.info("Request String sent: " + requestString);

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(requestString, String.class);

		logger.info("Response: " + response);

		return response;
	}

}