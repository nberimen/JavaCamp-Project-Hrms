package com.nberimen.experience;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.nberimen.city.City;
import com.nberimen.jobposition.JobPosition;
import com.nberimen.resume.Resume;
import com.nberimen.utilities.JobType.JobType;
import com.nberimen.utilities.industries.Industries;
import com.nberimen.utilities.workArea.WorkArea;

import lombok.Data;

@Data
@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String companyName;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private boolean stillWorking ;
	
	private String jobDescription;
	
	@OneToOne(optional = false)
	private Industries industry;
	
	@OneToOne(optional = false)
	private WorkArea workArea;
	
	@OneToOne(optional = false)
	private JobType jobType;
	
	@OneToOne(optional = false)
	private City city;
	
	@OneToOne(optional = false)
	private JobPosition position;
	
	@ManyToOne(optional = false)
	private Resume resume;
}
