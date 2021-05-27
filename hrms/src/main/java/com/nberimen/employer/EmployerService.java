package com.nberimen.employer;

import java.util.List;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.employer.dto.EmployerDto;

public interface EmployerService {

	public DataResult<List<Employer>> getAll();
	public Result register(EmployerDto employerDto);
	public DataResult<Employer> getEmployer(EmployerDto employerDto); 
}
