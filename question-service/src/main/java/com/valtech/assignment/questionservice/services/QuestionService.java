package com.valtech.assignment.questionservice.services;

import java.util.List;

import com.valtech.assignment.questionservice.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdateQuestion(QuestionVO qvo);

	QuestionVO getQuestion(long id);

	List<QuestionVO> getAllQuestions();

	List<QuestionVO> findAllByTopic(String topic);

}