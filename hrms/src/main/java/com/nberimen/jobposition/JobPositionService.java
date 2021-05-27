package com.nberimen.jobposition;

import java.util.List;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.Result;

public interface JobPositionService {

	public DataResult<List<JobPosition>> getAll();
	public Result add(JobPosition jobPosition);
}
