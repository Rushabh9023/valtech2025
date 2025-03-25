package com.valtech.training.leave.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest
class EmployeeClientTest {
	
	@Autowired
	EmployeeClient client;
	

	@Test
	void test() {
		assertEquals(1, client.getEmployeeAsManager(2).managerId());
		assertEquals(2, client.getEmployeeAsManager(3).managerId());
	}

}
