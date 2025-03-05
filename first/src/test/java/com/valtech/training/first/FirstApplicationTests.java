package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
class FirstApplicationTests {
	
	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;
	
	

	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 5, 20));
	}
	
	@Test
	void questionService() {
		assertEquals(6, questionService.countByTopic("GK"));
		assertEquals(6, questionService.countByTopic("Java"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("Java","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java","interface"));
		
		assertEquals(5, questionService.findAllByTopic("GK", 0, 5).size());
		assertEquals(1, questionService.findAllByTopic("GK", 1, 5).size());
	}
	
	@BeforeEach
	void initData() {
		long count = questionService.count();
		if(count != 0) return;
		Question q =  questionService.saveQuestion(new Question("What is the color of Sky?",
				"Red", "Blue", "Green", "White", "Blue", "GK"));
		questionService.saveQuestion(new Question("What is the color of Mars?",
				"Red", "Blue", "Green", "White", "Red", "GK"));
		questionService.saveQuestion(new Question("What is the color of Moon?",
				"Red", "Blue", "Green", "White", "White", "GK"));
		questionService.saveQuestion(new Question("What is the color of Jupiter?",
				"Red", "Blue", "Green", "White", "Yellow", "GK"));
		questionService.saveQuestion(new Question("What is the color of Saturn?",
				"Red", "Blue", "Green", "White", "Blue", "GK"));
		questionService.saveQuestion(new Question("What is the color of Venus?",
				"Red", "Blue", "Green", "White", "White", "GK"));
		
		
		questionService.saveQuestion(new Question("What is the Super class of Exception?",
				"Object", "Exception", "Throwable", "Error", "Throwable", "Java"));
		questionService.saveQuestion(new Question("Which class is used to create Dynamic Strings?",
				"String", "DynamicString", "StringBuilder", "Builder", "StringBuilder", "Java"));
		questionService.saveQuestion(new Question("How many methods are there in Marker Interface?",
				"None", "One", "Two", "Three", "None", "Java"));
		questionService.saveQuestion(new Question("How many methods are there in Functional Interface?",
				"None", "One", "Two", "Three", "One", "Java"));
		questionService.saveQuestion(new Question("Can an Interface have private methods?",
				"Yes", "No", "May be", "No methods can be there in an interface", "Yes", "Java"));
		questionService.saveQuestion(new Question("Which subclass of Exception is not checked by the Compliler?",
				"Exception", "Error", "RuntimeException", "None", "RuntimeException", "Java"));
		
		
	}

}
