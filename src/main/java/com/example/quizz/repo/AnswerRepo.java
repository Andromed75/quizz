package com.example.quizz.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizz.domain.Answer;

public interface AnswerRepo extends JpaRepository<Answer, UUID>{

}
