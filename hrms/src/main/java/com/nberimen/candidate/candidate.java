package com.nberimen.candidate;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nberimen.user.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate")
@Data
@NoArgsConstructor
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private int id;
	
	@Column(name = "first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@Column(name = "date_of_birth" ,nullable = true)
	private LocalDate dateOfBirth;
	
	@Column(name="nationality_id",length = 11,nullable = false,unique = false)
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
