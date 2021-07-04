package com.nberimen.typeOfWork;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;
import com.nberimen.utilities.result.SuccessDataResult;
import com.nberimen.utilities.result.SuccessResult;

@Service
public class TypeOfWorkManager implements TypeOfWorkService {

	@Autowired
	private TypeOfWorkDao typeOfWorkDao;
	
	@Override
	public DataResult<List<TypeOfWork>> gettAll() {
		return new SuccessDataResult<List<TypeOfWork>>(this.typeOfWorkDao.findAll());
	}

	@Override
	public Result addTypeOfWork(TypeOfWork type) {
		this.typeOfWorkDao.save(type);
		return new SuccessResult("Çalışma Türü eklendi.");
	}

}
