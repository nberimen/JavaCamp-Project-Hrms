package com.nberimen.education;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nberimen.language.Language;
import com.nberimen.resume.Resume;
import com.nberimen.utilities.department.Department;
import com.nberimen.utilities.faculty.Faculty;

import lombok.Data;

@Data
@Entity
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	private String schoolName;
	
	private LocalDate startDate;
	
	private LocalDate graduationDate;
	
	private boolean stillStudying;
	
	@OneToOne(optional = false)
	private Language educationLanguage;
	
	@OneToOne(optional = false)
	private Faculty faculty;
	
	@OneToOne(optional = false)
	private Department department;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	private Resume resume;
}

