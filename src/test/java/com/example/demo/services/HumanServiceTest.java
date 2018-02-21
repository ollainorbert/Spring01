package com.example.demo.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.models.Human;
import com.example.demo.services.human.exceptions.EmptyFieldException;
import com.example.demo.services.human.exceptions.NameAlreadyTakenException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HumanServiceTest {

	@Autowired
	private HumanService humanService;
	
	@Test(expected = EmptyFieldException.class)
	public void saveTest_IfHumanNull() throws Exception {
		Human human = null;
		humanService.save(human);	
	}
	
	@Test(expected = EmptyFieldException.class)
	public void saveTest_IfHumanNameStringNull() throws Exception {
		Human human = new Human(null);
		humanService.save(human);
	}
	
	@Test(expected = EmptyFieldException.class)
	public void saveTest_IfHumanNameStringFullOfWhiteSpace() throws Exception {
		Human human = new Human("   ");
		humanService.save(human);
	}
	
	@Test(expected = NameAlreadyTakenException.class)
	public void saveTest_IfNameAlreadyTaken() throws Exception {
		Human human = new Human("testName");
		humanService.save(human);
		humanService.save(human);
	}
	
	
}
