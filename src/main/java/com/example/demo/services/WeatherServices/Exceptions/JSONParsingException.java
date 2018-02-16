package com.example.demo.services.WeatherServices.Exceptions;

public class JSONParsingException extends WeatherException {
	private static final long serialVersionUID = -5261476448077456603L;

	public JSONParsingException() {
		super(MESSAGE);
	}
	
	private static final String MESSAGE = "Problem with the JSON Parsing!";

}
