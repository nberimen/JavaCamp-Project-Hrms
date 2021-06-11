package com.nberimen.utilities.faculty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	
	private String facultyName;

}
