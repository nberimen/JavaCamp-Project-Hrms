package com.nberimen.utilities.JobType;

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
	private String jobType;
}
