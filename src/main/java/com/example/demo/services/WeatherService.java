package com.example.demo.services;

import com.example.demo.models.UniversalWeatherModel;

public interface WeatherService {

	public float getTemperatureFromCity(String cityName) throws Exception;

	public UniversalWeatherModel getUniversalWeatherModelFromCity(String cityName) throws Exception;
}
