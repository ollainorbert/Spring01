package com.example.demo.services.WeatherServices.Providers;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.AccuweatherCityModel;
import com.example.demo.models.WeatherModelBase;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


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

	protected static <T extends WeatherModelBase> T getResponseModelFromStringRequest(String requestString,
			Class<T> typeParamterClass, Class<T[]> typeParameterClassArray) throws ParseException, JsonParseException, JsonMappingException, IOException {
		return getResponseModelFromStringRequest(requestString, typeParamterClass, false, typeParameterClassArray);
	}
	
	protected static <T extends WeatherModelBase> T getResponseModelFromStringRequest(String requestString,
			Class<T> typeParamterClass) throws ParseException, JsonParseException, JsonMappingException, IOException {
		return getResponseModelFromStringRequest(requestString, typeParamterClass, false, null);
	}

	protected static <T extends WeatherModelBase> T getResponseModelFromStringRequest(String requestString,
			Class<T> typeParamterClass, boolean isThereAreAnUnesessaryArray, Class<T[]> testArray)
			throws ParseException, JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		logger.info("Request String will be send: " + requestString);

		if (!isThereAreAnUnesessaryArray) {
			T weatherModel = restTemplate.getForObject(requestString, typeParamterClass);
			return weatherModel;
		} else {
			try {
				String response = restTemplate.getForObject(requestString, String.class);

				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

				T[] listCities = objectMapper.readValue(response, testArray);
				logger.info(listCities.toString());
				
				return listCities[0];
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw e;
			}
		}
	}

	private static String formatJSONStringIfInAnAnotherArray(String jsonString) throws ParseException {
		if (jsonString.startsWith("[")) {
			jsonString = jsonString.substring(1, jsonString.length() - 1);
			jsonString = jsonString.substring(0, jsonString.length() - 2);
			logger.info("formatted JSON String: " + jsonString);
		} else {
			logger.info("The JSON String is fine.");
		}

		return jsonString;
	}

}
