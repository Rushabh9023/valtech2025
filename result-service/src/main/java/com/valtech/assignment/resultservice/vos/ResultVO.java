package com.valtech.assignment.resultservice.vos;

import com.valtech.assignment.resultservice.entities.Result;

public record ResultVO(Long id,Long quizId,int score) {
	
	 public static ResultVO from(Result result) {
	        return new ResultVO(result.getId(), result.getQuizId(), result.getScore());
	    }
	 
	 public Result to() {
		 return new Result(quizId, score);
	 }

}
