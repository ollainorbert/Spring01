package com.example.demo.services.weather.impl;

//import org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.services.WeatherService;
import com.example.demo.services.weather.config.WeatherProviderConfig;
import com.example.demo.services.weather.exceptions.ProviderEnumNotExistException;
import com.example.demo.services.weather.providers.AccuweatherProvider;
import com.example.demo.services.weather.providers.OpenWeatherMapProvider;

@Service
public class WeatherServiceImpl implements WeatherService {
	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

	@Autowired
	private WeatherProviderConfig weatherConfig;

	@Autowired
	private AccuweatherProvider accuweatherProvider;

	@Autowired
	private OpenWeatherMapProvider openWeatherMapProvider;

	@Override
	public float getTemperatureFromCity(String cityName) throws Exception {
		cityName = formatTheCityName(cityName);

		switch (weatherConfig.getWeatherConfig()) {
		case PROVIDER_1:
			return accuweatherProvider.getTemperatureByCityName(cityName);
		case PROVIDER_2:
			return openWeatherMapProvider.getTemperatureByCityName(cityName);
		default:
			throw new ProviderEnumNotExistException();
		}
	}

	private String formatTheCityName(String cityName) {
		logger.info("Raw city name: " + cityName);

		cityName = cityName.toLowerCase();
		logger.info("Raw city name, after lower cased: " + cityName);

		cityName = StringUtils.stripAccents(cityName);
		logger.info("City name, formed with stripAccents: " + cityName);

		// cityName.replace("á", "a");
		// cityName.replace("é", "e");
		// cityName.replace("ö", "o");
		// cityName.replace("ő", "o");
		// cityName.replace("ú", "u");
		// cityName.replace("ü", "u");
		// cityName.replace("ű", "u");
		// cityName.replace("é", "e");
		// ok enough for the demo lol
		// nincs ekezet a jsp oldalrol, szal felesleges

		logger.info("Totally formed city name, before return: " + cityName);
		return cityName;
	}

}
