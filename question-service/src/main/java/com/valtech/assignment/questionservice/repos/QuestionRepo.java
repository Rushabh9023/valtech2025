package com.valtech.assignment.questionservice.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.assignment.questionservice.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{

	Collection<Question> findAllByTopic(String topic);
	
	

	
}
