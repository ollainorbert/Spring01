package com.example.demo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Human;
import com.example.demo.repositories.HumanRepository;

@Service
public class HumanServiceImpl implements HumanService {

	@Autowired
	HumanRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(HumanServiceImpl.class);

	@Override
	public List<Human> findAll() {
		List<Human> humanList = repo.findAll();

		logger.info("START");
		logger.info("Human's number: " + humanList.size());
		for (int i = 0; i < humanList.size(); ++i) {
			logger.info(humanList.get(i).getName());
		}

		return humanList;
	}

	@Override
	public String save(Human human) {
		if (human.getName().trim().length() == 0) {
			return "Empty name field!";
		} else {
			logger.info("Search in DB by name: " + human.getName());
			List<Human> humanListFromDB = repo.findAll();
			for (int i = 0; i < humanListFromDB.size(); ++i) {
				if (humanListFromDB.get(i).getName().equals(human.getName())) {
					return "This name is already in!";
				}
			}

			logger.info("No match, insert start");
			try {
				repo.save(human);
				return "Success!";
			} catch (Exception e) {
				logger.error("Insert failed: " + e.toString());
				return "Error with the insert!";
			}
		}
	}

}
