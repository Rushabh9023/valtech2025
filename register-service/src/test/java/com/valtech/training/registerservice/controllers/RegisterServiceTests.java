package com.valtech.training.registerservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterServiceTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void testGetUserByValidId() throws Exception {
		mockMvc.perform(get("/api/v1/users/1")).andDo(print()).andExpect(content()
				.json("{'id':1,'name':'Rushabh','age':23,'mobile':'2345433',"
						+ "'email':'rushabh@gmail.com','kid':false,'subscriptionId':1}"))
		.andExpect(status().isOk());
	}
	
	@Test
	void testGetUserByInValidId() throws Exception {
		mockMvc.perform(get("/api/v1/users/3")).andDo(print()).andExpect(status().isNotFound());
	}

}
