package com.nberimen.candidate;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nberimen.resume.Resume;
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
public class Candidate extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(nullable = false)
	private String firstName;
	
	@NotEmpty
	@Column(nullable = false)
	private String lastName;
	
	//@NotEmpty
	//@Column(nullable = true)
	private LocalDate dateOfBirth;
	
	@NotEmpty
	@Pattern(regexp ="^[1-9]+([0-9]{10})$")
	@Column(length = 11,nullable = false,unique = false)
	private String nationalityId;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Resume resume;
}
