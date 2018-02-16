package com.example.demo.controllers;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Human;
import com.example.demo.services.HumanService;
import com.example.demo.services.WeatherService;
import com.example.demo.services.HumanServices.Exceptions.HumanException;
import com.example.demo.services.WeatherServices.Exceptions.WeatherException;

@Controller
public class DemoJSPController {
	private static final String ROUTING_ROOT = "/";
	private static final String ROUTING_INFORMATION = "/information";
	private static final String ROUTING_ADD = "/add";
	private static final String ROUTING_ADD_RESULT = "/addResult";
	private static final String ROUTING_FULL_LIST = "/listHumans";
	private static final String ROUTING_WEATHER_INFO = "/weatherInfo";
	private static final String ROUTING_WEATHER_INFO_RESULT = "/weatherInfoResult";
	
	private static final String JSP_INDEX = "index";
	private static final String JSP_INFORMATION = "information";
	private static final String JSP_ADD = "add";
	private static final String JSP_ADD_RESULT = "addResult";
	private static final String JSP_FULL_LIST = "listHumans";
	private static final String JSP_WEATHER_INFO = "weatherInfo";
	private static final String JSP_WEATHER_INFO_RESULT = "weatherInfoResult";
	
	private static final String POST_PARAM_ADD_RESULT = "name";
	private static final String POST_PARAM_CITY_NAME = "cityName";
	
	private static final String RESULT_ID = "result";
	private static final String ERROR_ID = "error";

	private static final Logger logger = LoggerFactory.getLogger(DemoJSPController.class);

	@Autowired
	private HumanService service;

	@Autowired
	private WeatherService weatherService;
	
	public static String GetRoutingRoot() {
		return ROUTING_ROOT;
	}

	public static String GetRoutingInformation() {
		return ROUTING_INFORMATION;
	}

	public static String GetRoutingAdd() {
		return ROUTING_ADD;
	}

	public static String GetRoutingAddResult() {
		return ROUTING_ADD_RESULT;
	}

	public static String GetRoutingListHumans() {
		return ROUTING_FULL_LIST;
	}

	public static String GetViewNameRoot() {
		return JSP_INDEX;
	}

	public static String GetViewNameInformation() {
		return JSP_INFORMATION;
	}

	public static String GetViewNameAdd() {
		return JSP_ADD;
	}

	public static String GetViewNameAddResult() {
		return JSP_ADD_RESULT;
	}

	public static String GetViewNameListHumans() {
		return JSP_FULL_LIST;
	}

	public static String GetPostParamAddResult() {
		return POST_PARAM_ADD_RESULT;
	}

	@RequestMapping(value = ROUTING_ROOT, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(JSP_INDEX);
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_INFORMATION, method = RequestMethod.GET)
	public ModelAndView information() {
		ModelAndView modelAndView = new ModelAndView(JSP_INFORMATION);
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_ADD, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView(JSP_ADD);
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_ADD_RESULT, method = RequestMethod.POST)
	public ModelAndView addResult(@RequestParam(value = POST_PARAM_ADD_RESULT) final String name) {	
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView(JSP_ADD_RESULT);

		Human human = new Human(name);

		String result = null;
		try {
			result = service.save(human);
			modelAndView.addObject(RESULT_ID, result);
		} catch (HumanException e) {
			result = e.getMessage();
			modelAndView.addObject(ERROR_ID, e.getMessage());
		}
		logger.info(result);

		return modelAndView;
	}

	@RequestMapping(value = ROUTING_FULL_LIST, method = RequestMethod.GET)
	public ModelAndView listHumans() {
		String errorHeader = "Error! Try again later!";
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView(JSP_FULL_LIST);

		try {
			modelAndView.addObject("humans", service.findAll());
		} catch (Exception e) {
			modelAndView.addObject(ERROR_ID, errorHeader);
		}

		return modelAndView;
	}
	
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
