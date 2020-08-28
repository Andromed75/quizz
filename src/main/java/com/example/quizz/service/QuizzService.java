package com.example.quizz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizz.domain.Answer;
import com.example.quizz.domain.Question;
import com.example.quizz.domain.Score;
import com.example.quizz.dto.QuestionDto;
import com.example.quizz.dto.ScoreDto;
import com.example.quizz.repo.QuestionRepo;
import com.example.quizz.repo.ScoreRepo;

@Service
public class QuizzService {

	@Autowired
	QuestionRepo repo;
	
	@Autowired
	ScoreRepo scoreRepo;

	public List<Question> getQuestions() {
		List<Question> x = repo.findAll().stream().unordered().limit(10).collect(Collectors.toList());
		Collections.shuffle(x);
		x.stream().forEach(q -> Collections.shuffle(q.getAnswers()));
		return x;
	}
	
	public Question createQuestion(QuestionDto dto) {
		List<Answer> answerList = new ArrayList<>();
		dto.getAnswers().stream().forEach(d -> answerList.add(Answer.builder().isAnswerTrue(d.getIsAnswerTrue()).answerName(d.getAnswerName()).build()));
		return repo.save(Question.builder().question(dto.getQuestion()).answers(answerList).build());
	}

	public void deleteQuestion(UUID id) {
		repo.deleteById(id);
	}
	
	
	public void createScore(ScoreDto dto) {
		Score score = Score.builder().score(dto.getScore()).userName(dto.getNom()).build();
		scoreRepo.save(score);
	}

}
