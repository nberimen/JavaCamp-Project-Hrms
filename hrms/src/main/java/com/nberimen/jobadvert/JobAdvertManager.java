package com.nberimen.jobadvert;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nberimen.city.CityDao;
import com.nberimen.employer.EmployerDao;
import com.nberimen.jobadvert.dto.JobAdvertDto;
import com.nberimen.jobposition.JobPositionDao;
import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;
import com.nberimen.utilities.result.SuccessDataResult;
import com.nberimen.utilities.result.SuccessResult;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobPositionDao positionDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao,CityDao cityDao,EmployerDao employerDao,JobPositionDao positionDao) {
		this.jobAdvertDao = jobAdvertDao;
		this.cityDao=cityDao;
		this.employerDao=employerDao;
		this.positionDao=positionDao;
	}

	@Override
	public Result addAdvert(JobAdvertDto advertDto) {
		this.jobAdvertDao.save(advertDtoToAdvert(advertDto));
		return new SuccessResult("İlan eklendi.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActive(true, pageable).getContent());
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

	public JobAdvert advertDtoToAdvert(JobAdvertDto advertDto) {
		JobAdvert advert=new JobAdvert();
		advert.setActive(advertDto.isActive());
		advert.setCity(cityDao.getByCityName(advertDto.getCityName()));
		advert.setDeadline(advertDto.getDeadline());
		advert.setDescription(advertDto.getDescription());
		advert.setEmployer(employerDao.getById(advertDto.getEmployerId()));
		advert.setJobPosition(positionDao.findByPositionName(advertDto.getJobPositionName()));
		advert.setMaxSalary(advertDto.getMaxSalary());
		advert.setMinSalary(advertDto.getMinSalary());
		advert.setOpenPositionNumber(advertDto.getOpenPositionNumber());
		advert.setPublishingDate(advertDto.getPublishingDate());
		return advert;
	}
	


}
