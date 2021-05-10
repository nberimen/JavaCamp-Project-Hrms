package com.nberimen.candidate;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nberimen.user.User;

import lombok.Data;

@Entity
@Table(name = "candidate")
@Data
public class candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private int id;
	
	@Column(name = "first_name",nullable = false,unique = true)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@Column(name = "date_of_birth" ,nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(name="nationality_id",length = 11,nullable = false,unique = true)
	private String nationalityId;
	
	@OneToOne(optional = false)
	private User user;
}
