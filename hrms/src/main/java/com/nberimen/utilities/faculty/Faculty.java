package com.nberimen.utilities.faculty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@JsonIgnore
	private int id;
	
	private String facultyName;

}
