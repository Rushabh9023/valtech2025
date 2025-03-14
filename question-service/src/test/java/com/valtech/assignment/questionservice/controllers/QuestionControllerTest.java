package com.valtech.assignment.questionservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.assignment.questionservice.vos.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionControllerTest {

	@LocalServerPort
	private Integer port ;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void addQuestions() {
		String url = "http://localhost:"+port+"/api/v1/questions/";
		List ques = restTemplate.getForObject(url, List.class);
		if(ques.size() > 0) {
//			QuestionVO question1 = restTemplate.postForObject(url, new QuestionVO("What is the color of Sky?",
//					"Red", "Blue", "Green", "White", "Blue", "GK"), QuestionVO.class);
			QuestionVO question2 = restTemplate.postForObject(url, new QuestionVO("What is the color of Mars?",
					"Red", "Blue", "Green", "White", "Red", "GK"), QuestionVO.class);
			QuestionVO question3 = restTemplate.postForObject(url, new QuestionVO("What is the color of Moon?",
					"Red", "Blue", "Green", "White", "White", "GK"), QuestionVO.class);
			QuestionVO question4 = restTemplate.postForObject(url, new QuestionVO("What is the color of Jupiter?",
					"Red", "Blue", "Green", "White", "Yellow", "GK"), QuestionVO.class);
			QuestionVO question5 = restTemplate.postForObject(url, new QuestionVO("What is the color of Saturn?",
					"Red", "Blue", "Green", "White", "Blue", "GK"), QuestionVO.class);
			QuestionVO question6 = restTemplate.postForObject(url, new QuestionVO("What is the color of Venus?",
					"Red", "Blue", "Green", "White", "White", "GK"), QuestionVO.class);
			
			QuestionVO question7 = restTemplate.postForObject(url, new QuestionVO("What is the Super class of Exception?",
					"Object", "Exception", "Throwable", "Error", "Throwable", "Java"), QuestionVO.class);
			QuestionVO question8 = restTemplate.postForObject(url, new QuestionVO("Which class is used to create Dynamic Strings?",
					"String", "DynamicString", "StringBuilder", "Builder", "StringBuilder", "Java"), QuestionVO.class);
			QuestionVO question9 = restTemplate.postForObject(url, new QuestionVO("How many methods are there in Marker Interface?",
					"None", "One", "Two", "Three", "None", "Java"), QuestionVO.class);
			QuestionVO question10 = restTemplate.postForObject(url, new QuestionVO("How many methods are there in Functional Interface?",
					"None", "One", "Two", "Three", "One", "Java"), QuestionVO.class);
			QuestionVO question11 = restTemplate.postForObject(url, new QuestionVO("Can an Interface have private methods?",
					"Yes", "No", "May be", "No methods can be there in an interface", "Yes", "Java"), QuestionVO.class);
			QuestionVO question12 = restTemplate.postForObject(url, new QuestionVO("Which subclass of Exception is not checked by the Compliler?",
					"Exception", "Error", "RuntimeException", "None", "RuntimeException", "Java"), QuestionVO.class);
			
			
			QuestionVO question13 = restTemplate.postForObject(url, new QuestionVO("Which data structure is used for implementing recursion?",
					"Stack", "Queue", "List", "Array", "Stack", "DSA"), QuestionVO.class);
			QuestionVO question14 = restTemplate.postForObject(url, new QuestionVO("The data structure required to check whether an expression contains a balanced parenthesis is?",
					"Stack", "Queue", "List", "Array", "Stack", "DSA"), QuestionVO.class);
			QuestionVO question15 = restTemplate.postForObject(url, new QuestionVO("What is the value of the postfix expression 6 3 2 4 + – *?",
					"17", "-18", "22", "40", "-18", "DSA"), QuestionVO.class);
			QuestionVO question16 = restTemplate.postForObject(url, new QuestionVO("The data structure required for Breadth First Traversal on a graph is?",
					"Stack", "Queue", "List", "Array", "Queue", "DSA"), QuestionVO.class);
			QuestionVO question17 = restTemplate.postForObject(url, new QuestionVO("Which algorithm is used in the top tree data structure?",
					"Backtracking", "Divide and Conquer", "Branch", "Greedy", "Divide and Conquer", "DSA"), QuestionVO.class);
			QuestionVO question18 = restTemplate.postForObject(url, new QuestionVO("Which of the following is also known as Rope data structure?",
					"Linked List", "Array", "String", "Cord", "Cord", "DSA"), QuestionVO.class);
			
		}
	}

}
