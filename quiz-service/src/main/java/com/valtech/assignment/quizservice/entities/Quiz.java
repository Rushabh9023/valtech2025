package com.valtech.assignment.quizservice.entities;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_sequen")
    @SequenceGenerator(name = "quiz_sequen", sequenceName = "quiz_sequen", allocationSize = 1)
    private long id;

    private String topic;
    private int numberOfQuestions;

    @ElementCollection
    @CollectionTable(name="quiz_question" , joinColumns = @JoinColumn(name="quiz_id"))
    @Column(name="question_id")
    private List<Long> questionIds;  
    
    @ElementCollection
    @CollectionTable(name="quiz_answers" , joinColumns = @JoinColumn(name="quiz_id"))
    @Column(name="answers")
    private List<String> answers;
   
    
    public Quiz() {}

    public Quiz(String topic, int numberOfQuestions, List<Long> questionIds) {
        this.topic = topic;
        this.numberOfQuestions = numberOfQuestions;
        this.questionIds = questionIds;
    }
    
   

    public Quiz(String topic, int numberOfQuestions) {
        this.topic = topic;
        this.numberOfQuestions = numberOfQuestions;
    }
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public List<Long> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Long> questionIds) {
		this.questionIds = questionIds;
	}
	
	 public List<String> getAnswers() {
			return answers;
		}
	    public void setAnswers(List<String> answers) {
			this.answers = answers;
		}

}
