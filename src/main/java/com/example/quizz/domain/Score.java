package com.example.quizz.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Score {
	
	@Id
	@GeneratedValue
	UUID id;
	
	LocalDateTime scoreDate;
	
	String userName;
	
	Integer score;

}
