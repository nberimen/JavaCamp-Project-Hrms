package com.nberimen.jobposition.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class JobPositionDto {

	@NotEmpty
	private String positionName;
}
