package com.example.demo.services.WeatherServices.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.services.WeatherService;
import com.example.demo.services.WeatherServices.Config.WeatherProviderConfig;
import com.example.demo.services.WeatherServices.Exceptions.ProviderEnumNotExistException;
import com.example.demo.services.WeatherServices.Providers.AccuweatherProvider;
import com.example.demo.services.WeatherServices.Providers.OpenWeatherMapProvider;

@Service
public class WeatherServiceImpl implements WeatherService {
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
		cityName = cityName.toLowerCase();
		cityName.replace("á", "a");
		cityName.replace("é", "e");
		// ok enough for the demo lol
		
		return cityName;
	}

}
