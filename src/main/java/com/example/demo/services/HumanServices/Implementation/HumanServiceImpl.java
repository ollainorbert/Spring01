package com.example.demo.services.HumanServices.Implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Human;
import com.example.demo.repositories.HumanRepository;
import com.example.demo.services.HumanService;
import com.example.demo.services.HumanServices.Exceptions.EmptyFieldException;
import com.example.demo.services.HumanServices.Exceptions.HumanException;
import com.example.demo.services.HumanServices.Exceptions.InsertFailedException;
import com.example.demo.services.HumanServices.Exceptions.NameAlreadyTakenException;

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
	public String save(Human human) throws HumanException {
		if (human.getName().trim().length() == 0) {
			throw new EmptyFieldException();
		} else {
			human.setName(human.getName().trim());

			logger.info("Search in DB by name: " + human.getName());
			List<Human> humanListFromDB = repo.findAll();
			
			final String searchableName = human.getName();
			for(Human item : humanListFromDB) {
				if(item.getName().equals(searchableName)) {
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

}
