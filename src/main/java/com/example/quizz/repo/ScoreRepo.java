package com.example.quizz.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizz.domain.Score;

public interface ScoreRepo extends JpaRepository<Score, UUID>{

}
