package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccuweatherCityModel extends WeatherModelBase {
	///private long Version;
	
	@JsonProperty("Key")
	private String Key;
	
	@JsonProperty("LocalizedName")
	private String LocalizedName;
	
//	public long getVersion() {
//		return Version;
//	}
//	public void setVersion(long version) {
//		Version = version;
//	}
	
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	
	public String getLocalizedName() {
		return LocalizedName;
	}
	public void setLocalizedName(String localizedName) {
		LocalizedName = localizedName;
	}
	
	@Override
	public String toString() {
		return "City model; name : " + this.getLocalizedName() + " key: " + this.getKey();
	}
	
}
