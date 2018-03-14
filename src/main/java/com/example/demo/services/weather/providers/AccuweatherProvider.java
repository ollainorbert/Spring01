package com.example.demo.services.weather.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.loggers.DemoExceptionLogger;
import com.example.demo.models.AccuweatherCityModel;
import com.example.demo.models.AccuweatherCurrentConditionsModel;
import com.example.demo.models.UniversalWeatherModel;
import com.example.demo.services.weather.exceptions.CityNotFoundException;

@Component
public class AccuweatherProvider extends WeatherProviderBase {
	public AccuweatherProvider() {
		super(PROVIDER_NAME);
	}

	private static final Logger logger = LoggerFactory.getLogger(AccuweatherProvider.class);

	private static final String PROVIDER_NAME = "Accuweather";

	private static final String API_KEY = "5bAppZQBPrWCDGjlWLZ3czPL4YnVxMeu";
	private static final String MAIN_PAGE = "http://dataservice.accuweather.com";

	// locations/v1/cities/search?apikey=0GqAoATWgoqRTeVR0dsbdBf4QDJF2iJK&q=Gyula
	private static final String PATTERN_SEARCH_FOR_CITY = "%s/locations/v1/cities/search?apikey=%s&q=%s";

	// currentconditions/v1/187176?apikey=0GqAoATWgoqRTeVR0dsbdBf4QDJF2iJK
	private static final String PATTERN_SEARCH_FOR_CURRENT_CONDITIONS = "%s/currentconditions/v1/%d?apikey=%s";

	private static final String CITY_NOT_FOUND_STRING_VALUE = "[]";

	@Override
	public float getTemperatureByCityName(String cityName) throws Exception {
		long cityId = getCityIdFromCityName(cityName);
		float temperature = getTheTemperature(cityId);
		return temperature;
	}

	@Override
	public UniversalWeatherModel getUniversalWeatherModelByCityName(String cityName) throws Exception {
		long cityId = getCityIdFromCityName(cityName);
		float temperature = getTheTemperature(cityId);

		UniversalWeatherModel universalWeatherModel = new UniversalWeatherModel();
		universalWeatherModel.setCelsius(temperature);

		return universalWeatherModel;
	}

	private static long getCityIdFromCityName(String cityName) throws Exception {
		String requestString = String.format(PATTERN_SEARCH_FOR_CITY, MAIN_PAGE, API_KEY, cityName);

		try {
			String response = WeatherProviderBase.getSimpleResponse(requestString);
			if (response.equals(CITY_NOT_FOUND_STRING_VALUE)) {
				throw new CityNotFoundException();
			}

			AccuweatherCityModel cityModel = WeatherProviderBase
					.getResponseModelFromRequestStringFromArray(requestString, AccuweatherCityModel[].class);

			logger.info("City model: " + cityModel.toString());
			logger.info("City Key: " + cityModel.getKey());

			return Long.parseLong(cityModel.getKey());
		} catch (Exception e) {
			DemoExceptionLogger.exceptionLogger(logger, e);
			throw e;
		}
	}

	private static float getTheTemperature(long cityId) {
		String requestString = String.format(PATTERN_SEARCH_FOR_CURRENT_CONDITIONS, MAIN_PAGE, cityId, API_KEY);

		try {
			AccuweatherCurrentConditionsModel currentConditionsModel = WeatherProviderBase
					.getResponseModelFromRequestStringFromArray(requestString,
							AccuweatherCurrentConditionsModel[].class);
			logger.info("AccuweatherCurrentConditionsModel: " + currentConditionsModel.toString());

			logger.info(currentConditionsModel.getTemperature().getMetric().getValue());
			float celsius = Float.parseFloat(currentConditionsModel.getTemperature().getMetric().getValue());
			logger.info("Celsius " + celsius);

			return celsius;
		} catch (Exception e) {
			DemoExceptionLogger.exceptionLogger(logger, e);
			throw e;
		}
	}

}
