package com.nberimen.employer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.nberimen.jobadvert.JobAdvert;
import com.nberimen.user.User;

import lombok.Data;

@Entity
@Data
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String companyName;
	
	@Column(nullable = false)
	private String webSite;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private boolean verified;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
}
