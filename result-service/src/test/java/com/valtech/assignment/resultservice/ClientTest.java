package com.valtech.assignment.resultservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.assignment.resultservice.services.QuizClient;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ClientTest {
	

	
	@Autowired
	private QuizClient qc;
	

	@Test
	void test() {
		
		System.out.println(qc.getCorrectAnswersforQuiz(2l));
		System.out.println(qc.getSubmittedAnswers(2l));

	}

}
