package com.example.demo.services.WeatherServices.Exceptions;

public abstract class WeatherException extends Exception {
	private static final long serialVersionUID = 2633808503402668897L;

	public WeatherException(String msg) {
		super(msg);
	}
	
}
