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

	public JobAdvert(String description, double minSalary, double maxSalary, int openPositionNumber, LocalDate deadline,
			LocalDate publishingDate, boolean active, JobPosition jobPosition, City city, Employer employer) {
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openPositionNumber = openPositionNumber;
		this.deadline = deadline;
		this.publishingDate = publishingDate;
		this.active = active;
		this.jobPosition = jobPosition;
		this.city = city;
		this.employer = employer;
	}
	
	
	
}
