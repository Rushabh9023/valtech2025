package com.valtech.training.quizservice2.vos;

import com.valtech.training.quizservice2.entities.Quiz;

public record QuizVO (long id, String topic, String username,int noOfQuestion){
	
	public Quiz to() {
		return new Quiz(topic, noOfQuestion, username);
	}
	
	public static QuizVO from(Quiz q) {
		return new QuizVO(q.getId(), q.getTopic(), q.getUsername(),q.getNoOfQuestions());
	}
}
