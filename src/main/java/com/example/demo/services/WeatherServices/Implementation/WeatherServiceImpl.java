package com.example.demo.services.WeatherServices.Implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.services.WeatherService;
import com.example.demo.services.WeatherServices.Config.WeatherProviderConfig;
import com.example.demo.services.WeatherServices.Exceptions.ProviderEnumNotExistException;
import com.example.demo.services.WeatherServices.Providers.AccuweatherProvider;
import com.example.demo.services.WeatherServices.Providers.DarkSkyProvider;

@Service
public class WeatherServiceImpl implements WeatherService {
	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	
	@Autowired
	private WeatherProviderConfig weatherConfig;
	
	@Autowired
	private AccuweatherProvider accuweatherProvider;
	
	@Autowired
	private DarkSkyProvider darkSkyProvider;

	@Override
	public float getTemperatureFromCity(String cityName) throws Exception {
		switch (weatherConfig.getWeatherConfig()) {
		case PROVIDER_1:
			return accuweatherProvider.getTemperatureByCityName(cityName);	
		case PROVIDER_2:
			return darkSkyProvider.getTemperatureByCityName(cityName);
		default:
			throw new ProviderEnumNotExistException();
		}
	}

}
