package com.example.demo.services.human.impl;

import java.util.List;
//import org.springframework.util.StringUtils;
//import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Human;
import com.example.demo.repositories.HumanRepository;
import com.example.demo.services.HumanService;
import com.example.demo.services.human.exceptions.EmptyFieldException;
import com.example.demo.services.human.exceptions.HumanException;
import com.example.demo.services.human.exceptions.InsertFailedException;
import com.example.demo.services.human.exceptions.NameAlreadyTakenException;

@Service
public class HumanServiceImpl implements HumanService {

	@Autowired
	HumanRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(HumanServiceImpl.class);

	@Override
	public List<Human> findAll() {
		List<Human> humanListFromDB = repo.findAll();

		logger.info("START");
		logger.info("Human's number: " + humanListFromDB.size());
		for (Human item : humanListFromDB) {
			logger.info(item.toString());
		}

		return humanListFromDB;
	}

	@Override
	public String save(Human human) throws HumanException {
		if ((human == null) || (!human.isValid())) {
			throw new EmptyFieldException();
		}

		logger.info("Search in DB by name: " + human.getName());
		List<Human> humanListFromDB = repo.findAll();

		final String searchableName = human.getName();
		for (Human item : humanListFromDB) {
			if (item.getName().equals(searchableName)) {
				throw new NameAlreadyTakenException();
			}
		}

		logger.info("No match, insert start");
		try {
			repo.save(human);
			return "Success!";
		} catch (Exception e) {
			logger.error("Insert failed: " + e.toString());
			throw new InsertFailedException();
		}
	}

}
