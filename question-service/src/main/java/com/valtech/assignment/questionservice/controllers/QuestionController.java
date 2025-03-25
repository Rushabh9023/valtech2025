package com.valtech.assignment.questionservice.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.assignment.questionservice.services.QuestionService;
import com.valtech.assignment.questionservice.vos.QuestionVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
 
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	@GetMapping("/{id}")
	public QuestionVO getQuestionById(@PathVariable("id") long id){
		return questionService.getQuestion(id);
	  }
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO queVO) {
		return questionService.saveOrUpdateQuestion(queVO);
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> findAllByTopic(@PathVariable("topic") String topic){
		return questionService.findAllByTopic(topic);
	  }
	
	 @GetMapping("/ids/{ids}")
	    public List<QuestionVO> getQuestionsByIds(@PathVariable("ids") String ids) {
		 List<Long> listOfIds = Arrays.stream(ids.split(","))
                 .map(Long::parseLong)
                 .collect(Collectors.toList());
	        return questionService.getQuestionsByIds(listOfIds);
	      }
	 
	
	
	
}
