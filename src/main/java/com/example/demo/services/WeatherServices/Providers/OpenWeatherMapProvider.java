package com.example.demo.services.WeatherServices.Providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.models.OpenWeatherMapModel;

@Component
public class OpenWeatherMapProvider extends WeatherProviderBase {
	private static final Logger logger = LoggerFactory.getLogger(OpenWeatherMapProvider.class);
	
	private static final String API_KEY = "1262de4ef0393d2001d2178574fa6d3a";

	//http://api.openweathermap.org/data/2.5/weather?q=Gyula&appid=1262de4ef0393d2001d2178574fa6d3a
	private static final String REQUEST_PATTERN = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
	
	@Override
	public float getTemperatureByCityName(String cityName) throws Exception {
		String requestString = String.format(REQUEST_PATTERN, cityName, API_KEY);

		try {
			OpenWeatherMapModel model = getResponseModelFromRequestString(requestString, OpenWeatherMapModel.class);
			
			float celsius = model.getMain().getTempInCelsius();		
			return celsius;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		
	}

}
