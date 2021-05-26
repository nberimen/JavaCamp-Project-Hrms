package com.nberimen.candidate.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CandidateDto {

	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private LocalDate dateOfBirth;
	
	@NotEmpty
	@Pattern(regexp ="^[1-9]+([0-9]{10})$")
	private String nationalityId;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
}
