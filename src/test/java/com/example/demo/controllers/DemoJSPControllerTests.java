package com.example.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJSPControllerTests {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void goodRoutingRoot() throws Exception {
		this.mockMvc.perform(get(DemoJSPController.GetRoutingRoot()))
        .andExpect(status().isOk())
        .andExpect(view().name(DemoJSPController.GetViewNameRoot()));
	}
	
	@Test
	public void goodRoutingInformation() throws Exception {
		this.mockMvc.perform(get(DemoJSPController.GetRoutingInformation()))
        .andExpect(status().isOk())
        .andExpect(view().name(DemoJSPController.GetViewNameInformation()));
	}
	
	@Test
	public void goodRoutingAdd() throws Exception {
		this.mockMvc.perform(get(DemoJSPController.GetRoutingAdd()))
        .andExpect(status().isOk())
        .andExpect(view().name(DemoJSPController.GetViewNameAdd()));
	}
	
	@Test
	public void goodRoutingAddResult() throws Exception {
		this.mockMvc.perform(post(DemoJSPController.GetRoutingAddResult()).param(DemoJSPController.GetPostParamAddResult(), "somethingThatIHopeNeverEverWillBeInTheDB"))
        .andExpect(status().isOk())
		.andExpect(view().name(DemoJSPController.GetViewNameAddResult()));
	}
	
	@Test
	public void goodRoutingFullList() throws Exception {
		this.mockMvc.perform(get(DemoJSPController.GetRoutingListHumans()))
        .andExpect(status().isOk())
        .andExpect(view().name(DemoJSPController.GetViewNameListHumans()));
	}
	


	
}
