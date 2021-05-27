package com.nberimen.jobposition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.ErrorResult;
import com.nberimen.core.utilities.Result;
import com.nberimen.core.utilities.SuccessDataResult;
import com.nberimen.core.utilities.SuccessResult;

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
	public Result add(JobPosition jobPosition) {
		if(jobPositionDao.findByPositionName(jobPosition.getPositionName())) {
			return new ErrorResult("Pozisyon zaten mevcut.");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Posizyon Eklendi");
	}

}
