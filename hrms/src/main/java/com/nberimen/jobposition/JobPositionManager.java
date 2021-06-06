package com.nberimen.jobposition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.ErrorResult;
import com.nberimen.utilities.result.Result;
import com.nberimen.utilities.result.SuccessDataResult;
import com.nberimen.utilities.result.SuccessResult;

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
		if(jobPositionDao.findByPositionName(jobPosition.getPositionName())!=null) {
			return new ErrorResult("Pozisyon zaten mevcut.");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Posizyon Eklendi");
	}

}
