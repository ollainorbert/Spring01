package com.example.demo.services.WeatherServices.Providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.models.AccuweatherCityModel;
import com.example.demo.models.AccuweatherCurrentConditionsModel;

@Component
public class AccuweatherProvider extends WeatherProviderBase {
	private static final Logger logger = LoggerFactory.getLogger(AccuweatherProvider.class);

	private static final String API_KEY = "5bAppZQBPrWCDGjlWLZ3czPL4YnVxMeu";
	private static final String MAIN_PAGE = "http://dataservice.accuweather.com";

	// locations/v1/cities/search?apikey=0GqAoATWgoqRTeVR0dsbdBf4QDJF2iJK&q=Gyula
	private static final String PATTERN_SEARCH_FOR_CITY = "%s/locations/v1/cities/search?apikey=%s&q=%s";

	// currentconditions/v1/187176?apikey=0GqAoATWgoqRTeVR0dsbdBf4QDJF2iJK
	private static final String PATTERN_SEARCH_FOR_CURRENT_CONDITIONS = "%s/currentconditions/v1/%d?apikey=%s";

	@Override
	public float getTemperatureByCityName(String cityName) throws Exception {
		long cityId = getCityIdFromCityName(cityName);
		float temperature = getTheTemperature(cityId);
		return temperature;
	}

	private static long getCityIdFromCityName(String cityName) {
		String requestString = String.format(PATTERN_SEARCH_FOR_CITY, MAIN_PAGE, API_KEY, cityName);

		try {
			AccuweatherCityModel cityModel = WeatherProviderBase
					.getResponseModelFromRequestStringFromArray(requestString, AccuweatherCityModel[].class);
			logger.info(cityModel.toString());
			logger.info(cityModel.getKey());

			return Long.parseLong(cityModel.getKey());
		} catch (Exception e) {
			logger.error(e.getMessage());
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

			if (currentConditionsModel.getTemperature() == null) {
				logger.error("TEMPERATURE NULL!!");
			}

			if (currentConditionsModel.getTemperature().getMetric() == null) {
				logger.error("METRIC NULL!!");
			}

			logger.info(currentConditionsModel.getTemperature().getMetric().getValue());
			float celsius = Float.parseFloat(currentConditionsModel.getTemperature().getMetric().getValue());
			logger.info("Celsius " + celsius);

			return celsius;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

}
