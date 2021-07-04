package com.nberimen.jobType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class JobType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Any - Permanent - Part Time - Full Time - Seasonal - Intern ...
	@Column(nullable = false, unique = true)
	private String jobType;
}
