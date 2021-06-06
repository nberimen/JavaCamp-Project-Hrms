package com.nberimen.jobadvert;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.nberimen.city.City;
import com.nberimen.employer.Employer;
import com.nberimen.jobposition.JobPosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String description;
	
	private double minSalary;
	
	private double maxSalary;
	
	@Column(nullable = false)
	private int openPositionNumber;
	
	@Column(nullable = false)
	private LocalDate deadline;
	
	@Column(nullable = false)
	private LocalDate publishingDate;
	
	@Column(nullable = false)
	private boolean active;
	
	@ManyToOne(optional = false)
	private JobPosition jobPosition;
	
	@ManyToOne(optional = false)
	private City city;
	
	@ManyToOne(optional = false)
	private Employer employer;
	
}
