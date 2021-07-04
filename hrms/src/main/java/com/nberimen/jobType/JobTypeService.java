package com.nberimen.jobType;

import java.util.List;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;

public interface JobTypeService {

	public DataResult<List<JobType>> getAll();
	public Result addJobType(JobType jobType);
}
