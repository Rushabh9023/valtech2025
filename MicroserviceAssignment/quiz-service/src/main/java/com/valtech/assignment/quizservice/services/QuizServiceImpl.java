package com.valtech.assignment.quizservice.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.valtech.assignment.quizservice.entities.Quiz;
import com.valtech.assignment.quizservice.repos.QuizRepo;
import com.valtech.assignment.quizservice.vos.QuestionVO;
import com.valtech.assignment.quizservice.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {
	
	

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionClient questionClient;



    @Override
	public List<QuestionVO> getQuestionsByTopicAndNumberOfQuestions(String topic, int numOfQuestions) {
    	List<QuestionVO> allQuestions = questionClient.getQuestionsByTopic(topic);
        
        if (allQuestions.size() < numOfQuestions) {
            throw new RuntimeException("Not enough questions available for topic: " + topic);
        }
        System.out.println("Before Shuffle ==============>"+allQuestions);
        Collections.shuffle(allQuestions); 
        System.out.println("after Shuffle ********************"+allQuestions);
        System.out.println("^^^^^^^^^^^^^^^^^^"+allQuestions.stream().limit(numOfQuestions).collect(Collectors.toList()));
        return allQuestions.stream().limit(numOfQuestions).collect(Collectors.toList());
    }
    
    private List<Long> getRandomQuestionIds(List<QuestionVO> allQuestions, int numOfQuestions) {
        Collections.shuffle(allQuestions);
        return allQuestions.stream().limit(numOfQuestions).map(QuestionVO::id).collect(Collectors.toList());
    }
    
//    @Override
//	public QuizVO generateQuiz(String topic, int numOfQuestions) {
//    	List<QuestionVO> allQuestions = questionClient.getQuestionsByTopic(topic);
//    	System.out.println("Fetched Questions: " + allQuestions);
//    	
//    	  if (allQuestions.size() < numOfQuestions) {
//              throw new RuntimeException("Not enough questions available for topic: " + topic);
//          }
//    	  System.out.println("*&&&&&&&&&&%^^^^^^^^^^^^^^^^^^"+allQuestions);
//            List<Long> questionIds = allQuestions.stream().limit(numOfQuestions).map(q->q.id()).collect(Collectors.toList());
//
//            Quiz quiz = new Quiz();
//            quiz.setTopic(topic);
//            quiz.setNumberOfQuestions(numOfQuestions);
//            quiz.setQuestionIds(questionIds);
//
//            quiz = quizRepo.save(quiz);   
//            return QuizVO.from(quiz);
//       
//    }
    
   
  @Override
	public QuizVO generateQuiz(QuizVO quizVO) {
	  Quiz quiz = quizVO.to();
	  String topic = quiz.getTopic();
	  int numOfQuestions = quiz.getNumberOfQuestions();
  	List<QuestionVO> allQuestions = questionClient.getQuestionsByTopic(topic);
  	System.out.println("Fetched Questions: " + allQuestions);
  	
  	  if (allQuestions.size() < numOfQuestions) {
            throw new RuntimeException("Not enough questions available for topic: " + topic);
        }
//  	  System.out.println("*&&&&&&&&&&%^^^^^^^^^^^^^^^^^^"+allQuestions);

  	  
          List<Long> questionIds = getRandomQuestionIds(allQuestions,numOfQuestions);

         
          quiz.setTopic(topic); 
          quiz.setNumberOfQuestions(numOfQuestions);
          quiz.setQuestionIds(questionIds);
          quiz.setAnswers(quizVO.answers());

          quiz = quizRepo.save(quiz);   
          return QuizVO.from(quiz);
     
  }
  
  @Override
public QuizVO takeQuiz(long quizId,List<String> answers) {
	  Quiz quiz = quizRepo.getReferenceById(quizId);
	  quiz.setAnswers(answers);
	  quiz = quizRepo.save(quiz);
	  return QuizVO.from(quiz);
  }
 
  @Override
public List<String> getAnswers(long id){
	  Quiz quiz = quizRepo.getReferenceById(id);
	  return quiz.getAnswers();
  }
    
    @Override
	public List<QuestionVO> getQuestionsForQuiz(long quizId) {
        Quiz quiz = quizRepo.getReferenceById(quizId);
        return questionClient.getQuestionsByIds(quiz.getQuestionIds());
    }
    
    
}