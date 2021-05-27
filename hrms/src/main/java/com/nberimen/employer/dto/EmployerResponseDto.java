package com.nberimen.employer.dto;

import com.nberimen.user.dto.UserDto;

import lombok.Data;

@Data
public class EmployerResponseDto {

	private int id;
	private String companyName;
	private String webSite;
	private boolean verified;
	private UserDto user;
}
