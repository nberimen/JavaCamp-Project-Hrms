package com.nberimen.jobadvert;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nberimen.city.City;
import com.nberimen.city.CityDao;
import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.core.utilities.SuccessDataResult;
import com.nberimen.core.utilities.SuccessResult;
import com.nberimen.employer.Employer;
import com.nberimen.employer.EmployerDao;
import com.nberimen.jobadvert.dto.JobAdvertDto;
import com.nberimen.jobposition.JobPosition;
import com.nberimen.jobposition.JobPositionDao;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	private JobPositionDao jobPositionDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao,EmployerDao employerDao,JobPositionDao jobPositionDao,CityDao cityDao) {
		this.jobAdvertDao = jobAdvertDao;
		this.jobPositionDao=jobPositionDao;
		this.cityDao=cityDao;
		this.employerDao=employerDao;
	}

	@Override
	public Result addAdvert(JobAdvertDto advertDto) {
		JobPosition jobPosition=jobPositionDao.findByPositionName(advertDto.getJobPositionName());
		City city=cityDao.getByCityName(advertDto.getCityName());
		Employer employer=employerDao.getById(advertDto.getEmployerId());
		System.out.println(employer.getCompanyName());
		JobAdvert advert=new JobAdvert(
				advertDto.getDescription(),
				advertDto.getMinSalary(),
				advertDto.getMaxSalary(),
				advertDto.getOpenPositionNumber(),
				advertDto.getDeadline(),
				advertDto.getPublishingDate(),
				advertDto.isActive(),
				jobPosition,
				city,
				employer);
		this.jobAdvertDao.save(advert);
		return new SuccessResult("İlan eklendi.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActive(true, pageable).getContent());
				//.map(j -> new JobAdvertDto()).getContent()
				//);
	}


	@Override
	public DataResult<List<JobAdvert>> getAllByPublishingDate(int pageNo, int pageSize, LocalDate publishingDate) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByActiveAndPublishingDate(true,publishingDate,pageable).getContent());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByCompanyName(int pageNo, int pageSize, String companyName) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByActiveAndEmployer_CompanyName(true, companyName, pageable).getContent());
	}


	


}
