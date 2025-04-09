package com.valtech.assignment.questionservice.vos;

import com.valtech.assignment.questionservice.entities.Question;

public record QuestionVO(long id,String questionText, String option1, String option2, String option3, String option4,
		String correctOption, String topic) {
	
	public static QuestionVO from(Question question) {
	
		return new QuestionVO(question.getId(),question.getQuestionText(), question.getOption1(), 
				question.getOption2(), question.getOption3(), question.getOption4(), 
				question.getCorrectOption(), question.getTopic());
	}
	
	public Question to() {
		return new Question(questionText, option1, option2, option3, option4, correctOption, topic);
	}

}
