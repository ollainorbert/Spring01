package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.WeatherService;
import com.example.demo.services.WeatherServices.Exceptions.WeatherException;

@Controller
public class WeatherController {
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

	private static final String ROUTING_WEATHER_INFO = "/weatherInfo";
	private static final String ROUTING_WEATHER_INFO_RESULT = "/weatherInfoResult";

	private static final String JSP_WEATHER_INFO = "weatherInfo";
	private static final String JSP_WEATHER_INFO_RESULT = "weatherInfoResult";

	private static final String POST_PARAM_CITY_NAME = "cityName";
	private static final String RESULT_ID = "result";
	private static final String ERROR_ID = "error";

	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping(value = ROUTING_WEATHER_INFO, method = RequestMethod.GET)
	public ModelAndView checkWeather() {
		ModelAndView modelAndView = new ModelAndView(JSP_WEATHER_INFO);
		return modelAndView;
	}
	
	@RequestMapping(value = ROUTING_WEATHER_INFO_RESULT, method = RequestMethod.POST)
	public ModelAndView weatherResult(@RequestParam(value = POST_PARAM_CITY_NAME) final String cityName) {
		ModelAndView modelAndView = new ModelAndView(JSP_WEATHER_INFO_RESULT);
		
		String resultMessage = "";
		try {
			float result = weatherService.getTemperatureFromCity(cityName);
			resultMessage = "" + result;
			modelAndView.addObject(RESULT_ID, result);
		}
		catch (WeatherException e) {
			resultMessage = e.getMessage();
			modelAndView.addObject(ERROR_ID, resultMessage);
		}
		catch (Exception e) {
			resultMessage = e.getMessage();
			modelAndView.addObject(ERROR_ID, "Error!");
		}
		logger.info("RESULT MESSAGE: " + resultMessage);
		
		return modelAndView;
	}
}
