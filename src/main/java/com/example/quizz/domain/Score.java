package com.example.quizz.domain;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice.Local;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Score {
	
	@Id
	@GeneratedValue
	UUID id;
	
	LocalDate scoreDate;
	
	String userName;
	
	Integer score;

}
