package com.valtech.training.quizservice2.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizservice2.entities.Quiz;
import com.valtech.training.quizservice2.repos.QuizRepo;
import com.valtech.training.quizservice2.vos.QuestionVO;
import com.valtech.training.quizservice2.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	
	@Override
	public QuizVO saveOrUpdate(QuizVO vo) {
		Quiz quiz = vo.to();
		String topic = quiz.getTopic();
		List<QuestionVO> questions = questionClient.getQuestionsByTopic(topic);
		Collections.shuffle(questions);
		questions = questions.stream().limit(quiz.getNoOfQuestions()).collect(Collectors.toList());
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}
	
	
}

