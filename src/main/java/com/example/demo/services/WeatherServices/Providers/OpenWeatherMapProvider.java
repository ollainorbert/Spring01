package com.example.demo.services.WeatherServices.Providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.exceptionLoggers.DemoExceptionLogger;
import com.example.demo.models.OpenWeatherMapModel;
import com.example.demo.services.WeatherServices.Exceptions.CityNotFoundException;

@Component
public class OpenWeatherMapProvider extends WeatherProviderBase {
	private static final Logger logger = LoggerFactory.getLogger(OpenWeatherMapProvider.class);

	private static final String API_KEY = "1262de4ef0393d2001d2178574fa6d3a";

	// http://api.openweathermap.org/data/2.5/weather?q=Gyula&appid=1262de4ef0393d2001d2178574fa6d3a
	private static final String REQUEST_PATTERN = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

	private static final String CITY_NOT_FOUND_IN_RESPNSE = "city not found";

	@Override
	public float getTemperatureByCityName(String cityName) throws Exception {
		String requestString = String.format(REQUEST_PATTERN, cityName, API_KEY);

		try {
			OpenWeatherMapModel model = getResponseModelFromRequestString(requestString, OpenWeatherMapModel.class);

			float celsius = model.getMain().getTempInCelsius();
			return celsius;
		} catch (HttpClientErrorException e) {
			DemoExceptionLogger.exceptionLoggerWithHttpClient(logger, e);

			if (e.getResponseBodyAsString().contains(CITY_NOT_FOUND_IN_RESPNSE)) {
				throw new CityNotFoundException();
			} else {
				throw e;
			}
		} catch (Exception e) {
			DemoExceptionLogger.exceptionLogger(logger, e);
			throw e;
		}

	}

}
