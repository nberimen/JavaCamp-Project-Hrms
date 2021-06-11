package com.nberimen.utilities.industries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Industries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Energy-Financial Services-Health Care-Consulting-Technology-Finance-Engineering-Education...
	private String industry;
}
