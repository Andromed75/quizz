package com.example.quizz.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Question {

	@Id
	@GeneratedValue
	UUID id;
	
	String question;
	
	Integer timeToAnswer;
	
	String theme;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Answer.class)
	List<Answer> answers;
	
	
}
