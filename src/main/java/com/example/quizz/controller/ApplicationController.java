package com.example.quizz.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizz.domain.Question;
import com.example.quizz.dto.QuestionDto;
import com.example.quizz.dto.ScoreDto;
import com.example.quizz.service.QuizzService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/api/v1/quizz")
@CrossOrigin
@RestController
public class ApplicationController {

	@Autowired
	QuizzService service;
	
	@GetMapping("/questions")
	public ResponseEntity<List<Question>> getQuestions() {
		return ResponseEntity.ok(service.getQuestions());
	}
	
	@ApiOperation(responseContainer = "List", value = "create questions", response = Question.class)
	@PostMapping("/create")
	public ResponseEntity<Question> createQuestion(@RequestBody QuestionDto dto) {
		return ResponseEntity.ok(service.createQuestion(dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("id") UUID id) {
		try {
			service.deleteQuestion(id);
			return ResponseEntity.ok("Question supprimée");
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/add-score")
	public ResponseEntity<String> addScore(@RequestBody ScoreDto dto) {
		service.createScore(dto);
		return ResponseEntity.ok("Score ajouté");
	}
}
