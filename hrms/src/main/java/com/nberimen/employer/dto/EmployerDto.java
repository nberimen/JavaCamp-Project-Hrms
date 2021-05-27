package com.nberimen.employer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class EmployerDto {
	
	
	@NotEmpty
	private String companyName;
	
	@NotEmpty
	private String webSite;
	
	@NotEmpty
	private String phoneNumber;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;

}
