package com.nberimen.candidate.dto;

import java.time.LocalDate;

import com.nberimen.candidate.Candidate;
import com.nberimen.user.dto.UserDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CandidateResponseDto extends UserDto {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate dateOfBirth;

	public CandidateResponseDto(Candidate candidate) {  // Candidate to CandidateDTO
		super(candidate);
		setId(candidate.getId());
		setFirstName(candidate.getFirstName());
		setLastName(candidate.getLastName());
		setDateOfBirth(candidate.getDateOfBirth());
		
	}
}
