package com.nberimen.employer;

import java.util.List;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;

public interface EmployerService {

	public DataResult<List<Employer>> getAll();
	public Result register(Employer employer);
}
