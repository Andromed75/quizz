package com.example.quizz.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizz.domain.Question;

public interface QuestionRepo extends JpaRepository<Question, UUID> {

}
