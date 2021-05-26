package com.nberimen.candidate.dto;

import com.nberimen.user.dto.UserDto;

import lombok.Data;

@Data
public class CandidateResponseDto {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private UserDto user;

}
