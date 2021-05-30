package com.nberimen.candidate;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.nberimen.user.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = true)
	private LocalDate dateOfBirth;
	
	@Column(length = 11,nullable = false,unique = false)
	private String nationalityId;
	
	@OneToOne(optional = false,cascade = CascadeType.ALL)
	private User user;

	public Candidate(String firstName, String lastName, LocalDate dateOfBirth, String nationalityId, User user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
		this.user = user;
	}
	
	
}
