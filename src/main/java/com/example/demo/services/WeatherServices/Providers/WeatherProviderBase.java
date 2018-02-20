package com.example.demo.services.WeatherServices.Providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exceptionLoggers.DemoExceptionLogger;
import com.example.demo.models.WeatherModelBase;

public abstract class WeatherProviderBase {
	private static final Logger logger = LoggerFactory.getLogger(WeatherProviderBase.class);

	public abstract float getTemperatureByCityName(String cityName) throws Exception;

	protected static String getSimpleResponse(String requestString) {
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Request String will be send: " + requestString);
		
		try {
			String response = restTemplate.getForObject(requestString, String.class);
			logger.info("Response: " + response);
			return response;
		}
		catch (Exception e) {
			DemoExceptionLogger.exceptionLogger(logger, e);
			throw e;
		}		
	}
	
	protected static <T extends WeatherModelBase> T getResponseModelFromRequestString(String requestString,
			Class<T> typeParameterClass) {
		return WeatherProviderBase.getResponseModelFromReqString(requestString, typeParameterClass, null);
	}

	protected static <T extends WeatherModelBase> T getResponseModelFromRequestStringFromArray(String requestString,
			Class<T[]> typeParameterClass) {
		return WeatherProviderBase.getResponseModelFromReqString(requestString, null, typeParameterClass);
	}

	private static <T extends WeatherModelBase> T getResponseModelFromReqString(String requestString,
			Class<T> typeParameterClass, Class<T[]> typeParameterClassArray) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		logger.info("Request String will be send: " + requestString);

		try {
			if (typeParameterClass != null) {
				T weatherModel = restTemplate.getForObject(requestString, typeParameterClass);
				logger.info(weatherModel.toString());

				return weatherModel;
			} else {
				T[] arrayWeatherModel = restTemplate.getForObject(requestString, typeParameterClassArray);
				logger.info(arrayWeatherModel.toString());

				return arrayWeatherModel[0];
			}
		} catch (Exception e) {
			DemoExceptionLogger.exceptionLogger(logger, e);
			throw e;
		}
	}

}
