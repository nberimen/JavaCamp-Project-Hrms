package com.nberimen.jobposition;

import java.util.List;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;

public interface JobPositionService {

	public DataResult<List<JobPosition>> getAll();
	public Result add(JobPosition jobPosition);
}
