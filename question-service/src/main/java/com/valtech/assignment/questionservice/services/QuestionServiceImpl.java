package com.valtech.assignment.questionservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.questionservice.entities.Question;
import com.valtech.assignment.questionservice.repos.QuestionRepo;
import com.valtech.assignment.questionservice.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveOrUpdateQuestion(QuestionVO qvo) {
		return QuestionVO.from(questionRepo.save(qvo.to()));
	}
	
	@Override
	public QuestionVO getQuestion(long id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getAllQuestions(){
		return questionRepo.findAll().stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}
	
	@Override
	public List<QuestionVO> findAllByTopic(String topic) {
		return questionRepo.findAllByTopic(topic).stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}
	
	  @Override
	public List<QuestionVO> getQuestionsByIds(List<Long> ids) {
	        List<Question> questions = questionRepo.findAllById(ids);
	        
	        return questions.stream().map(QuestionVO::from).collect(Collectors.toList());
	    }

}
