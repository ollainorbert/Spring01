package com.example.demo.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherMapModel extends WeatherModelBase {
	private static final Logger logger = LoggerFactory.getLogger(OpenWeatherMapModel.class);

	public class Weather {
		private long id;

		@JsonProperty("main")
		private String mainDescription;

		@JsonProperty("description")
		private String detailedDescription;

		@JsonProperty("icon")
		private String iconStringId;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getMainDescription() {
			return mainDescription;
		}

		public void setMainDescription(String mainDescription) {
			this.mainDescription = mainDescription;
		}

		public String getDetailedDescription() {
			return detailedDescription;
		}

		public void setDetailedDescription(String detailedDescription) {
			this.detailedDescription = detailedDescription;
		}

		public String getIconStringId() {
			return iconStringId;
		}

		public void setIconStringId(String iconStringId) {
			this.iconStringId = iconStringId;
		}
	}

	public class PrimaryInfo {
		private static final float KELVIN_CELSIUS_DIFFERENT = (float) 273.15;

		@JsonProperty("temp")
		private float temperatureInKelvin;

		public float getTemperatureInKelvin() {
			return temperatureInKelvin;
		}

		public void setTemperatureInKelvin(float TemperatureInKelvin) {
			this.temperatureInKelvin = TemperatureInKelvin;
		}

		public float getTempInCelsius() {
			logger.info("Kelvin: " + this.temperatureInKelvin);

			float celsius = (this.temperatureInKelvin - KELVIN_CELSIUS_DIFFERENT);
			logger.info("Celsius: " + celsius);

			return celsius;
		}
	}

	@JsonProperty("main")
	private PrimaryInfo primaryInfo;
	// private Weather weather;
	// private Weather[] weather;
	// private List<Weather> weather;
	// private ArrayList<Weather> weather;

	// @JsonUnwrapped
	// @JsonProperty("weather")
	private Weather weather;

	public PrimaryInfo getPrimaryInfo() {
		return primaryInfo;
	}

	public void setMain(PrimaryInfo primaryInfo) {
		this.primaryInfo = primaryInfo;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Object weatherAsObject) {
		Weather weather = new Weather();

		String weatherObjectAsString = weatherAsObject.toString();
		logger.info(weatherObjectAsString);

		weather.setIconStringId(haxTheIconId(weatherObjectAsString));
		logger.info(weather.getIconStringId());

		this.weather = weather;
	}

	// nem igazan akart az array-bol kijonni a cucc
	// hard code hax
	// abstractabb metodust, a keresendo string-el?
	private static String haxTheIconId(String someString) {
		for (int i = 0; i < someString.length() - 4; ++i) {
			char c1 = someString.charAt(i);
			char c2 = someString.charAt(i + 1);
			char c3 = someString.charAt(i + 2);
			char c4 = someString.charAt(i + 3);

			if ((c1 == 'i') && (c2 == 'c') && (c3 == 'o') && (c4 == 'n')) {

				String result = "";
				for (int j = (i + 5); j < someString.length() - 4; ++j) {
					logger.info("result char at: " + j + ", the char: " + someString.charAt(j));
					result += someString.charAt(j);

					if (someString.charAt(j + 1) == '}') {
						return result;
					}
				}

				logger.info("something went wrong.");
				break;
			}

		}

		return "13d";
	}

}
