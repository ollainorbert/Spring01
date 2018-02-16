package com.example.demo.services.WeatherServices.Implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.services.WeatherService;
import com.example.demo.services.WeatherServices.Config.WeatherProviderConfig;
import com.example.demo.services.WeatherServices.Exceptions.ProviderEnumNotExistException;
import com.example.demo.services.WeatherServices.Exceptions.WeatherException;
import com.example.demo.services.WeatherServices.Providers.AccuweatherProvider;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	
	@Autowired
	private WeatherProviderConfig weatherConfig;

	@Override
	public float getTemperatureFromCity(String cityName) throws Exception {
		switch (weatherConfig.getWeatherConfig()) {
		case PROVIDER_1:
			return getTemperatureFromCity1(cityName);
		case PROVIDER_2:
			return getTemperatureFromCity2(cityName);
		default:
			throw new ProviderEnumNotExistException();
		}
	}

	private float getTemperatureFromCity1(String cityName) throws Exception {
		long cityId = 0;
		try {
			cityId = AccuweatherProvider.getCityIdFromCityName(cityName);
			return AccuweatherProvider.getTheTemperature(cityId);
		}
		catch (WeatherException e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}
	}

	private float getTemperatureFromCity2(String cityName) throws WeatherException {

		return 0;
	}

}
