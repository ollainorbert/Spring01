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

import com.example.demo.loggers.LoggerLevelChecker;
import com.example.demo.models.Human;
import com.example.demo.repositories.HumanJdbcRepository;

@Controller
public class DemoJSPController {
	private DemoJSPController() {
		LoggerLevelChecker.LogLoggerLevels(logger);
	}
	
	private static final String ROUTING_ROOT = "/";
	private static final String ROUTING_INFORMATION = "/information";
	private static final String ROUTING_ADD = "/add";
	private static final String ROUTING_ADD_RESULT = "/addResult";
	private static final String ROUTING_FULL_LIST = "/listHumans";
	
	private static final String JSP_INDEX = "index";
	private static final String JSP_INFORMATION = "information";
	private static final String JSP_ADD = "add";
	private static final String JSP_ADD_RESULT = "addResult";
	private static final String JSP_FULL_LIST = "listHumans";
	
	//private static final Logger logger = LogManager.getLogger(DemoJSPController.class);
	private static final Logger logger = LoggerFactory.getLogger(DemoJSPController.class);
	
	@Autowired
	HumanJdbcRepository repo;
	
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
	
	public static String GetRoutingFullList() {
		return ROUTING_FULL_LIST;
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
	
	@RequestMapping(value =  ROUTING_ADD_RESULT, method = RequestMethod.POST)
	public ModelAndView addResult(@RequestParam(value="name") final String name) { 
		String resultId = "result";
		
		ModelAndView modelAndView = new ModelAndView(JSP_ADD_RESULT);
		if (name.trim().length() == 0) {
			modelAndView.addObject(resultId, "Empty name field!");
		}
		else {
			logger.info("Search in DB by name: " + name);
			Human human = repo.findByName(name);		
			if (human != null) {
				logger.info("This name is already in!");
			}
			else {
				logger.info("No match, insert start");
				Human newHuman = new Human(name);
				try {
					repo.insertWithAutoId(newHuman);
					logger.info("Insert done!");
					modelAndView.addObject(resultId, "Success!");
				}
				catch(Exception e) {
					logger.error("Insert failed: " + e.toString());
					modelAndView.addObject(resultId, "Error with the insert!");
				}	
			}
		}

        return modelAndView;
    }
	
	@RequestMapping(value = ROUTING_FULL_LIST, method = RequestMethod.GET)
	 public ModelAndView listHumans() {
    	ModelAndView modelAndView = new ModelAndView(JSP_FULL_LIST);
    	try {
    		modelAndView.addObject("humans", repo.findAll());
    	}
    	catch (Exception e) {
			return null;
		}
        return modelAndView;
    }

	
	
}
