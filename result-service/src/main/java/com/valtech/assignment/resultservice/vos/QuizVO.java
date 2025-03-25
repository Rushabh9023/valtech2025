package com.valtech.assignment.resultservice.vos;

import java.util.List;

public record QuizVO(Long quizId, int numOfQuestions, List<Long> questionIds,List<String> answers) {

}
