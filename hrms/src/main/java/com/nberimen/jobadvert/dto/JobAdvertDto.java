package com.nberimen.jobadvert.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class JobAdvertDto {
	
	@NotEmpty
	private String description;
	
	private double minSalary;
	
	private double maxSalary;
	

	private int openPositionNumber;
	
	//@NotEmpty
	private LocalDate deadline;
	
	//@NotEmpty
	private LocalDate publishingDate;
	
	private boolean active;
	
	@NotEmpty
	private String jobPositionName;
	
	@NotEmpty
	private String cityName;
	
	private int employerId;
}
