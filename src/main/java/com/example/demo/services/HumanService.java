package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Human;
import com.example.demo.services.HumanServices.Exceptions.HumanException;

public interface HumanService {

	public List<Human> findAll();
	
	public String save(Human human) throws HumanException;
}
