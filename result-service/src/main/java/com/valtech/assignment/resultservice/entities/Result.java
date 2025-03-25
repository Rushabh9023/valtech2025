package com.valtech.assignment.resultservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Result {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "res_seq")
	@SequenceGenerator(name = "res_seq",sequenceName = "res_seq",allocationSize = 1)
	private long id;
	
	private Long quizId;
	
	private int score;
	
//	private double percent;
//	
//	private int maxScore;

	public Result() {}
	
	

	public Result(Long quizId, int score) {
		this.quizId = quizId;
		this.score = score;
//		this.maxScore = maxScore;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
