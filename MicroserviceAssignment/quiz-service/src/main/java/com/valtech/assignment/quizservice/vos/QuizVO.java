package com.valtech.assignment.quizservice.vos;

import java.util.List;

import com.valtech.assignment.quizservice.entities.Quiz;

public record QuizVO(Long id,String topic, int numberOfQuestions, List<Long> questionIds,List<String> answers) {

    public static QuizVO from(Quiz quiz) {
        return new QuizVO(quiz.getId(),quiz.getTopic(), quiz.getNumberOfQuestions(), quiz.getQuestionIds(),quiz.getAnswers());
    }

    public Quiz to() {
    	Quiz quiz = new Quiz(topic, numberOfQuestions);
    	quiz.setAnswers(answers);
        return quiz;
    }
}
