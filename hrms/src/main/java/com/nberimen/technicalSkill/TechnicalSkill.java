package com.nberimen.technicalSkill;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nberimen.resume.Resume;

import lombok.Data;


@Entity
@Data
public class TechnicalSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	private String skillName;
	
	@Enumerated(EnumType.ORDINAL)
	private TechnicalSkillLevel skillLevel;
	
	@JsonIgnore
	@ManyToOne
	private Resume resume;
}
