package com.valtech.assignment.quizservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.assignment.quizservice.vos.QuestionVO;

@Component
public class QuestionClient {
	
	String url =  "http://localhost:9040/api/v1/questions/";
	
	public List<QuestionVO> getQuestionsByTopic(String topic){
		RestTemplate temp = new RestTemplate();
		String url1 = url+"topic/"+topic;
		List<QuestionVO> allQuestions =  Arrays.asList(temp.getForObject(url1, QuestionVO[].class));
		
		return allQuestions;
		
	}
	 public List<QuestionVO> getQuestionsByIds(List<Long> questionIds) {
	        RestTemplate temp = new RestTemplate();
	        String url2 = url + "ids/" + questionIds.stream().map(String::valueOf).collect(Collectors.joining(","));  
	        List<QuestionVO> questions = Arrays.asList(temp.getForObject(url2, QuestionVO[].class));

	        return questions;
	    }
	
//	 public List<QuestionVO> getQuestionsByIds(List<Long> questionIds) {
//	        RestTemplate temp = new RestTemplate();
//	        String url2 = url +"ids/"+questionIds;  
//	        List<QuestionVO> questions = Arrays.asList(temp.getForObject(url2, QuestionVO[].class));
//
//	        return questions;
//	    }

}
