package com.nberimen.typeOfWork;

import java.util.List;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;

public interface TypeOfWorkService {
	
	public DataResult<List<TypeOfWork>> gettAll();
	public Result addTypeOfWork(TypeOfWork type);
	

}
