package com.nberimen.resume;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nberimen.education.Education;
import com.nberimen.experience.Experience;
import com.nberimen.language.Language;
import com.nberimen.technicalSkill.TechnicalSkill;

import lombok.Data;

@Entity
@Data
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
		
	private String profileImage;
	
	private String githubAccount;
	
	private String linkedinAccount;
	
	private String summaryInformation;
	
	@OrderBy("stillStudying DESC, graduationDate DESC")
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
	private List<Education> education;
	
	@OrderBy("stillWorking DESC, startDate DESC")
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
	private List<TechnicalSkill> technicalSkills;
	
	
	

}
