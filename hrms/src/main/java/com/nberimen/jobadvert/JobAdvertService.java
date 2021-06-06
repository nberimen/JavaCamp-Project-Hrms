package com.nberimen.jobadvert;

import java.time.LocalDate;
import java.util.List;

import com.nberimen.jobadvert.dto.JobAdvertDto;
import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;

public interface JobAdvertService {
	Result addAdvert(JobAdvertDto advertDto);
	public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize);
	public DataResult<List<JobAdvert>> getAllByPublishingDate(int pageNo, int pageSize, LocalDate publishingDate);
	public DataResult<List<JobAdvert>> getAllByCompanyName(int pageNo, int pageSize,String companyName);
}
