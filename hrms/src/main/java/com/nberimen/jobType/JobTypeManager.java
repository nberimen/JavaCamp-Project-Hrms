package com.nberimen.jobType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;
import com.nberimen.utilities.result.SuccessDataResult;
import com.nberimen.utilities.result.SuccessResult;

@Service
public class JobTypeManager implements JobTypeService {

	@Autowired
	private JobTypeDao jobTypeDao;
	
	
	@Override
	public DataResult<List<JobType>> getAll() {
		
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll());
	}

	@Override
	public Result addJobType(JobType jobType) {
		this.jobTypeDao.save(jobType);
		return new SuccessResult("İstihdam Türü eklendi.");
	}

}
