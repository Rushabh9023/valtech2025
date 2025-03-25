package com.valtech.assignment.quizservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.assignment.quizservice.entities.Quiz;
import com.valtech.assignment.quizservice.services.QuestionClient;
import com.valtech.assignment.quizservice.vos.QuestionVO;
import com.valtech.assignment.quizservice.vos.QuizVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuizControllerTest {
	
	@LocalServerPort
	private Integer port ;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private QuestionClient qc;
	
//	@Test
//	public void test() {
//		
//		List<Long> ids = new ArrayList<Long>();
//		ids.add(2l);
//		ids.add(3l);
//		ids.add(4l);
//		ids.add(5l);
//		
//		System.out.println(qc.getQuestionsByIds(ids));
//	}
	
	
	
//	
//	@Test
//	public void testGenerateQuiz() {
//	    String url = "http://localhost:" + port + "/api/v1/quiz/";
//	    QuizVO quiz = restTemplate.postForObject(url, new QuizVO(0l,"GK", 3, null,null), QuizVO.class);
//
//	    assertNotNull(quiz);
//	    assertEquals("GK", quiz.topic());
//	    assertEquals(3, quiz.numberOfQuestions());
//	}
	
//	@Test
//	public void testGenerateQuiz1() {
//	    String url = "http://localhost:" + port + "/api/v1/quiz/";
//	    QuizVO quiz = restTemplate.postForObject(url, new QuizVO(0l,"Java", 3, null,null), QuizVO.class);
//
////	    assertNotNull(quiz);
////	    assertEquals("GK", quiz.topic());
////	    assertEquals(2, quiz.numberOfQuestions());
//	}

//	@Test
//	public void testGenerateQuiz2() {
//	    String url = "http://localhost:" + port + "/api/v1/quiz/";
//	    QuizVO quiz = restTemplate.postForObject(url, new QuizVO(0l,"GK", 5, null,null), QuizVO.class);
//
//	    assertNotNull(quiz);
//	    assertEquals("GK", quiz.topic());
//	    assertEquals(5, quiz.numberOfQuestions());
//	}
	
	 @Test
	    public void testGetQuestionsForQuiz() {
	        String url = "http://localhost:" + port + "/api/v1/quiz/4/questions";
	        List<QuestionVO> questions = Arrays.asList(restTemplate.getForObject(url, QuestionVO[].class));
             questions.forEach(q->System.out.println(q));

//              assertEquals(3, questions.size());
	    }
	 
//	 @Test
//	 public void testTakeQuiz() {
//		 String url = "http://localhost:" + port + "/api/v1/quiz/takequiz/1";
//		 List<String> answers = Arrays.asList("Blue", "White", "White");
////		 
////		 List<Long> ids = new ArrayList<Long>();
////		 ids.add(1l);
////		 ids.add(5l);
////		 ids.add(6l);
//		 QuizVO qvo = restTemplate.postForObject(url, answers, QuizVO.class);
//		 
//		 assertEquals(3, qvo.numberOfQuestions());
//
//	 }
	 
	 
//	 @Test
//	 public void testTakeQuiz2() {
//		 String url = "http://localhost:" + port + "/api/v1/quiz/takequiz/4";
//		 List<String> answers = Arrays.asList("Blue", "Red", "White","Blue","White");
//		 QuizVO qvo = restTemplate.postForObject(url, answers, QuizVO.class);
//		 assertEquals(4, qvo.numberOfQuestions());
//	 }

//	    @Test
//	    public void testGetQuestionsByTopicAndNumberOfQuestions() {
//	    	 String url = "http://localhost:" + port + "/api/v1/quiz/GK/3";
//	        List<QuestionVO> questions = Arrays.asList(restTemplate.getForObject(url, QuestionVO[].class)) ;
//
//	        assertNotNull(questions);
//	        assertEquals(3, questions.size());
//
//	        for (QuestionVO question : questions) {
//	            assertEquals("GK", question.topic());
//	        }
////	    	
//////	    	assertEquals(6, qc.getQuestionsByTopic("Java").size());
////	    	
//	    }

}
