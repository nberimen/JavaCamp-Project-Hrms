package com.nberimen.city;

import java.util.List;

import com.nberimen.core.utilities.DataResult;

public interface CityService {

	public DataResult<List<City>> gettAll();
}
