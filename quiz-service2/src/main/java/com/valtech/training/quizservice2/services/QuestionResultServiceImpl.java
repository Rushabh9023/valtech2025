package com.valtech.training.quizservice2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizservice2.entities.QuestionResult;
import com.valtech.training.quizservice2.repos.QuestionResultRepo;
import com.valtech.training.quizservice2.repos.QuizRepo;
import com.valtech.training.quizservice2.vos.QuestionResultVO;
import com.valtech.training.quizservice2.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionResultServiceImpl {
	
	@Autowired
	private QuestionResultRepo questionResultRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Autowired
	private QuizRepo quizRepo;
	
	public QuestionResultVO saveOrUpdate(QuestionResultVO vo) {
		QuestionResult quesRes = vo.to(quizRepo.getReferenceById(vo.quizId()));
		QuestionVO quesVo = questionClient.getQuestionById(vo.questionId());
		String correctAns = quesVo.correctOption();
		if(vo.userAnswer().equals(correctAns)) {
			quesRes.setResult("correct");
		}
		else 
			quesRes.setResult("incorrect");
		
		questionResultRepo.save(quesRes);
		return QuestionResultVO.from(quesRes);
	}
	
	public List<QuestionResultVO> getAllByQuizId(long id) {
		return QuestionResultVO.from(questionResultRepo.findAllQuestionResultsByQuizId(id));
	}
	
	public QuestionResultVO getQuestionResultById(long id) {
		return QuestionResultVO.from(questionResultRepo.getReferenceById(id));
	}
	
	public List<QuestionResultVO> getAllQuestionResults() {
		
		return QuestionResultVO.from(questionResultRepo.findAll());
	}
}
