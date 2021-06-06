package com.nberimen.city;

import java.util.List;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;

public interface CityService {

	public DataResult<List<City>> gettAll();
	public Result register(City city);
}
