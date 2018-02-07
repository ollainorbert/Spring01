package com.example.demo.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRestControllerTests {

	private DemoRestController demoRestController;
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.demoRestController = new DemoRestController();
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void goodRoutingName() throws Exception {
		this.mockMvc.perform(get(DemoRestController.GetRoutingName())).andExpect(status().isOk());
	}

	@Test
	public void nameEqualsMyName() throws Exception {
		this.mockMvc.perform(get(DemoRestController.GetRoutingName())).andExpect(jsonPath("$", is(this.demoRestController.GetMyName())));
	}

}
