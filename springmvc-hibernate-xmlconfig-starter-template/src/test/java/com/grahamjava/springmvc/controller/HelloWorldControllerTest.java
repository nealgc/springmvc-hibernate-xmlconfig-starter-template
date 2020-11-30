package com.grahamjava.springmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HelloWorldControllerTest {

	private MockMvc mockMvc;
	
	/*
	 * We add the HelloWorldController to the standalone setup. 
	 * The MockMvcBuilders.standaloneSetup() allows to register one or more controllers 
	 * without the need to use the full WebApplicationContext
	 */

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
	}

	@Test
	public void testHelloWorldControllerPage() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk())
        .andExpect(view().name("helloworld"))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
}
