package com.nberimen.jobposition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.ErrorResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.core.utilities.SuccessDataResult;
import com.nberimen.core.utilities.SuccessResult;
import com.nberimen.jobposition.dto.JobPositionDto;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Posizyonlar Listelendi");
	}
	@Override
	public Result add(JobPositionDto jobPositionDto) {
		if(jobPositionDao.findByPositionName(jobPositionDto.getPositionName())!=null) {
			return new ErrorResult("Pozisyon zaten mevcut.");
		}
		JobPosition jobPosition=new JobPosition();
		jobPosition.setPositionName(jobPositionDto.getPositionName());
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Posizyon Eklendi");
	}

}
