package com.valtech.assignment.quizservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.assignment.quizservice.entities.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{

	
}
