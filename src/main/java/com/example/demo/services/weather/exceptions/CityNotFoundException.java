package com.example.demo.services.weather.exceptions;

public class CityNotFoundException extends WeatherException {
	private static final long serialVersionUID = 3598627278293578102L;

	public CityNotFoundException() {
		super(MESSAGE);
	}

	private static final String MESSAGE = "City not found!";
	
}
