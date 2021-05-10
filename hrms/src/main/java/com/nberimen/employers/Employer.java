package com.nberimen.employers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nberimen.user.User;

import lombok.Data;

@Entity
@Table(name = "employer")
@Data
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id")
	private int id;
	
	@Column(name="company_name", nullable = false)
	private String companyName;
	
	@Column(name = "web_site",nullable = false)
	private String webSite;
	
	@Column(name = "phone",nullable = false)
	private String phoneNumber;
	
	@OneToOne(optional = false)
	private User user;
	
}
