package com.valtech.training.quizservice2.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.quizservice2.entities.QuestionResult;
import com.valtech.training.quizservice2.entities.Quiz;

public record QuestionResultVO (long id, String userAnswer, String result, long questionId, long quizId){

	public QuestionResult to(Quiz q) {
		QuestionResult quiz =  new QuestionResult(userAnswer, result, questionId);
		quiz.setQuiz(q);
		return quiz;
	}
	
	public static QuestionResultVO from(QuestionResult q) {
		return new QuestionResultVO(q.getId(), q.getUserAnswer(), q.getResult(), q.getQuestionId(),q.getQuiz().getId());
	}
	public static  List<QuestionResultVO> from(List<QuestionResult> qrs){
		return qrs.stream().map(q->QuestionResultVO.from(q)).collect(Collectors.toList());
	}
}
