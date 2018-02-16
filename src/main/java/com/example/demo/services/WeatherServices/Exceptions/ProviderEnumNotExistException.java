package com.example.demo.services.WeatherServices.Exceptions;

public class ProviderEnumNotExistException extends WeatherException {
	private static final long serialVersionUID = 2687637275716629956L;

	public ProviderEnumNotExistException() {
		super(MESSAGE);
	}
	
	private static final String MESSAGE = "Provider Enum not exist!";

}
