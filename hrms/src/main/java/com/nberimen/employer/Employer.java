package com.nberimen.employer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.nberimen.jobadvert.JobAdvert;
import com.nberimen.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Employer extends User{

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
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
}
