package com.nberimen.jobadvert;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nberimen.jobposition.JobPosition;

import lombok.Data;

@Entity
@Table(name = "job_advert")
@Data
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = true)
	private String description;
	
	@Column(name="min_salary",nullable = false)
	private double minSalary;
	
	@Column(name="max_salary",nullable = false)
	private double maxSalary;
	
	private int position;
	
	@Column(nullable = true)
	private LocalDate deadline;
	
	@OneToOne(optional = false)
	private JobPosition jobPosition;
	
}
