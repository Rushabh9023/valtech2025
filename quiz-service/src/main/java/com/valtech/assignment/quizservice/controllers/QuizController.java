package com.valtech.assignment.quizservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.assignment.quizservice.services.QuizService;
import com.valtech.assignment.quizservice.vos.QuestionVO;
import com.valtech.assignment.quizservice.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
	
	 @Autowired
	 private QuizService quizService;  
	 
	 @PostMapping("/")
	    public QuizVO generateQuiz(@RequestBody QuizVO quizVO) {
	        return quizService.generateQuiz(quizVO);
	    }
	 
	 @GetMapping("/{topic}/{numOfQuestions}")
	 public List<QuestionVO> getQuestions(@PathVariable("topic") String topic, @PathVariable("numOfQuestions") int numOfQuestions){
		 return quizService.getQuestionsByTopicAndNumberOfQuestions(topic, numOfQuestions);
	 }
	 
	 @GetMapping("/{quizId}/questions")
	    public List<QuestionVO> getQuestionsForQuiz(@PathVariable("quizId") Long quizId) {
	        return quizService.getQuestionsForQuiz(quizId);
	    }
	 
	 @PostMapping("/takequiz/{quizId}")
	 public QuizVO takeQuiz(@PathVariable("quizId") long quizId, @RequestBody List<String> answers) {
		 return quizService.takeQuiz(quizId, answers);
	 }
	 
	 @GetMapping("/answers/{id}")
	 public List<String> getAnswersById(@PathVariable("id")long id){
		 return quizService.getAnswers(id);
	 }

}
