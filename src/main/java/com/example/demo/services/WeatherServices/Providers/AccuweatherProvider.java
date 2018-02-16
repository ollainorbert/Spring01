package com.example.demo.services.WeatherServices.Providers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class AccuweatherProvider {

	private static final Logger logger = LoggerFactory.getLogger(AccuweatherProvider.class);

	private static final String API_KEY = "0GqAoATWgoqRTeVR0dsbdBf4QDJF2iJK";
	private static final String MAIN_PAGE = "http://dataservice.accuweather.com";

	// locations/v1/cities/search?apikey=0GqAoATWgoqRTeVR0dsbdBf4QDJF2iJK&q=Gyula
	private static final String PATTERN_SEARCH_FOR_CITY = "%s/locations/v1/cities/search?apikey=%s&q=%s";

	// currentconditions/v1/187176?apikey=0GqAoATWgoqRTeVR0dsbdBf4QDJF2iJK
	private static final String PATTERN_SEARCH_FOR_CURRENT_CONDITIONS = "%s/currentconditions/v1/%d?apikey=%s";

	// modellekkel inkabb

	public static long getCityIdFromCityName(String cityName) throws Exception {
		String requestString = String.format(PATTERN_SEARCH_FOR_CITY, MAIN_PAGE, API_KEY, cityName);
		String response = getResponse(requestString);

		String cityIdKeyInJSON = "Key";

		try {
			JSONObject jsonObject = getJSONObjectFromString(response, true);

			String cityIdInString = (String) jsonObject.get(cityIdKeyInJSON);
			logger.info("City ID in String: " + cityIdInString);

			long cityId = Long.parseLong(cityIdInString);
			logger.info("City ID in Long: " + cityId);

			return cityId;

		} catch (Exception e) {
			throw e;
		}
	}

	public static float getTheTemperature(long cityId) throws Exception {
		String requestString = String.format(PATTERN_SEARCH_FOR_CURRENT_CONDITIONS, MAIN_PAGE, cityId, API_KEY);
		String response = getResponse(requestString);

		String temperatureKey = "Temperature";
		String metricTemperatureKey = "Metric";
		String temperatureTypeValueKey = "Value";
		
		try {
			JSONObject jsonObject = getJSONObjectFromString(response, true);
			
			String temperature = jsonObject.get(temperatureKey).toString();	
			logger.info("Temperature String: " + temperature);
			
			String metricTemperature = getStringFromJSONObjectStringWithKey(temperature, metricTemperatureKey);
			logger.info("Metric temperature String: " + metricTemperature);
			
			String celsiusInString = getStringFromJSONObjectStringWithKey(metricTemperature, temperatureTypeValueKey);
			logger.info("Celsius String: " + celsiusInString);
			
			float celsius = Float.parseFloat(celsiusInString);
			logger.info("Celsius as number: " + celsius);
			
			return celsius;
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	private static String getResponse(String requestString) {
		logger.info("Request String sent: " + requestString);

		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(requestString, String.class);

		logger.info("Response: " + response);

		return response;
	}

	private static String formatJSONStringIfInAnAnotherArray(String jsonString) throws ParseException {
		String formattedJSONString = jsonString;
		if (jsonString.startsWith("[")) {
			formattedJSONString = formattedJSONString.substring(1, jsonString.length() - 1);
			formattedJSONString = formattedJSONString.substring(0, jsonString.length() - 2);
			logger.info("formatted JSON String: " + formattedJSONString);
		} else {
			logger.info("The JSON String is fine.");
		}

		return formattedJSONString;
	}

	private static JSONObject getJSONObjectFromString(String jsonString) throws ParseException {
		return getJSONObjectFromString(jsonString, false);
	}
	
	private static JSONObject getJSONObjectFromString(String jsonString, boolean isOuterArrayNotNecessary)
			throws ParseException {
		if (isOuterArrayNotNecessary) {
			jsonString = formatJSONStringIfInAnAnotherArray(jsonString);
		}

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(jsonString);
			JSONObject jsonObject = (JSONObject) obj;
			return jsonObject;
		} catch (ParseException e) {
			throw e;
		}
	}
	
	private static String getStringFromJSONObjectStringWithKey(String jsonObjectString, String key) throws ParseException {
		JSONObject tempObject = getJSONObjectFromString(jsonObjectString);
		String result = tempObject.get(key).toString();		
		return result;
	}

}
