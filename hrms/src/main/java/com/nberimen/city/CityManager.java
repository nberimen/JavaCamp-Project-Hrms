package com.nberimen.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;
import com.nberimen.utilities.result.SuccessDataResult;
import com.nberimen.utilities.result.SuccessResult;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> gettAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler Listelendi.");
	}

	@Override
	public Result register(City city) {
		cityDao.save(city);
		return new SuccessResult("Şehir Eklendi") ;
	}

}
