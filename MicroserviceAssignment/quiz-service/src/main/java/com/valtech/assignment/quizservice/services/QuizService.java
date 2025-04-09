package com.valtech.assignment.quizservice.services;

import java.util.List;

import com.valtech.assignment.quizservice.vos.QuestionVO;
import com.valtech.assignment.quizservice.vos.QuizVO;

public interface QuizService {

	List<QuestionVO> getQuestionsByTopicAndNumberOfQuestions(String topic, int numOfQuestions);

	QuizVO generateQuiz(QuizVO quizVO);

	List<QuestionVO> getQuestionsForQuiz(long quizId);

	QuizVO takeQuiz(long quizId, List<String> answers);

	List<String> getAnswers(long id);

}