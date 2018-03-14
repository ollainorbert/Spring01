package com.example.demo.models;

public class UniversalWeatherModel {

	private static final String OPEN_WEATHER_MAP_ICON_PATTERN = "http://openweathermap.org/img/w/%s.png";

	private float celsius;
	private String iconStringId;

	public float getCelsius() {
		return celsius;
	}

	public void setCelsius(float celsius) {
		this.celsius = celsius;
	}

	public String getIconStringId() {
		return iconStringId;
	}

	public void setIconStringId(String iconStringId) {
		this.iconStringId = String.format(OPEN_WEATHER_MAP_ICON_PATTERN, iconStringId);
	}

}
