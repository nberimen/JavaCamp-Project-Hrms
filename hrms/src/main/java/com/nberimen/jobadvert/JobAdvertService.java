package com.nberimen.jobadvert;

import java.time.LocalDate;
import java.util.List;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.jobadvert.dto.JobAdvertDto;

public interface JobAdvertService {
	Result addAdvert(JobAdvertDto advert);
	public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize);
	public DataResult<List<JobAdvert>> getAllByPublishingDate(int pageNo, int pageSize, LocalDate publishingDate);
	public DataResult<List<JobAdvert>> getAllByCompanyName(int pageNo, int pageSize,String companyName);
}
