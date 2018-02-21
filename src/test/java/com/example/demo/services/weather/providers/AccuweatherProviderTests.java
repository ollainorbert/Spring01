package com.example.demo.services.weather.providers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.services.weather.exceptions.CityNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccuweatherProviderTests {

	@Autowired
	private AccuweatherProvider provider;

	@Before
	public void setup() throws Exception {
	}

	@Test(expected = CityNotFoundException.class)
	public void testCityNotFound() throws Exception {
		provider.getTemperatureByCityName("CityNameThatDoesn't Exist");
	}

}
