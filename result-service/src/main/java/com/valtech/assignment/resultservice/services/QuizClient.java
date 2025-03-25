package com.valtech.assignment.resultservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.assignment.resultservice.vos.QuestionVO;


@Component
public class QuizClient {
	
	String url =  "http://localhost:9050/api/v1/quiz/";
	
	public List<String> getCorrectAnswersforQuiz(long id) {
        RestTemplate temp = new RestTemplate();
        String url2 = url + id +"/questions" ;  
        List<QuestionVO> questions = Arrays.asList(temp.getForObject(url2, QuestionVO[].class));
       List<String> correctAnswers = questions.stream().map(q -> q.correctOption()).collect(Collectors.toList());

        return correctAnswers;
    }
	
	public List<String> getSubmittedAnswers(long id){
		
		 RestTemplate temp = new RestTemplate();
		 String url2 = url + "answers/"+id ;  
		 List<String> answers = temp.getForObject(url2, List.class);
		 return answers;
		
	}

}
