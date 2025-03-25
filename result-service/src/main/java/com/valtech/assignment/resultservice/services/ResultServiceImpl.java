package com.valtech.assignment.resultservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.resultservice.entities.Result;
import com.valtech.assignment.resultservice.repos.ResultRepo;
import com.valtech.assignment.resultservice.vos.ResultVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	private ResultRepo resultRepo;
	
	@Autowired
	private QuizClient quizClient;
	
	@Override
	public ResultVO evaluateResult(long quizId) {
		List<String> submittedAnswers = quizClient.getSubmittedAnswers(quizId);
		List<String> correctAnswers = quizClient.getCorrectAnswersforQuiz(quizId);
		
		 if (correctAnswers.size() != submittedAnswers.size()) {
	            throw new RuntimeException("Mismatch in number of answers for quiz ID: " + quizId);
	        }
		 
		   int score = 0;
	        for (int i = 0; i < correctAnswers.size(); i++) {
	            if (correctAnswers.get(i).equalsIgnoreCase(submittedAnswers.get(i))) {
	                score++;
	            }
	        }

	        Result result = new Result();
	        result.setQuizId(quizId);
	        result.setScore(score);

	       result = resultRepo.save(result);

	        return ResultVO.from(result);
	    }
		
	

}
