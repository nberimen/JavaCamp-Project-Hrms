package com.nberimen.language;

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
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	private LanguageLevel languageLevel; 
	
	@JsonIgnore
	@ManyToOne(optional = false)
	private Resume resume;
}
